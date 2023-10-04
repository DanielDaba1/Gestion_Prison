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
public class Prisonnierc {

    private int id;
    private String RE;
    private String nom;
    private String prenom;
    private String dateNaissance;
    private String lieuNaissance;
    private String genre;
    private String profession;
    private String dateEntree;
    private String dateSortie;
    private String motif;
    private String etat;
    private int idCellule;
    private int idAgent;
    private String origine;

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public String getMotif() {
        return motif;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public void setRE(String RE) {
        this.RE = RE;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public void setLieuNaissance(String lieuNaissance) {
        this.lieuNaissance = lieuNaissance;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public void setDateEntree(String dateEntree) {
        this.dateEntree = dateEntree;
    }

    public void setDateSortie(String dateSortie) {
        this.dateSortie = dateSortie;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public void setIdCellule(int idCellule) {
        this.idCellule = idCellule;
    }

    public void setIdAgent(int idAgent) {
        this.idAgent = idAgent;
    }

    public void setOrigine(String origine) {
        this.origine = origine;
    }

    public int getId() {
        return id;
    }

    public String getRE() {
        return RE;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public String getLieuNaissance() {
        return lieuNaissance;
    }

    public String getGenre() {
        return genre;
    }

    public String getProfession() {
        return profession;
    }

    public String getDateEntree() {
        return dateEntree;
    }

    public String getDateSortie() {
        return dateSortie;
    }

    public String getEtat() {
        return etat;
    }

    public int getIdCellule() {
        return idCellule;
    }

    public int getIdAgent() {
        return idAgent;
    }

    public String getOrigine() {
        return origine;
    }

}
