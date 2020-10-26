/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tokenlabproject.eventos.dao;

import tokenlabproject.eventos.model.Convite;

/**
 *
 * @author guilherme
 */
public interface ConviteDAO {
    final String INSERT_CONVITE = "INSERT INTO Convite(" 
            + "idEvento, login, convidado) "
            + "VALUES(?, ?, ?)";
    
    public boolean save(Convite convite);

}
