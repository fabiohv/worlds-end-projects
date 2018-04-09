/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sources;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fabio
 */
public class Conexao {
    private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USR = "system";
    private static final String PASS = "123Mudar";

    public static Connection pegaConexao(){
        try {
            return DriverManager.getConnection(URL, USR, PASS);
        } catch (SQLException ex) {
            System.out.println("Erro ao pegar a conexão: " +ex);
        }
        return null;
    }
    
    public static void fechaConexao(Connection con){
            try {
                if (con != null){
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println("Falha ao fechar a conexão: " +ex);
            }
    }
    
    public static void fechaConexao(Connection con, PreparedStatement stmt){
            
            fechaConexao(con);
            
            try {
                if (stmt != null){
                    stmt.close();
                }
            } catch (SQLException ex) {
                System.out.println("Falha ao fechar a conexão: " +ex);
            }
    }
    public static void fechaConexao(Connection con, PreparedStatement stmt, ResultSet rs){
            
            fechaConexao(con, stmt);
            
            try {
                if (rs != null){
                    rs.close();
                }
            } catch (SQLException ex) {
                System.out.println("Falha ao fechar a conexão: " +ex);
            }
    }
}