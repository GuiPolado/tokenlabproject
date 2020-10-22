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
    private String login;
    private Time horaInicio;
    private Time horaFim;
    private String descricao;
    
    public Evento() {
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
}
