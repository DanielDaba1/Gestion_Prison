/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlleur;

import connDB.DB;
import Modele.Loginc;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author NATHAN
 */
public class LoginImplementeDAO implements DAO<Loginc>{

    @Override
    public void ajouter(Loginc entite) {
            try{
                Connection conn = DB.getConnection();
                String request = "insert into user(nom, password, fonction) values(?,?,?)";
                PreparedStatement st = conn.prepareStatement(request);
                st.setString(1, entite.getNom());
                st.setString(2, entite.getPassword());
                st.setString(3, entite.getFonction());
                st.executeUpdate();
                JOptionPane.showMessageDialog(null, "utilisateur ajouter");
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null, "error");
            }
    }

    @Override
    public void modifier(Loginc entite) {
        try {
            Connection conn = DB.getConnection();
            String request = "update user set nom=?, password=?, fonction=? where id=?";
            PreparedStatement st = conn.prepareStatement(request);
            st.setString(1, entite.getNom());
            st.setString(2, entite.getPassword());
            st.setString(3, entite.getFonction());
            st.setInt(4, entite.getId()); 
            st.executeUpdate();
            JOptionPane.showMessageDialog(null, "Utilisateur modifié");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erreur lors de la modification");
        }
    }

    @Override
    public void supprimer(Loginc entite) {
            try {
                Connection conn = DB.getConnection();
                String request = "delete from user where id=?";
                PreparedStatement st = conn.prepareStatement(request);
                st.setInt(1, entite.getId()); 
                st.executeUpdate();
                JOptionPane.showMessageDialog(null, "Utilisateur supprimé");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erreur lors de la suppression");
            }
    }

    @Override
    public List<Loginc> list() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Loginc get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void imprimer(Loginc entier) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void annuler(Loginc entier) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    
}
