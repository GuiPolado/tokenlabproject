/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tokenlabproject.eventos.service;

import java.util.List;
import tokenlabproject.eventos.model.Evento;

/**
 *
 * @author user
 */
public interface EventoService {
    boolean save(Evento evento);

    public List<Evento> findByLogin(String login);
}