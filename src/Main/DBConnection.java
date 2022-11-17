/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author SYAFIQ
 */
public class DBConnection {
    
    // Declare global variable for user
    public static String username;
    public static String nama;
    
    private static Connection conn;
    
    // Database Connection Method
    public static Connection DBConn() throws SQLException {
        if(conn == null) {
            try {
                // Variable Database
                String DB = "jdbc:mysql://localhost:3306/db_aplikasi_spp";
                String user = "";
                String pass = "";
                
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                conn = (Connection) DriverManager.getConnection(DB, user, pass);
            } catch(SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
        
        return conn;
    }
}
