/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Funcionario;
import Modelo.Veiculo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

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
      public void Alterar_Veiculo(Veiculo v){
        String sql = "UPDATE Veiculo SET Marca = ?, Tipo = ?, Lugares = ?"
                + "WHERE codigo = ?";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
             ps.setString(1, v.getMarca());
            ps.setString(2, v.getTipo());
            ps.setInt(3, v.getLugares());
          
           
            
            if(ps.executeUpdate() > 0){
                JOptionPane.showMessageDialog(null,"Veiculo Atualizado com Sucesso!");
            }else{
                JOptionPane.showMessageDialog(null,"Erro ao Atualizar o Veiculo!");
            }
        } catch (Exception e) {
           e.getMessage();
        }
    }
       public Veiculo Consultar(int cod){
        int c = cod;
         Veiculo f = new Veiculo();
         
        try {
            
            String sql = "SELECT Idveiculo, marca, lugares,tipo FROM veiculos WHERE Idveiculo =  "+c+"";
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
           
            
            if(rs != null){
                while(rs.next()){
                                      
                    f.setCodigo(rs.getInt(1));
                    f.setMarca(rs.getString(2));
                    f.setLugares(rs.getInt(3));
                    f.setTipo(rs.getString(4));
                    
                }
            }
        } catch (Exception e) {
            e.getMessage();
        }
        if(f.getCodigo() == cod){
            JOptionPane.showMessageDialog(null, "Veiculo encontrado com sucesso!");
        }else{
        JOptionPane.showMessageDialog(null, "Veiculo Não encontrado");    
        }
        return f;
    }
         public List<Veiculo> ListarVeiculos(){
        String sql = "SELECT Idveiculo, marca, lugares,tipo FROM veiculos";
        List<Veiculo> lista = new ArrayList<Veiculo>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while(rs.next()){
                    Veiculo f = new Veiculo();
                     f.setCodigo(rs.getInt(1));
                    f.setMarca(rs.getString(2));
                    f.setLugares(rs.getInt(3));
                    f.setTipo(rs.getString(4));
                }
                return lista;
            }else{
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }
         public List<Veiculo> Pesquisar_Cod_Veiculo(int codigo){
        String sql = "SELECT  iIdveiculo, marca, lugares,tipo FROM veiculos WHERE iIdveiculo = '" + codigo + "'" ;
        List<Veiculo> lista = new ArrayList<Veiculo>();
        
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while(rs.next()){
                    Veiculo f = new Veiculo();
                         f.setCodigo(rs.getInt(1));
                    f.setMarca(rs.getString(2));
                    f.setLugares(rs.getInt(3));
                    f.setTipo(rs.getString(4));
                    
                    lista.add(f);
                }
            return lista;
            }else{
                return null;
            }
        } catch (Exception e){
            return null;
        }
    }
}
