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
public class Batimentc {

    private int id;
    private String designation;
    private String NombreCellule;
    private String Date_de_construction;

    public void setId(int id) {
        this.id = id;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public void setNombreCellule(String NombreCellule) {
        this.NombreCellule = NombreCellule;
    }

    public void setDate_de_construction(String Date_de_construction) {
        this.Date_de_construction = Date_de_construction;
    }

    public int getId() {
        return id;
    }

    public String getDesignation() {
        return designation;
    }

    public String getNombreCellule() {
        return NombreCellule;
    }

    public String getDate_de_construction() {
        return Date_de_construction;
    }
}
