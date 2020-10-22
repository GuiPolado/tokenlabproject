/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tokenlabproject.eventos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import tokenlabproject.eventos.model.Evento;
import tokenlabproject.eventos.utils.FabricaConexao;

/**
 *
 * @author guilherme
 */
public class EventoDAOImpl implements EventoDAO{
    
    public EventoDAOImpl() {
    }

    @Override
    public boolean save(Evento evento) {
        boolean b = false;
        Connection con = null;
        PreparedStatement pstm = null;

        con = FabricaConexao.getConexao();

        if (con != null) {
            try {
                con.setAutoCommit(false);
                pstm = con.prepareStatement(INSERT_EVENTO);
                pstm.setString(1, evento.getLogin());
                pstm.setTime(2, evento.getHoraInicio());
                pstm.setTime(3, evento.getHoraFim());
                pstm.setString(4, evento.getDescricao());
                pstm.executeUpdate();
                con.commit();
                b = true;
            } catch (SQLException ex) {
                System.out.println("Message: " + ex);
            }
        }
        return b;
    }
    @Override
    public List<Evento> findAllByLogin(String login) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet res = null;
        Evento evento = null;
        List <Evento> eventos = new ArrayList();

        con = FabricaConexao.getConexao();

        if (con != null) {
            try {
                pstm = con.prepareStatement(FIND_BY_LOGIN);
                pstm.setString(1, login);
                res = pstm.executeQuery();

                while (res.next()) {
                    evento = new Evento();
                    evento.setIdEvento(res.getLong(1));
                    evento.setLogin(login);
                    evento.setHoraInicio(res.getTime(2));
                    evento.setHoraFim(res.getTime(3));
                    evento.setDescricao(res.getString(4));
                    eventos.add(evento);
                }
            } catch (SQLException ex) {
                System.out.println("Message: " + ex);
            }
        }
        return eventos;
    }
    
    @Override
    public boolean deleteByID(long idEvento) {
        boolean b = false;
        Connection con = null;
        PreparedStatement pstm = null;

        con = FabricaConexao.getConexao();

        if (con != null) {
            try {
                con.setAutoCommit(false);
                pstm = con.prepareStatement(DELETE_BY_ID);
                pstm.setLong(1, idEvento);
                pstm.executeUpdate();
                con.commit();
                b = true;
            } catch (SQLException ex) {
                System.out.println("Message: " + ex);
            }
        }
        return b;
    }
}
