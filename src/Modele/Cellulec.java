/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

/**
 *
 * @author NATHAN
 */
public class Cellulec {

    private int id;
    private String nom;
    private String Capacite;
    private int idBatiment;
    

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setCapacite(String Capacite) {
        this.Capacite = Capacite;
    }

    public void setIdBatiment(int idBatiment) {
        this.idBatiment = idBatiment;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getCapacite() {
        return Capacite;
    }

    public int getIdBatiment() {
        return idBatiment;
    }
}
