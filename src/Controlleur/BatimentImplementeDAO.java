/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlleur;

import Modele.Batimentc;
import connDB.DB;
import Modele.Loginc;
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
public class BatimentImplementeDAO implements DAO<Batimentc>{
    
    @Override
    public void ajouter(Batimentc entite) {
            try{
                Connection conn = DB.getConnection();
                String request = "insert into batiment(Designation, NombreCellule, Date_de_construction)"
                        + "values(?,?,?)";
                PreparedStatement st = conn.prepareStatement(request);
                st.setString(1, entite.getDesignation());
                st.setString(2, entite.getNombreCellule());
                st.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
                st.executeUpdate();
                
                JOptionPane.showMessageDialog(null, "Batiment ajouter");
            }catch(Exception ex){
                ex.printStackTrace(); // Affichez la trace de la pile pour voir l'erreur réelle.
                JOptionPane.showMessageDialog(null, "Erreur : " + ex.getMessage());             }
    }

    @Override
    public void modifier(Batimentc entite) {
             try {
            Connection conn = DB.getConnection();
            String request = "UPDATE batiment SET Designation=?, NombreCellule=?, Date_de_construction=? "
                    + "WHERE ID_Batiment=?";
            PreparedStatement st = conn.prepareStatement(request);
            st.setString(1, entite.getDesignation());
            st.setString(2, entite.getNombreCellule());
            st.setString(3, entite.getDate_de_construction());
            st.setInt(4, entite.getId()); 
            st.executeUpdate();
            JOptionPane.showMessageDialog(null, "Batiment modifié avec succès");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erreur lors de la modification de la Cellule : " + ex.getMessage());
        }
    }

    @Override
    public void supprimer(Batimentc entite) {
        try {
                Connection conn = DB.getConnection();
                String request = "delete from batiment where ID_Batiment=?";
                PreparedStatement st = conn.prepareStatement(request);
                st.setInt(1, entite.getId()); 
                st.executeUpdate();
                JOptionPane.showMessageDialog(null, "Baptiment supprimé");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erreur lors de la suppression");
            }
    }

    @Override
    
    // Modifier la méthode list() pour qu'elle retourne la liste complète des bâtiments.

public List<Batimentc> list() {
    List<Batimentc> list = new ArrayList<Batimentc>();
    try {
        Connection conn = DB.getConnection();
        String rqt = "SELECT * FROM batiment";
        PreparedStatement pr = conn.prepareStatement(rqt);
        ResultSet rs = pr.executeQuery();
        while (rs.next()) {
            Batimentc bl = new Batimentc();
            bl.setId(rs.getInt("ID_Batiment"));
            bl.setDesignation(rs.getString("Designation"));
            bl.setNombreCellule(rs.getString("NombreCellule"));
            bl.setDate_de_construction(rs.getString("Date_de_construction"));

            list.add(bl);
        }
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(null, "error");
    }
    return list;
}

// Ajouter une méthode pour obtenir le nombre total de bâtiments.
public int getTotalBatiments() {
    List<Batimentc> list = list(); // Obtenir la liste complète des bâtiments.
    return list.size(); // Retourner la taille de la liste, c'est-à-dire le nombre total de bâtiments.
}


   
    public Batimentc get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void imprimer(Batimentc entier) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void annuler(Batimentc entier) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

    
}
