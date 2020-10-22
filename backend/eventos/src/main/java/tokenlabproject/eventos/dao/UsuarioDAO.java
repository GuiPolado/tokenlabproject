/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tokenlabproject.eventos.dao;

import tokenlabproject.eventos.model.Usuario;

/**
 *
 * @author guilherme
 */
public interface UsuarioDAO {

    final String INSERT_USUARIO = "INSERT INTO Usuario(" 
            + "login, senha) VALUES(?, ?)";

    final String FIND_BY_LOGIN = "SELECT senha "
            + "FROM Usuario "
            + "WHERE login = ?";
    
    public boolean save(Usuario usuario);

    public Usuario findByLogin(String login);

}
