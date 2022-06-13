/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ConnexionBase {
    
    String driver = "com.mysql.cj.jdbc.Driver";    
    Connection C = null;
    public Statement Stat = null;
    String Url = "jdbc:mysql://localhost/javase";
    String User = "root";
    String Password = "";
    
    public void conn(){
    
  
        try {
            //1 Chargement du driver de Mysql

            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnexionBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
        try {
            //2 Connexion avec la base de donnée

            C = DriverManager.getConnection(Url, User, Password);
        } catch (SQLException ex) {
            Logger.getLogger(ConnexionBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        try {
            //3 Création de statement

            Stat = C.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(ConnexionBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
