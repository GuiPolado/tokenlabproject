/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tokenlabproject.eventos.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tokenlabproject.eventos.model.Usuario;
import tokenlabproject.eventos.service.ServiceFactory;
import tokenlabproject.eventos.service.UsuarioService;
/**
 *
 * @author guilherme
 */
@RestController
public class LoginController {

    @CrossOrigin
    @PostMapping("/login")
    public boolean checkLogin(@RequestBody Usuario user) {
        boolean insert = false;
        UsuarioService us = ServiceFactory.getUsuarioService();
        Usuario usuario = null;

        String login = user.getLogin();
        usuario = us.findByLogin(login);

        if (usuario != null) {
            if (usuario.getSenha().equals(user.getSenha())) {
                insert = true;
            }
        }

        return insert;
    }

}
