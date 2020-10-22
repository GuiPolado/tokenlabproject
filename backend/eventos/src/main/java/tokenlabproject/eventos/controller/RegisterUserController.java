package tokenlabproject.eventos.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tokenlabproject.eventos.model.Usuario;
import tokenlabproject.eventos.service.ServiceFactory;
import tokenlabproject.eventos.service.UsuarioService;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Guilherme
 */
@RestController
public class RegisterUserController {
    @CrossOrigin
    @PostMapping("/user")
    public boolean checkUser(@RequestBody Usuario usuario) {
        boolean insert = false;
        UsuarioService us = ServiceFactory.getUsuarioService();
        String login = usuario.getLogin();
        if (us.findByLogin(login) == null) {
            Usuario novoUsuario = new Usuario();
            novoUsuario.setLogin(login);
            novoUsuario.setSenha(usuario.getSenha());
            us.save(novoUsuario);
            insert = true;
        }
        return insert;
    }
}
