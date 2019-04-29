/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import Modelo.Funcionario;
import Modelo.Piloto;
import Modelo.Gerente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


/**
 *
 * @author José Iago
 */
public class FuncionarioDAO extends ExecuteSQL{
    
    public FuncionarioDAO(Connection con) {
        super(con);
    }
    public String Inserir_Funcionario(Funcionario f){
        String sql = "INSERT INTO funcionario VALUES (0,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            
            ps.setString(1, f.getNome());
            ps.setString(2, f.getSobrenome());
            ps.setString(3, f.getTelefone());
            ps.setString(4, f.getEndereco());
            ps.setString(5, f.getCargo());
            ps.setString(6, f.getCpf());
            

            
            if(ps.executeUpdate() > 0){
                return "Funcionario Cadastrado com Sucesso!";
            }else{
                return "Erro ao Cadastrar Funcionario!";
            }
        } catch (Exception e) {
            return e.getMessage();
        }
    }
     public void Alterar_Funcionario(Funcionario f){
        String sql = "UPDATE funcionario SET nome = ?, login = ?, senha = ?"
                + "WHERE codigo = ?";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
             ps.setString(1, f.getNome());
            ps.setString(2, f.getSobrenome());
            ps.setString(3, f.getTelefone());
            ps.setString(4, f.getEndereco());
            ps.setString(5, f.getCargo());
            ps.setString(6, f.getCpf());
            
            if(ps.executeUpdate() > 0){
                JOptionPane.showMessageDialog(null,"Funcionario Atualizado com Sucesso!");
            }else{
                JOptionPane.showMessageDialog(null,"Erro ao Atualizar o Funcionário!");
            }
        } catch (Exception e) {
           e.getMessage();
        }
    }
    
    public List<Funcionario> ListaComboFuncionario(){
        String sql = "SELECT nome FROM funcionario ORDER BY nome";
        List<Funcionario> lista = new ArrayList<Funcionario>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while(rs.next()){
                    Funcionario f = new Funcionario();
                    f.setNome(rs.getString(1));
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
    
    public String Excluir_Funcionario(Funcionario f){
        String sql = "DELETE FROM funcionario WHERE codigo = ?";
    
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setInt(1, f.getCodigo());
            
            if(ps.executeUpdate() > 0){
                return "Funcionário Excluído com Sucesso!";
            }else{
                return "Erro ao Excluir!";
            }
        } catch (Exception e) {
            return e.getMessage();
        }
    
    }
     public boolean checkLogin(String login,String senha) throws SQLException{
           Connection con = Conexao.AbrirConexao();
           PreparedStatement stmt = null;
           ResultSet rs= null;
           boolean check = false; 
           try { 
               stmt = con.prepareStatement("SELECT * FROM funcionario");
               rs = stmt.execureQuery();
               
               while(rs.next()){
                   Funcionario funcionario = new Funcionario();
                   funcionario.setId(rs.getInt("id"));
                   funcionario.setLogin(rs.getString("descricao"));
               
               }
           }
             }
     
}


