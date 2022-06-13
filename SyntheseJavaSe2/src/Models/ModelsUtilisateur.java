/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author Robert
 */
public class ModelsUtilisateur {
    
    private int id;
    private String prenom;
    private String nom;
    private String login;
    private String password;

    public ModelsUtilisateur() {
    }

    public ModelsUtilisateur(String prenom, String nom, String login, String password) {
        this.prenom = prenom;
        this.nom = nom;
        this.login = login;
        this.password = password;
    }

    
    
    public ModelsUtilisateur(int id, String prenom, String nom, String login, String password) {
        this.id = id;
        this.prenom = prenom;
        this.nom = nom;
        this.login = login;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
