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
            + "login, dataInicio, dataFim, horaInicio, horaFim, descricao) "
            + "VALUES(?, ?, ?, ?, ?, ?)";

    final String FIND_BY_LOGIN = "SELECT idEvento, dataInicio, dataFim,"
            + " horaInicio, horaFim, descricao "
            + "FROM Evento "
            + "WHERE login = ?";
    
    final String FIND_BY_ID = "SELECT login, dataInicio, dataFim, "
            + "horaInicio, horaFim, descricao "
            + "FROM Evento "
            + "WHERE idEvento = ?";
    
    final String DELETE_BY_ID = "DELETE FROM Evento "
            + "WHERE idEvento = ?";
    
    public boolean save(Evento evento);

    public List<Evento> findAllByLogin(String login);
    
    public boolean deleteByID(long idEvento);

    public Evento findByID(long idEvento);
}
