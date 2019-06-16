/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Endereco;
import Modelo.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
      public List<Endereco> Cidades(){
    //String es  = estado ;
        String sql = "SELECT nome FROM cidade WHERE estado ";
        List<Endereco> lista = new ArrayList<Endereco>();
        
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while(rs.next()){
                    Endereco f = new Endereco();
                    
                    f.setCidade(rs.getString(1));
                    
                    
                    lista.add(f);
                }
            return lista;
            }else{
                return null;
            }
        } catch (Exception e) {
            return null;
        }
        
    }
      public List<Endereco> Estados(){
       
        String sql = "SELECT nome FROM estado ";
        List<Endereco> lista = new ArrayList<Endereco>();
        
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while(rs.next()){
                    Endereco f = new Endereco();
                    
                    f.setEstado(rs.getString(1));
                    
                    
                    lista.add(f);
                }
            return lista;
            }else{
                return null;
            }
        } catch (Exception e) {
            return null;
        }
        
    }
}
