/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tokenlabproject.eventos.service;

import tokenlabproject.eventos.model.Usuario;

/**
 *
 * @author guilherme
 */
public interface UsuarioService {

    boolean save(Usuario usuario);

    public Usuario findByLogin(String login);
}
