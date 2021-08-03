
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
/**
 *
 * @author Carlos Eduardo
 */
public class DB {
    
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/coursejdbc";
    private static final String USER = "root";
    private static final String PASS = "147258369";

    private static Connection conn = null;
    
    public static Connection getConnection(){
        if (conn == null){
        try {
            
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL,USER,PASS);
            
        } catch (SQLException ex) {
            throw new RuntimeException("Erro na conexão", ex);
        } catch (ClassNotFoundException ex){
            throw new RuntimeException("Erro para achar classe", ex);
        }
        }
        return conn;
    }
    
    public static void closeConnection(Connection con){
        
        if(con != null){
            try {
                con.close();
            } catch (SQLException ex) {
                System.err.println("Erro: " +ex);
            }
        }   
    }
    public static void closeConnection(PreparedStatement st){
        
        if(st != null){
            try {
                st.close();
            } catch (SQLException ex) {
                System.err.println("Erro: " +ex);
            }
        }   
    }
    public static void closeConnection(Connection con, Statement stmt){
        
        if(stmt != null){
            try {
                stmt.close();
            } catch (SQLException ex) {
                System.err.println("Erro: " +ex);
            }
        }
        
        closeConnection(con);
    }
    public static void closeConnection(Connection con, PreparedStatement stmt){
        
        if(stmt != null){
            try {
                stmt.close();
            } catch (SQLException ex) {
                System.err.println("Erro: " +ex);
            }
        }
        
        closeConnection(con);
    }
    
    public static void closeConnection(Connection con, Statement stmt, ResultSet rs){
        
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException ex) {
                System.err.println("Erro: " +ex);
            }
        }
        
        closeConnection(con, stmt);
    }
}
