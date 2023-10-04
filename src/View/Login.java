/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import javax.swing.ImageIcon;

/**
 *
 * @author Daniel
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    Controlleur.Codes cd = new Controlleur.Codes();

    public Login() {
        initComponents();
        ImageIcon icon = new ImageIcon(this.getClass().getResource("/B2.PNG"));
        this.setIconImage(icon.getImage());
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
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        Connexion = new javax.swing.JButton();
        pass = new javax.swing.JPasswordField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        user = new javax.swing.JTextField();
        lbltext = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 36, 531, 10));

        jLabel11.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 51, 51));
        jLabel11.setText("Nom");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 110, -1, -1));

        jLabel12.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(102, 102, 102));
        jLabel12.setText("Connexion");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 8, -1, -1));

        jLabel14.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 51, 51));
        jLabel14.setText("Mot de passe");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 180, -1, -1));

        Connexion.setBackground(new java.awt.Color(0, 51, 102));
        Connexion.setForeground(new java.awt.Color(255, 255, 255));
        Connexion.setText("Se Connecter");
        Connexion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ConnexionMouseClicked(evt);
            }
        });
        Connexion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConnexionActionPerformed(evt);
            }
        });
        jPanel1.add(Connexion, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 270, 208, -1));

        pass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                passMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                passMouseExited(evt);
            }
        });
        jPanel1.add(pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 210, 208, 32));

        jLabel15.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/B1.png"))); // NOI18N
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 97, 201, 199));

        jLabel16.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons8-user-30.png"))); // NOI18N
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        user.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                userMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                userMouseExited(evt);
            }
        });
        jPanel1.add(user, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 140, 208, 30));

        lbltext.setForeground(new java.awt.Color(153, 0, 0));
        lbltext.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(lbltext, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 320, 310, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 386, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ConnexionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConnexionActionPerformed
        cd.Login(user, pass, this);
    }//GEN-LAST:event_ConnexionActionPerformed

    private void ConnexionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ConnexionMouseClicked
        // TODO add your handling code here:
//        String user = txtmatricule.getText();
//        String pass = String.valueOf(txtpassword.getText());
//        if(user.equals("admin")  && pass.equals("admin")){
//        Home d = new Home();
//        d.setVisible(true);
//        this.dispose();
//        }else{
//             JOptionPane.showMessageDialog(null, "Mot de passe incorrect");
//        }

        // Obtenez les informations saisies par l'utilisateur
//    String user = txtmatricule.getText();
//    String fonction = txtFonction.getText();
//    String pass = String.valueOf(txtpassword.getPassword());
//
//    // Vérifiez les informations d'identification par rapport à la base de données
//    try {
//        Connection conn = DB.getConnection();
//        String query = "SELECT * FROM user WHERE nom = ? AND password = ? AND fonction = ?";
//        PreparedStatement pstmt = conn.prepareStatement(query);
//        pstmt.setString(1, user);
//        pstmt.setString(2, pass);
//        pstmt.setString(3, fonction);
//        ResultSet rs = pstmt.executeQuery();
//
//        if (rs.next()) {
//            // Les informations d'identification sont correctes, ouvrez la page d'accueil
//            Home d = new Home();
//            d.setVisible(true);
//            this.dispose();
//        } else {
//            // Les informations d'identification sont incorrectes, affichez un message d'erreur
//            JOptionPane.showMessageDialog(null, "Nom d'utilisateur ou mot de passe incorrect");
//        }
//
//        // Fermez les ressources JDBC
//        rs.close();
//        pstmt.close();
//        conn.close();
//    } catch (Exception e) {
//        // Gérez les exceptions liées à la base de données
//        e.printStackTrace();
//        JOptionPane.showMessageDialog(null, "Erreur lors de la connexion à la base de données");
//    }
    }//GEN-LAST:event_ConnexionMouseClicked

    private void userMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userMouseEntered
        lbltext.setText("Enter Your UserName");
        // TODO add your handling code here:
    }//GEN-LAST:event_userMouseEntered

    private void userMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userMouseExited
        lbltext.setText("");
        // TODO add your handling code here:
    }//GEN-LAST:event_userMouseExited

    private void passMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passMouseEntered
        lbltext.setText("Enter Your Password");
        // TODO add your handling code here:
    }//GEN-LAST:event_passMouseEntered

    private void passMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passMouseExited
        lbltext.setText("");
        // TODO add your handling code here:
    }//GEN-LAST:event_passMouseExited

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Login().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Connexion;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    public static javax.swing.JLabel lbltext;
    private javax.swing.JPasswordField pass;
    private javax.swing.JTextField user;
    // End of variables declaration//GEN-END:variables
}
