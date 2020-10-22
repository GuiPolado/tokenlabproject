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
import tokenlabproject.eventos.model.Evento;
import tokenlabproject.eventos.service.ServiceFactory;
import tokenlabproject.eventos.service.EventoService;

/**
 *
 * @author Guilherme
 */
@RestController
public class EventController {
    
    @CrossOrigin
    @PostMapping("/event-register")
    public boolean registerEvent(@RequestBody Evento evento) {
        boolean insert = false;
        EventoService ev = ServiceFactory.getEventoService();
        System.out.print(evento);
        if (ev.save(evento)) {
            insert = true;
        }
        return insert;
    }
}