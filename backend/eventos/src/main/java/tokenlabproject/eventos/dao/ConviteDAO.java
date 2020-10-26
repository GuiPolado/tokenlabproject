/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tokenlabproject.eventos.dao;

import java.util.List;
import tokenlabproject.eventos.model.Convite;

/**
 *
 * @author guilherme
 */
public interface ConviteDAO {
    final String INSERT_CONVITE = "INSERT INTO Convite(" 
            + "idEvento, login, convidado) "
            + "VALUES(?, ?, ?)";
    
    final String FIND_BY_CONVIDADO = "SELECT idEvento "
            + "FROM Convite "
            + "WHERE convidado = ?";
    
    final String DELETE = "DELETE FROM Convite "
            + "WHERE idEvento = ? "
            + "AND convidado = ?";
    
    public boolean save(Convite convite);
    
    public List<Long> findAllByConvidado(String convidado);

    public boolean delete(long idEvento, String convidado);
}
