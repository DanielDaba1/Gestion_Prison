/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controlleur.PrisonnierImplementDAO;
import Modele.Prisonnierc;
import java.util.List;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Daniel
 */
public final class Listedetenue extends javax.swing.JInternalFrame {

    /**
     * Creates new form Listedetenue
     */
    Controlleur.RepportClass print=new Controlleur.RepportClass();
    
    public Listedetenue() {
        initComponents();
        Load_Table();
        
         // Masquer la bordure en définissant une bordure vide
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));

        // Supprimer la barre de titre
        BasicInternalFrameUI bui = (BasicInternalFrameUI) getUI();
        bui.setNorthPane(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jButton2 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ListePrisonnier = new javax.swing.JTable();
        btnPrint = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(730, 510));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 41, 730, 13));

        jButton2.setBackground(new java.awt.Color(0, 51, 51));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("+ Creer Nouveau");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(536, 12, -1, -1));

        jLabel14.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons8-list-20 (1).png"))); // NOI18N
        jLabel14.setText("Liste des detenue");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 15, -1, -1));

        ListePrisonnier.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Prisonnier", "RE", "Nom", "Prenom", "Date Naissance", "Lieu Naissance", "Date entree Prison", "Date sortie prison", "Motif Incarseration", "Etat", "Profession", "Id Cellule", "Id Agent", "Genre", "Origine"
            }
        ));
        jScrollPane1.setViewportView(ListePrisonnier);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 116, 710, 350));

        btnPrint.setBackground(new java.awt.Color(255, 255, 255));
        btnPrint.setForeground(new java.awt.Color(0, 51, 51));
        btnPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons8-print-16.png"))); // NOI18N
        btnPrint.setText("Print");
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });
        jPanel1.add(btnPrint, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 80, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 489, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Detenue d = new Detenue();
        d.setVisible(true);
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        print.listedetenue();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPrintActionPerformed

    public void Load_Table() {
        PrisonnierImplementDAO bl = new PrisonnierImplementDAO();
        List<Prisonnierc> List = bl.list();
        DefaultTableModel df = (DefaultTableModel) ListePrisonnier.getModel();
        df.setRowCount(0);
        
        List.forEach((b) -> {
            df.addRow(new Object[]{
                b.getId(),
                b.getRE(),
                b.getNom(),
                b.getPrenom(),
                b.getDateNaissance(),
                b.getLieuNaissance(),
                b.getDateEntree(),
                b.getDateSortie(),
                b.getMotif(),
                b.getEtat(),
                b.getProfession(),
                b.getIdCellule(),
                b.getIdAgent(),
                b.getGenre(),
                b.getOrigine()
            });
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable ListePrisonnier;
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
