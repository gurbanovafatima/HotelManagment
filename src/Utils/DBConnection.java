/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author hp1
 */
public class DBConnection {
    
    private DBConnection() {}
    
    private static DBConnection dbConnection;
    
    public static DBConnection getDbConnection() {
        if(dbConnection == null){
            dbConnection = new DBConnection();
        }
        return dbConnection;
    }
    
    
    public Connection connectDb(){
        Connection connection = null;
        try { 
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/hotelmanagment";
            String username = "root";
            String password = "";
            connection = DriverManager.getConnection(url,username,password);
        }
        catch (SQLException ex){ 
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (ClassNotFoundException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connection;
    }
    
    public void CloseConnections(ResultSet rs,Connection conn,PreparedStatement ps){
        try{
            if (rs != null){
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        catch (SQLException e) { 
            e.printStackTrace();
        }
    }
    
}
