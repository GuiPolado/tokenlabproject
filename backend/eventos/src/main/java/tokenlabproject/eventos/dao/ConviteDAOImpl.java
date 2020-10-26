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
import tokenlabproject.eventos.model.Convite;
import tokenlabproject.eventos.utils.FabricaConexao;

/**
 *
 * @author guilherme
 */
public class ConviteDAOImpl implements ConviteDAO{
    public ConviteDAOImpl() {
    }

    @Override
    public boolean save(Convite convite) {
        boolean b = false;
        Connection con = null;
        PreparedStatement pstm = null;

        con = FabricaConexao.getConexao();

        if (con != null) {
            try {
                con.setAutoCommit(false);
                pstm = con.prepareStatement(INSERT_CONVITE);
                pstm.setLong(1, convite.getIdEvento());
                pstm.setString(2, convite.getLogin());
                pstm.setString(3, convite.getConvidado());
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
    public List<Long> findAllByConvidado(String convidado) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet res = null;
        List <Long> eventos = new ArrayList();

        con = FabricaConexao.getConexao();

        if (con != null) {
            try {
                pstm = con.prepareStatement(FIND_BY_CONVIDADO);
                pstm.setString(1, convidado);
                res = pstm.executeQuery();

                while (res.next()) {
                    eventos.add(res.getLong(1));
                }
            } catch (SQLException ex) {
                System.out.println("Message: " + ex);
            }
        }
        return eventos;
    }

    @Override
    public boolean delete(long idEvento, String convidado) {
        boolean b = false;
        Connection con = null;
        PreparedStatement pstm = null;

        con = FabricaConexao.getConexao();

        if (con != null) {
            try {
                con.setAutoCommit(false);
                pstm = con.prepareStatement(DELETE);
                pstm.setLong(1, idEvento);
                pstm.setString(2, convidado);
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
