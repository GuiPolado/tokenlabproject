/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tokenlabproject.eventos.dao;

import java.util.List;
import tokenlabproject.eventos.model.Evento;

/**
 *
 * @author guilherme
 */
public interface EventoDAO {
    final String INSERT_EVENTO = "INSERT INTO Evento(" 
            + "login, horaInicio, horaFim, descricao) VALUES(?, ?)";

    final String FIND_BY_LOGIN = "SELECT horaInicio, horaFim, descricao "
            + "FROM Evento "
            + "WHERE login = ?";
    
    public boolean save(Evento evento);

    public List<Evento> findByLogin(String login);
}
