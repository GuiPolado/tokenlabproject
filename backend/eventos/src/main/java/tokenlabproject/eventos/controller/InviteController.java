/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tokenlabproject.eventos.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tokenlabproject.eventos.model.Convite;
import tokenlabproject.eventos.model.Evento;
import tokenlabproject.eventos.service.ConviteService;
import tokenlabproject.eventos.service.EventoService;
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
    
    @CrossOrigin
    @GetMapping("/user-invites/{login}")
    public String userEvents(@PathVariable(value = "login") String convidado) throws JsonProcessingException {
        ConviteService pu = ServiceFactory.getConviteService();
        EventoService sv = ServiceFactory.getEventoService();
        ObjectMapper objectMapper = new ObjectMapper();
        List<Evento> eventos = new ArrayList<>();
        List<Long> convites = pu.findAllByConvidado(convidado);
        for(long idEvento : convites){
            Evento evento = new Evento();
            evento = sv.findByID(idEvento);
            eventos.add(evento);
        }
        String eventAsString = objectMapper.writeValueAsString(eventos);
        return eventAsString;
    }
}
