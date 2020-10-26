/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tokenlabproject.eventos.model;

/**
 *
 * @author user
 */
public class Convite {
    private long idEvento;
    private String login;
    private String convidado;
    
    public Convite() {
    }
    
    public void setIdEvento(long idEvento) {
        this.idEvento = idEvento;
    }
    
    public void setLogin(String login) {
        this.login = login;
    }
    
    public void setConvidado(String convidado) {
        this.convidado = convidado;
    }
    
    public long getIdEvento() {
        return idEvento;
    }
    
    public String getLogin() {
        return login;
    }
    
    public String getConvidado(){
        return convidado;
    }
    @Override
    public String toString() {
        return ", idEvento = " + idEvento +
                ", login = " + login + ", convidado = " + convidado;
    }
}
