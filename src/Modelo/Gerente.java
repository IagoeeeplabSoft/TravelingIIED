/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Traveling IIED
 */
public class  Gerente extends Funcionario {
    public String login;
    private String senha;
    

    public String getLogin(String login) {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha(String senha) {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

   
    
    
}
