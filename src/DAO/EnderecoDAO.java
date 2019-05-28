/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author José Iago
 */
public class EnderecoDAO  extends ExecuteSQL{
    public EnderecoDAO(Connection con) {
        super(con);
    }
     public String Inserir_Endereco(String rua, String bairro, String estado,String cidade){
        String ruaF, bairroF, estadoF, cidadeF;
        ruaF = rua;
        bairroF = bairro;
        estadoF = estado;
        cidadeF = cidade;
        
        
        String sql = "INSERT INTO funcionario VALUES'"+ruaF+"'"+bairroF+"''"+estadoF+"''"+cidadeF+"'";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            
            
            if(ps.executeUpdate() > 0){
                return "Endereço  Cadastrado com Sucesso!";
            }else{
                return "Erro ao Cadastrar Endereço!";
            }
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
