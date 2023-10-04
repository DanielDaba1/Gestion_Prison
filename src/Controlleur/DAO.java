/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlleur;

import java.util.List;

/**
 *
 * @author Daniel
 *
 *
 */
public interface DAO<Table> {

    public void ajouter(Table entite);

    public void modifier(Table entite);

    public void supprimer(Table entite);

    public void imprimer(Table entier);

    public void annuler(Table entier);

    public List<Table> list();

    public Table get(int id);
}
