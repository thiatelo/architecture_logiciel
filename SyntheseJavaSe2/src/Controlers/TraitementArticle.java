/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlers;

import Dao.ConnexionBase;
import Models.ModelsArticle;
import Models.ModelsUtilisateur;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class TraitementArticle {
    
       //1 Ajout Utilisateur
    
    public void Ajout(ModelsArticle ma){
    
        // connexion a  la base de donnés
    ConnexionBase cb = new ConnexionBase();
    
    cb.conn();
    
    // Requet SQL
    
    String req = "Insert into article(art) values ('" + ma.getText()+ "')";
     
    //  Execution de la requete
        try {
            cb.Stat.executeUpdate(req);
            JOptionPane.showMessageDialog(null,"Enregistrement effectuer");
        } catch (SQLException ex) {
            Logger.getLogger(TraitementUtilisateur.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
    
    //2 Modifier Utilisateur
    public void Modifier(ModelsArticle ma ){
    
        ConnexionBase cb = new ConnexionBase();
        
        cb.conn();
        
        String req = "Update article set art='"+ma.getText()+"' where id='"+ma.getId()+"'";
    
        try {
            cb.Stat.executeUpdate(req);
             JOptionPane.showMessageDialog(null,"Modification effectuer");
            
        } catch (SQLException ex) {
            Logger.getLogger(TraitementUtilisateur.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    //3 Supprimer Utilisateur
    
    public void Supp(int id){
    
        ConnexionBase cb = new ConnexionBase();
        
        cb.conn();
    
        String req= "Delete from article where id='"+id+"'";
        
        try {
            cb.Stat.executeUpdate(req);
            JOptionPane.showMessageDialog(null,"Suppression Effectuée");
        } catch (SQLException ex) {
            Logger.getLogger(TraitementUtilisateur.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    //4 Recherche par Id
    
    //5 Liste Article 
    
    }
}
