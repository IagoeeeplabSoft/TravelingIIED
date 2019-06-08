/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Distino;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author José Iago
 */
public class DestinoDAO extends ExecuteSQL{

public DestinoDAO(Connection con) {
        super(con);
    }
       public String Cadastrar(Distino d){
        String sql = "INSERT INTO Destinos VALUES (0,?,?,?)";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
                ps.setBytes(1, d.getFoto());
              ps.setString(2, d.getNome());
            ps.setString(3, d.getLocalizacao());
            
             return "Funcionario Cadastrado com Sucesso!";
            
        } catch (Exception e) {
            return e.getMessage();
        }
    }



    
}
