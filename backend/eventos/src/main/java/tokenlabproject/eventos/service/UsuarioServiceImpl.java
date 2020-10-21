/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tokenlabproject.eventos.service;

import tokenlabproject.eventos.dao.DaoFactory;
import tokenlabproject.eventos.dao.UsuarioDAO;
import tokenlabproject.eventos.model.Usuario;

/**
 *
 * @author guilherme
 */
public class UsuarioServiceImpl implements UsuarioService {

    private UsuarioDAO usuarioDao;

    public UsuarioServiceImpl() {
        this.usuarioDao = DaoFactory.getUsuarioDAO();
    }

    @Override
    public boolean save(Usuario usuario) {
        boolean b = false;

        if (usuario != null) {
            b = this.usuarioDao.save(usuario);
        }

        return b;
    }

    @Override
    public Usuario findByLogin(String login) {
        return this.usuarioDao.findByLogin(login);
    }

}

