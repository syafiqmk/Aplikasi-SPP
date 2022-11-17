/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author SYAFIQ
 */
public class DBConnection {
    
    // Declare global variable for user
    public static String username;
    public static String nama;
    
    public static Connection conn;
    public static Statement stm;
    
    // Database Connection Method
    public void config() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_aplikasi_spp", "root", "");
            stm = conn.createStatement();
        } catch(ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
