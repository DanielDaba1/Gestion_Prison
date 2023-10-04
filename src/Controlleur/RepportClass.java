
package Controlleur;

import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

public class RepportClass {
   public void listebatiment() {
        try {
            JasperDesign jd = JRXmlLoader.load("D:\\Mes Projets\\desk\\Gestion_prison\\src\\Repports\\listbatiment.jrxml");
            String sql = "SELECT * FROM batiment";
            JRDesignQuery newQuery = new JRDesignQuery();
            newQuery.setText(sql);
            jd.setQuery(newQuery);
            JasperReport jr = JasperCompileManager.compileReport(jd);
            JasperPrint jp = JasperFillManager.fillReport(jr, null, connDB.DB.getConnection());
            JasperViewer.viewReport(jp, false);
        } catch (Exception exp) {
            JOptionPane.showMessageDialog(null, "erreur d'impression" + exp.getMessage());
            //alerteInformation("Message d'erreur", "erreur d'impresion"+exp.getMessage());
        }
    }
   
     public void listevisite() {
        try {
            JasperDesign jd = JRXmlLoader.load("D:\\Mes Projets\\desk\\Gestion_prison\\src\\Repports\\listvisite.jrxml");
            String sql = "SELECT `ID_Visiteur`, concat(visiteur.`Nom`,\" \", visiteur.`Prenom`) as Noms_Visiteur, `RelationPrisonnier`, `DateVisite`, `DureeVisite`, `NumeroTel`, `Adresse`, concat( prisonnier.Nom ,\" \", prisonnier.Prenom) as Noms_Detenue FROM `visiteur` inner join prisonnier on prisonnier.ID_Prisonnier = visiteur.ID_Visiteur";
            JRDesignQuery newQuery = new JRDesignQuery();
            newQuery.setText(sql);
            jd.setQuery(newQuery);
            JasperReport jr = JasperCompileManager.compileReport(jd);
            JasperPrint jp = JasperFillManager.fillReport(jr, null, connDB.DB.getConnection());
            JasperViewer.viewReport(jp, false);
        } catch (Exception exp) {
            JOptionPane.showMessageDialog(null, "erreur d'impression" + exp.getMessage());
            //alerteInformation("Message d'erreur", "erreur d'impresion"+exp.getMessage());
        }
    } 
     
       public void listedetenue() {
        try {
            JasperDesign jd = JRXmlLoader.load("D:\\Mes Projets\\desk\\Gestion_prison\\src\\Repports\\listdetenue.jrxml");
            String sql = "SELECT CONCAT(prisonnier.`RE`, '/', prisonnier.`ID_Prisonnier`, \"/\", year(now())) AS Num_RE, CONCAT(prisonnier.`Nom`, ' ', prisonnier.`Prenom`) AS Noms_Detenu, `DateNaissance`, `LieuNaissance`, `DateEntreePrison`, `DateSortiePrevue`, `MotifIncarceration`, prisonnier.`Etat`, `Profession`, `genre`, `origine`, cellule.`Designation` AS Nom_cellule, CONCAT(agentpenitentiaire.`Nom`, ' ', agentpenitentiaire.`Prenom`) AS Noms_Agent FROM prisonnier INNER JOIN cellule ON prisonnier.`ID_Cellule` = cellule.`ID_Cellule` INNER JOIN agentpenitentiaire ON prisonnier.`ID_AgentPenitentiaire` = agentpenitentiaire.`ID_AgentPenitentiaire`";
            JRDesignQuery newQuery = new JRDesignQuery();
            newQuery.setText(sql);
            jd.setQuery(newQuery);
            JasperReport jr = JasperCompileManager.compileReport(jd);
            JasperPrint jp = JasperFillManager.fillReport(jr, null, connDB.DB.getConnection());
            JasperViewer.viewReport(jp, false);
        } catch (Exception exp) {
            JOptionPane.showMessageDialog(null, "erreur d'impression" + exp.getMessage());
            //alerteInformation("Message d'erreur", "erreur d'impresion"+exp.getMessage());
        }
    }
       
            public void listeCELLULE() {
        try {
            JasperDesign jd = JRXmlLoader.load("D:\\Mes Projets\\desk\\Gestion_prison\\src\\Repports\\listecellule.jrxml");
            String sql = "select cellule.`ID_Cellule`, cellule.`Designation`, cellule.`CapaciteMaximale`, batiment.Designation as Nom_batiment from cellule inner join batiment on batiment.ID_Batiment = cellule.ID_Cellule";
            JRDesignQuery newQuery = new JRDesignQuery();
            newQuery.setText(sql);
            jd.setQuery(newQuery);
            JasperReport jr = JasperCompileManager.compileReport(jd);
            JasperPrint jp = JasperFillManager.fillReport(jr, null, connDB.DB.getConnection());
            JasperViewer.viewReport(jp, false);
        } catch (Exception exp) {
            JOptionPane.showMessageDialog(null, "erreur d'impression" + exp.getMessage());
            //alerteInformation("Message d'erreur", "erreur d'impresion"+exp.getMessage());
        }
    }
}
