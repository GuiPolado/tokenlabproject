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
import tokenlabproject.eventos.model.Convite;
import tokenlabproject.eventos.service.ConviteService;
import tokenlabproject.eventos.service.ServiceFactory;
import tokenlabproject.eventos.service.UsuarioService;

/**
 *
 * @author guilherme
 */
@RestController
public class InviteController {
    @CrossOrigin
    @PostMapping("/event-invite")
    public int registerEvent(@RequestBody Convite convite) {
        int insert = -1;
        ConviteService cv = ServiceFactory.getConviteService();
        UsuarioService usr = ServiceFactory.getUsuarioService();
        if(usr.findByLogin(convite.getConvidado()) != null){
            if (cv.save(convite)) {
                insert = 1;
            }
            else{
                insert = 0;
            }
        }  
        return insert;
    }
}
