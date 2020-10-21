/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tokenlabproject.eventos.service;

/**
 *
 * @author guilherme
 */
public class ServiceFactory {

    public ServiceFactory() {
    }

    public static UsuarioService getUsuarioService() {
        return (UsuarioService) new UsuarioServiceImpl();
    }
}
