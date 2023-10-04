/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlleur;

import Modele.Prisonnierc;
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
public class PrisonnierImplementDAO implements DAO<Prisonnierc>{

    @Override
    public void ajouter(Prisonnierc entite) {
            try {
                Connection conn = DB.getConnection();
                String request = "INSERT INTO prisonnier(RE, Nom, Prenom, DateNaissance, LieuNaissance, "
                        + "DateEntreePrison, DateSortiePrevue, MotifIncarceration, Etat, "
                        + "Profession, ID_Cellule, ID_AgentPenitentiaire, genre, origine) "
                        + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement st = conn.prepareStatement(request);
                st.setString(1, entite.getRE());
                st.setString(2, entite.getNom());
                st.setString(3, entite.getPrenom());
                st.setString(4, entite.getDateNaissance());
                st.setString(5, entite.getLieuNaissance());
                st.setString(6, entite.getDateEntree());
                st.setString(7, entite.getDateSortie());
                st.setString(8, entite.getMotif());
                st.setString(9, entite.getEtat());
                st.setString(10, entite.getProfession());
                st.setInt(11, entite.getIdCellule());
                st.setInt(12, entite.getIdAgent());
                st.setString(13, entite.getGenre());
                st.setString(14, entite.getOrigine());       
                st.executeUpdate();
                JOptionPane.showMessageDialog(null, "Prisonnier ajouté avec succès");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erreur lors de l'ajout du prisonnier : " + ex.getMessage());
            }
    }

    @Override
    public void modifier(Prisonnierc entite) {
        try {
            Connection conn = DB.getConnection();
            String request = "UPDATE prisonnier SET RE=?, Nom=?, Prenom=?, DateNaissance=?, LieuNaissance=?, "
                    + "Genre=?, Profession=?, DateEntreePrison=?, DateSortiePrevue=?, "
                    + "Etat=?, ID_Cellule=?, ID_AgentPenitentiaire=?, Origine=? WHERE ID_Prisonnier=?";
            PreparedStatement st = conn.prepareStatement(request);
            st.setString(1, entite.getRE());
            st.setString(2, entite.getNom());
            st.setString(3, entite.getPrenom());
            st.setString(4, entite.getDateNaissance());
            st.setString(5, entite.getLieuNaissance());
            st.setString(6, entite.getGenre());
            st.setString(7, entite.getProfession());
            st.setString(8, entite.getDateEntree());
            st.setString(9, entite.getDateSortie());
            st.setString(10, entite.getEtat());
            st.setInt(11, entite.getIdCellule());
            st.setInt(12, entite.getIdAgent());
            st.setString(13, entite.getOrigine());
            st.setInt(14, entite.getId()); 
            st.executeUpdate();
            JOptionPane.showMessageDialog(null, "Prisonnier modifié avec succès");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erreur lors de la modification du prisonnier : " + ex.getMessage());
        }
    }

    @Override
    public void supprimer(Prisonnierc entite) {
         try {
            Connection conn = DB.getConnection();
            String request = "DELETE FROM prisonnier WHERE ID_Prisonnier=?";
            PreparedStatement st = conn.prepareStatement(request);
            st.setInt(1, entite.getId());
            st.executeUpdate();
            JOptionPane.showMessageDialog(null, "Prisonnier supprimé avec succès");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erreur lors de la suppression du prisonnier : " + ex.getMessage());
        }
    }

    @Override
    public void imprimer(Prisonnierc entier) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void annuler(Prisonnierc entier) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Prisonnierc> list() {
                List<Prisonnierc> list = new ArrayList<Prisonnierc>();
        try{
            Connection conn = DB.getConnection();
            String rqt = "SELECT * FROM prisonnier";
            PreparedStatement pr = conn.prepareStatement(rqt);
            ResultSet rs = pr.executeQuery();
            while(rs.next()){
                Prisonnierc bl = new Prisonnierc();
                bl.setId(rs.getInt("ID_Prisonnier"));
                bl.setRE(rs.getString("RE"));
                bl.setNom(rs.getString("Nom"));
                bl.setPrenom(rs.getString("Prenom"));
                bl.setDateNaissance(rs.getString("DateNaissance"));
                bl.setLieuNaissance(rs.getString("LieuNaissance"));
                bl.setDateEntree(rs.getString("DateEntreePrison"));
                bl.setDateSortie(rs.getString("DateSortiePrevue"));
                bl.setMotif(rs.getString("MotifIncarceration"));
                bl.setEtat(rs.getString("Etat"));
                bl.setProfession(rs.getString("Profession"));
                bl.setIdCellule(rs.getInt("ID_Cellule"));
                bl.setIdAgent(rs.getInt("ID_AgentPenitentiaire"));
                bl.setGenre(rs.getString("Genre"));
                bl.setOrigine(rs.getString("Origine"));
                
                
                list.add(bl);
                
            }
        }catch(Exception ex){
             JOptionPane.showMessageDialog(null, "error");
        }
        return list;
    }

        // Ajouter une méthode pour obtenir le nombre total de Prisonnierc.
public int getTotalPrisonnierc() {
    List<Prisonnierc> list = list(); // Obtenir la liste complète des Prisonnierc.
    return list.size(); // Retourner la taille de la liste, c'est-à-dire le nombre total de Prisonnierc.
}
    
    
    @Override
    public Prisonnierc get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    
}
