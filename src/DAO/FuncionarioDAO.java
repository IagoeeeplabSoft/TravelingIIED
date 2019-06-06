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
import Tela.telaPiloto;
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
    public String Cadastrar(Funcionario f){
        
        
        String sql = "INSERT INTO funcionario VALUES (0,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
                ps.setBytes(1, f.getFoto());
              ps.setString(2, f.getNome());
            ps.setString(3, f.getSobrenome());
            ps.setString(4, f.getTelefone());
             ps.setString(5, f.getCargo());
            ps.setString(6, f.getCpf());
            ps.setString(7, f.getLogin());
            ps.setString(8, f.getSenha());
            
             return "Funcionario Cadastrado com Sucesso!";
            
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
    
    public List<Funcionario> ListaFuncionario(){
        String sql = "SELECT * FROM funcionario";
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
                            case "Piloto" :  telaPiloto  p = new telaPiloto();
         p.setVisible(true); 
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
           
    public  List<Funcionario> Perfil(Funcionario f) {
        String login, senha, cargo;
        login = f.getLogin();
        senha = f.getSenha();
        cargo = f.getCargo();
           String sql = "SELECT * FROM funcionario WHERE login =? AND senha = ? AND cargo = ? ";
           List<Funcionario> lista = new ArrayList<Funcionario>();
    
       try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while(rs.next()){
                    Funcionario fu = new Funcionario();
                   // fu.setFoto(rs.getByte[]);
                    fu.setNome(rs.getString(2));
                    fu.setSobrenome(rs.getString(3));
                    fu.setTelefone(rs.getString(4));
                    fu.setCargo(rs.getString(5));
                    fu.setCpf(rs.getString(6));
                    fu.setLogin(rs.getString(7));
                    fu.setSenha(rs.getString(8));
                    
                    lista.add(fu);
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


