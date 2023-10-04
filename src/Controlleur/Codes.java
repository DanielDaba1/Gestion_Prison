
package Controlleur;

import View.Home;
import static View.Login.lbltext;
import com.toedter.calendar.JDateChooser;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Codes {

    PreparedStatement ps;
    ResultSet rs;

    public void chargementcomboxAgent(JComboBox agent) {
        try {
            ps = connDB.DB.getConnection().prepareStatement("SELECT CONCAT(Nom,' ',Prenom) AS NOMS FROM agentpenitentiaire");
            rs = ps.executeQuery();
            while (rs.next()) {
                agent.addItem(rs.getString("NOMS"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ereur" + e.getMessage());
        }
    }

    public void chargementcomboxCellule(JComboBox cellule) {
        try {
            ps = connDB.DB.getConnection().prepareStatement("SELECT DESIGNATION AS CELLULE FROM cellule");
            rs = ps.executeQuery();
            while (rs.next()) {
                cellule.addItem(rs.getString("CELLULE"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ereur" + e.getMessage());
        }
    }

    public void chargementcomboxBatiment(JComboBox batiment) {
        try {
            ps = connDB.DB.getConnection().prepareStatement("SELECT Designation AS des FROM batiment");
            rs = ps.executeQuery();
            while (rs.next()) {
                batiment.addItem(rs.getString("des"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ereur" + e.getMessage());
        }
    }

    public void chargementcomboxDetenu(JComboBox detenu) {
        try {
            ps = connDB.DB.getConnection().prepareStatement("SELECT CONCAT(Nom,' ',Prenom) AS NOMS FROM prisonnier");
            rs = ps.executeQuery();
            while (rs.next()) {
                detenu.addItem(rs.getString("NOMS"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ereur" + e.getMessage());
        }
    }

    public void getIdDetenu(JLabel IdDetenu, JComboBox detenu) {
        try {
            ps = connDB.DB.getConnection().prepareStatement("select ID_Prisonnier from prisonnier where CONCAT(Nom,' ',Prenom)='" + detenu.getSelectedItem().toString() + "'");
            rs = ps.executeQuery();
            if (rs.next()) {
                IdDetenu.setText(rs.getString("ID_Prisonnier"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erreur" + e);
        }
    }

    public void getIdBatiment(JLabel IdBat, JComboBox Batiment) {
        try {
            ps = connDB.DB.getConnection().prepareStatement("select ID_Batiment from batiment where Designation='" + Batiment.getSelectedItem().toString() + "'");
            rs = ps.executeQuery();
            if (rs.next()) {
                IdBat.setText(rs.getString("ID_Batiment"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erreur" + e);
        }
    }

    public void getIdAgent(JLabel IdAgent, JComboBox agent) {
        try {
            ps = connDB.DB.getConnection().prepareStatement("select ID_AgentPenitentiaire from agentpenitentiaire  where CONCAT(Nom,' ',Prenom)='" + agent.getSelectedItem().toString() + "'");
            rs = ps.executeQuery();
            if (rs.next()) {
                IdAgent.setText(rs.getString("ID_AgentPenitentiaire"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erreur" + e);
        }
    }

    public void getIdCellule(JLabel IdCellule, JComboBox cellule) {
        try {
            ps = connDB.DB.getConnection().prepareStatement("select ID_Cellule from cellule  where DESIGNATION='" + cellule.getSelectedItem().toString() + "'");
            rs = ps.executeQuery();
            if (rs.next()) {
                IdCellule.setText(rs.getString("ID_Cellule"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erreur" + e);
        }
    }

    public void InsertDetenu(JLabel re, JLabel IdCellule, JLabel IdAgent, JTextField txtnom, JTextField txtprenom, JComboBox etat, JTextField txtprofession, JComboBox cellule, JComboBox genre, JTextField txtlieu, JTextField txtorigine, JDateChooser dateSortie, JDateChooser naiss, JTextField motif) {
        if (txtnom.getText().isEmpty() || txtprenom.getText().isEmpty() || txtprofession.getText().isEmpty() || cellule.getSelectedItem().toString().isEmpty() || txtorigine.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please The Square Is Empty!!!");
        } else {
            try {
                ps = connDB.DB.getConnection().prepareStatement("INSERT INTO prisonnier (RE,Nom,Prenom,DateNaissance,LieuNaissance,DateEntreePrison,DateSortiePrevue,MotifIncarceration,Etat,Profession,ID_Cellule,ID_AgentPenitentiaire,genre,origine) VALUES(?,?,?,?,?,CURRENT_DATE(),?,?,?,?,?,?,?,?)");
                ps.setString(1, re.getText().toUpperCase());
                ps.setString(2, txtnom.getText().toUpperCase());
                ps.setString(3, txtprenom.getText().toUpperCase());
                ps.setString(4, ((JTextField) naiss.getDateEditor()).getText());
                ps.setString(5, txtlieu.getText().toUpperCase());
                ps.setString(6, ((JTextField) dateSortie.getDateEditor()).getText());
                ps.setString(7, motif.getText().toUpperCase());
                ps.setString(8, etat.getSelectedItem().toString());
                ps.setString(9, txtprofession.getText().toUpperCase());
                ps.setString(10, IdCellule.getText());
                ps.setString(11, IdAgent.getText());
                ps.setString(12, genre.getSelectedItem().toString());
                ps.setString(13, txtorigine.getText().toUpperCase());
                ps.execute();
                JOptionPane.showMessageDialog(null, "Saved");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error" + e.getMessage());
            }
        }

    }

    public void InsertVisite(JLabel IdDetenu, JTextField txtnom, JTextField txtprenom, JTextField txtproRelation, JTextField txtContact, JTextField txtDurree, JTextField txtAdresse) {
        if (txtnom.getText().isEmpty() || txtprenom.getText().isEmpty() || txtproRelation.getText().isEmpty() || txtAdresse.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please The Square Is Empty!!!");
        } else {
            try {
                ps = connDB.DB.getConnection().prepareStatement("INSERT INTO visiteur (Nom,Prenom,RelationPrisonnier,DateVisite,DureeVisite,NumeroTel,Adresse,ID_Prisonnier) VALUES(?,?,?,CURRENT_DATE(),?,?,?,?)");
                ps.setString(1, txtnom.getText().toUpperCase());
                ps.setString(2, txtprenom.getText().toUpperCase());
                ps.setString(3, txtproRelation.getText().toUpperCase());
                ps.setString(4, txtDurree.getText().toUpperCase());
                ps.setString(5, txtContact.getText().toUpperCase());
                ps.setString(6, txtAdresse.getText());
                ps.setString(7, IdDetenu.getText());
                ps.execute();
                JOptionPane.showMessageDialog(null, "Saved");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error" + e.getMessage());
            }
        }
    }

    public void InsertCellule(JLabel IdBat, JTextField txtnom, JTextField txtCap) {
        if (txtnom.getText().isEmpty() || txtCap.getText().isEmpty() || IdBat.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please The Square Is Empty!!!");
        } else {
            try {
                ps = connDB.DB.getConnection().prepareStatement("INSERT INTO cellule(Designation,CapaciteMaximale,ID_Batiment) VALUES(?,?,?)");
                ps.setString(1, txtnom.getText().toUpperCase());
                ps.setString(2, txtCap.getText().toUpperCase());
                ps.setString(3, IdBat.getText().toUpperCase()); 
                ps.execute();
                JOptionPane.showMessageDialog(null, "Saved");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error" + e.getMessage());
            }
        }
    }

    public void Login(JTextField user, JPasswordField pass, JFrame log) {
        if (user.getText().isEmpty() || pass.getText().isEmpty()) {
            lbltext.setText("Remplissez les casees svp!!!");
        } else {
            try {
                ps = connDB.DB.getConnection().prepareStatement("SELECT nom,password,fonction FROM user WHERE nom='" + user.getText() + "' and password='" + pass.getText() + "'");
                rs = ps.executeQuery();
                if (rs.next()) {
                    if ("COLONEL".equalsIgnoreCase(rs.getString("fonction"))) {
                        new Home().show();
                        log.hide();
                    } else if ("Inspecteur".equalsIgnoreCase(rs.getString("fonction"))) {
                        new Home().show();
                        log.hide();
                    }
                } else {
                    log.show();
                    lbltext.setText("Nom ou Mot de passe incorect!!!");
                }
            } catch (Exception e) {
                lbltext.setText("Nom ou Mot de passe incorect!!!");
            }
        }
    }
}
