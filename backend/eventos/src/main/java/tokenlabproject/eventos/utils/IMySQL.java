/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tokenlabproject.eventos.utils;

/**
 *
 * @author guilherme
 */
public interface IMySQL {

    final String USUARIO = "root";
    final String SENHA = "1234";
    final String URL = "jdbc:mysql://localhost:3306/TokenLabProject?useTimezone=true&serverTimezone=UTC";
    final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
}
