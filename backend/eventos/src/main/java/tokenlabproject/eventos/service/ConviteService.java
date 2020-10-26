/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tokenlabproject.eventos.service;

import java.util.List;
import tokenlabproject.eventos.model.Convite;

/**
 *
 * @author guilherme
 */
public interface ConviteService {
    boolean save(Convite convite);
    
    public List<Long> findAllByConvidado(String convidado);

    public boolean delete(long idEvento, String convidado);
}
