/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tokenlabproject.eventos.service;

import java.util.List;
import tokenlabproject.eventos.dao.DaoFactory;
import tokenlabproject.eventos.dao.EventoDAO;
import tokenlabproject.eventos.model.Evento;

/**
 *
 * @author guilherme
 */
public class EventoServiceImpl implements EventoService{

    private EventoDAO eventoDao;

    public EventoServiceImpl() {
        this.eventoDao = DaoFactory.getEventoDAO();
    }

    @Override
    public boolean save(Evento evento) {
        boolean b = false;

        if (evento != null) {
            b = this.eventoDao.save(evento);
        }

        return b;
    }

    @Override
    public List<Evento> findAllByLogin(String login) {
        return this.eventoDao.findAllByLogin(login);
    }
    
    @Override
    public boolean deleteByID(long idEvento) {
        boolean b = false;

        b = this.eventoDao.deleteByID(idEvento);

        return b;
    }
    
    @Override
    public Evento findByID(long idEvento) {
        return this.eventoDao.findByID(idEvento);
    }
}
