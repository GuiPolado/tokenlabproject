/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tokenlabproject.eventos.model;

import java.sql.Time;

/**
 *
 * @author user
 */
public class Evento {
    private long idEvento;
    private String login;
    private Time horaInicio;
    private Time horaFim;
    private String descricao;
    
    public Evento() {
    }
    
    public void setIdEvento(long idEvento) {
        this.idEvento = idEvento;
    }
    
    public void setLogin(String login) {
        this.login = login;
    }
    
    public void setHoraInicio(Time horaInicio) {
        this.horaInicio = horaInicio;
    }

    public void setHoraFim(Time horaFim) {
        this.horaFim = horaFim;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public long getIdEvento() {
        return idEvento;
    }
    
    public String getLogin() {
        return login;
    }
 
    public Time getHoraInicio() {
        return horaInicio;
    }

    public Time getHoraFim() {
        return horaFim;
    }
    
    public String getDescricao() {
        return descricao;
    }
    
    @Override
    public String toString() {
        return "login = " + login + ", horaInicio = " + horaInicio +
                ", horaFim = " + horaFim + ", descricao = " + descricao;
    }
}
