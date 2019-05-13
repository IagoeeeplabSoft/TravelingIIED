/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import static java.lang.Class.forName;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
/**
 *
 * @author Traveling IIED
 */
public class Conexao {
     public static Connection AbrirConexao(){
        Connection con = null;
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://127.0.0.1:3306/travelingiied ?useTimezone=true&serverTimezone=UTC";
        con = DriverManager.getConnection(url, "root", "");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Erro na Conexão com o banco ","TravelingIIED",JOptionPane.ERROR_MESSAGE);
            e.getMessage();
        }
        return con;
    }
    public static void FecharConexao(Connection con){
        try{
            con.close();
        }catch(Exception e ){
        System.out.println(e.getMessage());
        }
    }

    
}
