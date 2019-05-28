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
import Tela.telaGerente;
import Tela.telaVendedor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author José Iago
 */
public class FuncionarioDAO extends ExecuteSQL{
    
    public FuncionarioDAO(Connection con) {
        super(con);
    }
    public String Inserir_Funcionario(FuncionarioDAO f){
        
        
        String sql = "INSERT INTO funcionario VALUES ";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            
            
            if(ps.executeUpdate() > 0){
                return "Funcionario Cadastrado com Sucesso!";
            }else{
                return "Erro ao Cadastrar Funcionario!";
            }
        } catch (Exception e) {
            return e.getMessage();
        }
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
    public void validar(String login, String senha, String cargo ){
         Connection con = Conexao.AbrirConexao();
          
    int resultado = 0;
   String c = cargo;
    String l= login;
    String s = senha;
        try {
            String sql="SELECT login, senha FROM   funcionario WHERE login ='"+l+"' AND senha='"+s+"'";
           Statement st = con.createStatement();
           ResultSet rs = st.executeQuery(sql);
           if(rs.next()){
           resultado = 1;
           if(resultado == 1){
               
               switch(c){
                   case "Gerente" :  telaGerente  g = new telaGerente();
         g.setVisible(true); 
                           break;
                     case "Vendedor" :  telaVendedor  v = new telaVendedor();
         v.setVisible(true); 
                           break;
               }
           }
           }else{
           JOptionPane.showMessageDialog(null, "Erro Usuario não cadastrado ");
           }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro Usuario não cadastrado ");
        }
    }
           
     
}


