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
                pstm.setDate(2, evento.getDataInicio());
                pstm.setDate(3, evento.getDataFim());
                pstm.setTime(4, evento.getHoraInicio());
                pstm.setTime(5, evento.getHoraFim());
                pstm.setString(6, evento.getDescricao());
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
                    evento.setDataInicio(res.getDate(2));
                    evento.setDataFim(res.getDate(3));
                    evento.setHoraInicio(res.getTime(4));
                    evento.setHoraFim(res.getTime(5));
                    evento.setDescricao(res.getString(6));
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
    
    @Override
    public Evento findByID(long idEvento) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet res = null;
        Evento evento = null;

        con = FabricaConexao.getConexao();

        if (con != null) {
            try {
                pstm = con.prepareStatement(FIND_BY_ID);
                pstm.setLong(1, idEvento);
                res = pstm.executeQuery();

                while (res.next()) {
                    evento = new Evento();
                    evento.setIdEvento(idEvento);
                    evento.setLogin(res.getString(1));
                    evento.setDataInicio(res.getDate(2));
                    evento.setDataFim(res.getDate(3));
                    evento.setHoraInicio(res.getTime(4));
                    evento.setHoraFim(res.getTime(5));
                    evento.setDescricao(res.getString(6));
                }
            } catch (SQLException ex) {
                System.out.println("Message: " + ex);
            }
        }
        return evento;
    }
}
