/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlleur;

import Modele.Cellulec;
import java.util.List;
import connDB.DB;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.swing.JOptionPane;

/**
 *
 * @author NATHAN
 */
public class CelluleImplementDAO implements DAO<Cellulec>{

    
    @Override
    public void ajouter(Cellulec entite) {
        try {
                Connection conn = DB.getConnection();
                String request = "INSERT INTO cellule(Designation, CapaciteMaximale, ID_Batiment) "
                        + "VALUES(?,?,?)";
                PreparedStatement st = conn.prepareStatement(request);
                st.setString(1, entite.getNom());
                st.setString(2, entite.getCapacite());
                st.setInt(3, entite.getIdBatiment());
                st.executeUpdate();
                JOptionPane.showMessageDialog(null, "Cellule ajouté avec succès");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erreur lors de l'ajout de la Cellule : " + ex.getMessage());
            }
    }

    @Override
    public void modifier(Cellulec entite) {
         try {
            Connection conn = DB.getConnection();
            String request = "UPDATE cellule SET Designation=?, CapaciteMaximal=?, ID_Batiment=? WHERE ID_Cellule=?";
            PreparedStatement st = conn.prepareStatement(request);
            st.setString(1, entite.getNom());
            st.setString(2, entite.getCapacite());
            st.setInt(3, entite.getIdBatiment());
            st.setInt(4, entite.getId()); 
            st.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cellule modifié avec succès");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erreur lors de la modification de la Cellule : " + ex.getMessage());
        }
    }

    @Override
    public void supprimer(Cellulec entite) {
            try {
                Connection conn = DB.getConnection();
                String request = "DELETE FROM cellule WHERE ID_Cellule=?";
                PreparedStatement st = conn.prepareStatement(request);
                st.setInt(1, entite.getId()); 
                st.executeUpdate();
                JOptionPane.showMessageDialog(null, "Cellule supprimé avec succès");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erreur lors de la suppression de la cellule : " + ex.getMessage());
            }
    }

    @Override
    public void imprimer(Cellulec entier) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void annuler(Cellulec entier) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Cellulec> list() {
        List<Cellulec> list = new ArrayList<Cellulec>();
        try{
            Connection conn = DB.getConnection();
            String rqt = "SELECT * FROM cellule";
            PreparedStatement pr = conn.prepareStatement(rqt);
            ResultSet rs = pr.executeQuery();
            while(rs.next()){
                Cellulec bl = new Cellulec();
                bl.setId(rs.getInt("ID_Cellule"));
                bl.setNom(rs.getString("Designation"));
                bl.setCapacite(rs.getString("CapaciteMaximale"));
                bl.setIdBatiment(rs.getInt("ID_Batiment"));
                
                list.add(bl);
                
            }
        }catch(Exception ex){
             JOptionPane.showMessageDialog(null, "error");
        }
        return list;
    }

    // Ajouter une méthode pour obtenir le nombre total de cellule.
public int getTotalCellulec() {
    List<Cellulec> list = list(); // Obtenir la liste complète des cellule.
    return list.size(); // Retourner la taille de la liste, c'est-à-dire le nombre total de cellule.
}
    
    @Override
    public Cellulec get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    
}
