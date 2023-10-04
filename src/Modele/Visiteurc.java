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
public class Visiteurc {

    private int id;
    private String nomDetenue;
    private String nomVisiteur;
    private String nom;
    private String prenom;
    private String relation;
    private String duree;
    private String contact;
    private String Adresse;
    private String dateVisite;
    private int Idprisonnier;

    public void setIdprisonnier(int Idprisonnier) {
        this.Idprisonnier = Idprisonnier;
    }

    public int getIdprisonnier() {
        return Idprisonnier;
    }

    public void setDateVisite(String dateVisite) {
        this.dateVisite = dateVisite;
    }

    public String getDateVisite() {
        return dateVisite;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNomDetenue(String nomDetenue) {
        this.nomDetenue = nomDetenue;
    }

    public void setNomVisiteur(String nomVisiteur) {
        this.nomVisiteur = nomVisiteur;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void setAdresse(String Adresse) {
        this.Adresse = Adresse;
    }

    public int getId() {
        return id;
    }

    public String getNomDetenue() {
        return nomDetenue;
    }

    public String getNomVisiteur() {
        return nomVisiteur;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getRelation() {
        return relation;
    }

    public String getDuree() {
        return duree;
    }

    public String getContact() {
        return contact;
    }

    public String getAdresse() {
        return Adresse;
    }
}
