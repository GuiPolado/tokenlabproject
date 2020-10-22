/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tokenlabproject.eventos.dao;

/**
 *
 * @author guilherme
 */
public class DaoFactory {

    private DaoFactory() {
    }

    public static UsuarioDAO getUsuarioDAO() {
        return new UsuarioDAOImpl();
    }
    
    public static EventoDAO getEventoDAO() {
        return new EventoDAOImpl();
    }

}
