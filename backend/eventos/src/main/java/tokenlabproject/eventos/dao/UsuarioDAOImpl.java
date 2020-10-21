/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tokenlabproject.eventos.dao;

import tokenlabproject.eventos.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import tokenlabproject.eventos.utils.FabricaConexao;

/**
 *
 * @author guilherme
 */
public class UsuarioDAOImpl implements UsuarioDAO{

    public UsuarioDAOImpl() {
    }

    @Override
    public boolean save(Usuario usuario) {
        boolean b = false;
        Connection con = null;
        PreparedStatement pstm = null;

        con = FabricaConexao.getConexao();

        if (con != null) {
            try {
                con.setAutoCommit(false);
                pstm = con.prepareStatement(INSERT_USUARIO);
                pstm.setString(1, usuario.getLogin());
                pstm.setString(2, usuario.getSenha());

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
    public Usuario findByLogin(String login) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet res = null;
        Usuario usuario = null;

        con = FabricaConexao.getConexao();

        if (con != null) {
            try {
                pstm = con.prepareStatement(FIND_BY_LOGIN);
                pstm.setString(1, login);
                res = pstm.executeQuery();

                while (res.next()) {
                    usuario = new Usuario();
                    usuario.setLogin(login);
                    usuario.setSenha(res.getString(1));
                }
            } catch (SQLException ex) {
                System.out.println("Message: " + ex);
            }
        }
        return usuario;
    }
}
