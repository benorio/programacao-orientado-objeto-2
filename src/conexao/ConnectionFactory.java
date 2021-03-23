/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;

import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import modelos.ConnectionModelFactory;

/**
 *
 * @author hnr
 */
public class ConnectionFactory extends ConnectionModelFactory{
    
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/gerenciador_financeiro";
    private static final String USER = "root";
    private static final String PASS = "1234";
    
    
    public Connection getConnection(){
        
        try {
            Class.forName(DRIVER);            
            return DriverManager.getConnection(URL, USER, PASS);
            
        } catch (ClassNotFoundException | SQLException ex) {            
            throw new RuntimeException("Problema na conexão: ", ex);
        }
    }
    
    public void closeConnection(Connection con){
        //VErificação
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);

        }    
        
    }
    
    public void closeConnection(Connection con, PreparedStatement stmt){
        //Verificação
        closeConnection(con);
        
        try{
            if (stmt != null){
                stmt.close();
            }        
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);

        }    
        
    }
    
    public void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs){
        closeConnection(con, stmt);
        
        try {
            if (rs != null){
                rs.close();
            }
        } catch (Exception e) {
        }
    }
}
