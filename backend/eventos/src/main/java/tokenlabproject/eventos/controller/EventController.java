/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tokenlabproject.eventos.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

        if (ev.save(evento)) {
            insert = true;
        }
        return insert;
    }
    
    @CrossOrigin
    @GetMapping("/user-events/{login}")
    public String userEvents(@PathVariable(value = "login") String login) throws JsonProcessingException {
        EventoService pu = ServiceFactory.getEventoService();
        ObjectMapper objectMapper = new ObjectMapper();
        List<Evento> eventos = pu.findAllByLogin(login);
        String eventAsString = objectMapper.writeValueAsString(eventos);
        return eventAsString;
    }
    
    @CrossOrigin
    @PostMapping("/delete/{idEvento}")
    public boolean deleteEvent(@PathVariable(value = "idEvento") long idEvento) {
        EventoService ev = ServiceFactory.getEventoService();
        ObjectMapper objectMapper = new ObjectMapper();
        return ev.deleteByID(idEvento);
    }
    
    @CrossOrigin
    @GetMapping("/event-editor/{idEvento}")
    public String getEvent(@PathVariable(value = "idEvento") long idEvento) throws JsonProcessingException {
        EventoService ev = ServiceFactory.getEventoService();
        ObjectMapper objectMapper = new ObjectMapper();
        Evento eventoAntigo = ev.findByID(idEvento);
        String eventAsString = objectMapper.writeValueAsString(eventoAntigo);
        System.out.print(eventoAntigo);
        return eventAsString;
    }
    
    @CrossOrigin
    @PostMapping("/event-att")
    public boolean attEvent(@RequestBody Evento evento) {
        boolean insert = false;
        EventoService ev = ServiceFactory.getEventoService();
        long idEvento = evento.getIdEvento();
        if(ev.deleteByID(idEvento)){
            insert = ev.save(evento);
        };
        return insert;
    }
}
