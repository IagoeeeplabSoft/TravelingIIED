/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Veiculo;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author José Iago
 */
public class VeiculoDAO extends ExecuteSQL{
    
    public VeiculoDAO(Connection con) {
        super(con);
    }
    public String Cadastrar(Veiculo v){
        String sql = "INSERT INTO Veiculos inos VALUES (0,?,?)";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
                ps.setBytes(1, v.getFoto());
              ps.setString(2, v.getTipo());
            ps.setString(3, v.getMarca());
            ps.setInt(4, v.getLugares());
            
             return "Veiculo Cadastrado com Sucesso!";
            
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
