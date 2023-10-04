/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlleur;

import Modele.Visiteurc;
import java.util.List;
import connDB.DB;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author NATHAN
 */
public class VisiteurImplementDAO implements DAO<Visiteurc>{

    @Override
    public void ajouter(Visiteurc entite) {
            try {
                Connection conn = DB.getConnection();
                String request = "INSERT INTO visiteur(Nom, Prenom, RelationPrisonnier, DateVisite, DureeVisite, "
                        + "NumeroTel, Adresse, ID_Prisonnier) "
                        + "VALUES(?,?,?,?,?,?,?,?)";
                PreparedStatement st = conn.prepareStatement(request);
                st.setString(1, entite.getNom());
                st.setString(2, entite.getPrenom());
                st.setString(3, entite.getRelation());
                st.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
                st.setString(5, entite.getDuree());
                st.setString(6, entite.getContact());
                st.setString(7, entite.getAdresse());
                st.setInt(8, entite.getIdprisonnier());
                st.executeUpdate();
                JOptionPane.showMessageDialog(null, "Visiteur ajouté avec succès");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erreur lors de l'ajout du visiteur : " + ex.getMessage());
            }
    }

    @Override
    public void modifier(Visiteurc entite) {
         try {
            Connection conn = DB.getConnection();
            String request = "UPDATE visiteur SET Nom=?, Prenom=?, RelationPrisonnier=?, DateVisite=?, "
                    + "DureeVisite=?, NumeroTel=?, Adresse=?, Id_Prisonnier=? WHERE ID_Visiteur=?";
            PreparedStatement st = conn.prepareStatement(request);
            st.setString(1, entite.getNom());
            st.setString(2, entite.getPrenom());
            st.setString(3, entite.getRelation());
            st.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
            st.setString(5, entite.getDuree());
            st.setString(6, entite.getContact());
            st.setString(7, entite.getAdresse());
            st.setInt(8, entite.getIdprisonnier());
            st.setInt(9, entite.getId()); 
            st.executeUpdate();
            JOptionPane.showMessageDialog(null, "Visiteur modifié avec succès");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erreur lors de la modification du visiteur : " + ex.getMessage());
        }
    }

    @Override
    public void supprimer(Visiteurc entite) {
            try {
                Connection conn = DB.getConnection();
                String request = "DELETE FROM visiteur WHERE ID_Visiteur=?";
                PreparedStatement st = conn.prepareStatement(request);
                st.setInt(1, entite.getId()); 
                st.executeUpdate();
                JOptionPane.showMessageDialog(null, "Visiteur supprimé avec succès");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erreur lors de la suppression du visiteur : " + ex.getMessage());
            }
    }

    @Override
    public void imprimer(Visiteurc entier) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void annuler(Visiteurc entier) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Visiteurc> list() {
        List<Visiteurc> list = new ArrayList<Visiteurc>();
        try{
            Connection conn = DB.getConnection();
            String rqt = "SELECT * FROM visiteur";
            PreparedStatement pr = conn.prepareStatement(rqt);
            ResultSet rs = pr.executeQuery();
            while(rs.next()){
                Visiteurc bl = new Visiteurc();
                bl.setId(rs.getInt("ID_Visiteur"));
                bl.setNom(rs.getString("Nom"));
                bl.setPrenom(rs.getString("Prenom"));
                bl.setRelation(rs.getString("RelationPrisonnier"));
                bl.setDateVisite(rs.getString("DateVisite"));
                bl.setDuree(rs.getString("DureeVisite"));
                bl.setContact(rs.getString("NumeroTel"));
                bl.setAdresse(rs.getString("Adresse"));
                bl.setIdprisonnier(rs.getInt("ID_Prisonnier"));
                
                
                list.add(bl);
                
            }
        }catch(Exception ex){
             JOptionPane.showMessageDialog(null, "error");
        }
        return list;
    }

            // Ajouter une méthode pour obtenir le nombre total de Visiteurc.
public int getTotalVisiteurc() {
    List<Visiteurc> list = list(); // Obtenir la liste complète des Visiteurc.
    return list.size(); // Retourner la taille de la liste, c'est-à-dire le nombre total de Visiteurc.
}
    
    @Override
    public Visiteurc get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
