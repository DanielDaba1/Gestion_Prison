/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

/**
 *
 * @author Daniel
 */
public class Loginc {

    private int id;
    private String nom;
    private String password;
    private String fonction;

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }

    public String getFonction() {
        return fonction;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPassword() {
        return password;
    }

}
