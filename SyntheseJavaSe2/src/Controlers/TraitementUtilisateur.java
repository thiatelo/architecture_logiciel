/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlers;

import Dao.ConnexionBase;
import Models.ModelsUtilisateur;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Robert
 */
public class TraitementUtilisateur {
    
    
    //1 Ajout Utilisateur
    
    public void Ajout(ModelsUtilisateur mu){
    
        // connexion a  la base de donnés
    ConnexionBase cb = new ConnexionBase();
    
    cb.conn();
    
    // Requet SQL
    
    String req = "Insert into utilisateur(prenom, nom, login, password) values ('" + mu.getPrenom() + "','" + mu.getNom() + "','" + mu.getLogin() + "', '"+ mu.getPassword() + "')";
     
    //  Execution de la requete
        try {
            cb.Stat.executeUpdate(req);
            JOptionPane.showMessageDialog(null,"Enregistrement effectuer");
        } catch (SQLException ex) {
            Logger.getLogger(TraitementUtilisateur.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
    
    //2 Modifier Utilisateur
    public void Modifier(ModelsUtilisateur mu ){
    
        ConnexionBase cb = new ConnexionBase();
        
        cb.conn();
        
        String req = "Update utilisateur set prenom='"+mu.getPrenom()+"', nom= '"+mu.getNom()+"', login= '"+mu.getLogin()+"', password='"+mu.getPassword()+"' where id='"+mu.getId()+"'";
    
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
    
        String req= "Delete from utilisateur where id='"+id+"'";
        
        try {
            cb.Stat.executeUpdate(req);
            JOptionPane.showMessageDialog(null,"Suppression Effectuée");
        } catch (SQLException ex) {
            Logger.getLogger(TraitementUtilisateur.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    //4 Recherche par Id
    public ModelsUtilisateur RecherchebyID(int id){
    
        ModelsUtilisateur mu = new ModelsUtilisateur();
        
        ConnexionBase cb = new ConnexionBase();
        
        cb.conn();
        
        String req ="Select* from utilisateur where id='"+id+"'";
        
        try { 
            ResultSet res =  cb.Stat.executeQuery(req);
            if (res.next()){
                
            mu.setId(res.getInt("id"));
            mu.setNom(res.getString("nom"));
            mu.setPrenom(res.getString("prenom"));
            mu.setLogin(res.getString("login"));
            }else{
             mu=null;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(TraitementUtilisateur.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return mu;
        
    }
    
    //5 Liste Utilisateur
    
    
    //6 Test login
    
    public boolean testlogin(String log, String pas){
        
        boolean t = false;
        
        ConnexionBase cb= new ConnexionBase();
        
        cb.conn();
        
        String req =  "Select*  from utilisateur where login='"+log+"' and password='"+pas+"'";
    
        try {
            
           ResultSet res = cb.Stat.executeQuery(req);
           while(res.next()){
               t=true;
           }
        } catch (SQLException ex) {
            Logger.getLogger(TraitementUtilisateur.class.getName()).log(Level.SEVERE, null, ex);
        }
        return t;
    }
}
