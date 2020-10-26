/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tokenlabproject.eventos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
    
}
