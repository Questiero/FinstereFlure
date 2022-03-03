/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finstereflure;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author Amandine S
 */
public class Interface extends javax.swing.JFrame {

    /**
     * Creates new form InterfaceBis
     */
    public Interface() {
        initComponents();
        jTitre.setIcon (new ImageIcon ("./img/logo_finstere_grand.gif"));
        jNewGame.setEnabled(false);
        jContinue.setEnabled(false);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCreditPage = new javax.swing.JFrame();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jBackCredits = new javax.swing.JButton();
        jConnexionPage = new javax.swing.JFrame();
        jBG = new javax.swing.JPanel();
        jPseudoField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jOkConnexion = new javax.swing.JButton();
        jPasswordField = new javax.swing.JPasswordField();
        jShowPassword = new javax.swing.JLabel();
        jShowButton = new javax.swing.JButton();
        jBackground = new javax.swing.JPanel();
        jTitre = new javax.swing.JLabel();
        jNewGame = new javax.swing.JButton();
        jContinue = new javax.swing.JButton();
        jPrevious = new javax.swing.JButton();
        jCredit = new javax.swing.JButton();
        jPseudo = new javax.swing.JLabel();
        jConnexion = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(0, 102, 0));

        jLabel4.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 48)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(249, 240, 118));
        jLabel4.setText("CREDITS");

        jLabel5.setText("MERCI AAAAAAAAAAAAAAAAAAAAAAAAAAAA");

        jBackCredits.setBackground(new java.awt.Color(0, 18, 2));
        jBackCredits.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        jBackCredits.setForeground(new java.awt.Color(249, 240, 118));
        jBackCredits.setText("←");
        jBackCredits.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBackCreditsMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(566, 566, 566))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(397, 397, 397)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 499, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jBackCredits)))
                .addContainerGap(384, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jBackCredits, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(99, 99, 99)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(346, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jCreditPageLayout = new javax.swing.GroupLayout(jCreditPage.getContentPane());
        jCreditPage.getContentPane().setLayout(jCreditPageLayout);
        jCreditPageLayout.setHorizontalGroup(
            jCreditPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jCreditPageLayout.setVerticalGroup(
            jCreditPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jBG.setBackground(new java.awt.Color(0, 102, 0));

        jPseudoField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPseudoFieldActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(249, 240, 118));
        jLabel1.setText("PSEUDO :");

        jLabel2.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(249, 240, 118));
        jLabel2.setText("PASSWORD :");

        jLabel3.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(249, 240, 118));
        jLabel3.setText("CONNEXION");

        jOkConnexion.setBackground(new java.awt.Color(0, 18, 2));
        jOkConnexion.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        jOkConnexion.setForeground(new java.awt.Color(249, 240, 118));
        jOkConnexion.setText("OK");
        jOkConnexion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jOkConnexionMouseClicked(evt);
            }
        });

        jShowButton.setText("?");
        jShowButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jShowButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jShowButtonMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jBGLayout = new javax.swing.GroupLayout(jBG);
        jBG.setLayout(jBGLayout);
        jBGLayout.setHorizontalGroup(
            jBGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jBGLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jBGLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jBGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jShowPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPasswordField)
                    .addComponent(jPseudoField, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGroup(jBGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jBGLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                        .addComponent(jOkConnexion, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))
                    .addGroup(jBGLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jShowButton)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jBGLayout.setVerticalGroup(
            jBGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jBGLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(38, 38, 38)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPseudoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jBGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jShowButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jShowPassword)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(jOkConnexion)
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout jConnexionPageLayout = new javax.swing.GroupLayout(jConnexionPage.getContentPane());
        jConnexionPage.getContentPane().setLayout(jConnexionPageLayout);
        jConnexionPageLayout.setHorizontalGroup(
            jConnexionPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jBG, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jConnexionPageLayout.setVerticalGroup(
            jConnexionPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jBG, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jBackground.setBackground(new java.awt.Color(0, 102, 0));

        jNewGame.setBackground(new java.awt.Color(0, 18, 2));
        jNewGame.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 39)); // NOI18N
        jNewGame.setForeground(new java.awt.Color(249, 240, 118));
        jNewGame.setText("NEW GAME");
        jNewGame.setBorder(null);

        jContinue.setBackground(new java.awt.Color(0, 18, 2));
        jContinue.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 39)); // NOI18N
        jContinue.setForeground(new java.awt.Color(249, 240, 118));
        jContinue.setText("CONTINUE");
        jContinue.setBorder(null);

        jPrevious.setBackground(new java.awt.Color(0, 18, 2));
        jPrevious.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 34)); // NOI18N
        jPrevious.setForeground(new java.awt.Color(249, 240, 118));
        jPrevious.setText("PREVIOUS CHAT");
        jPrevious.setBorder(null);

        jCredit.setBackground(new java.awt.Color(0, 18, 2));
        jCredit.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 34)); // NOI18N
        jCredit.setForeground(new java.awt.Color(249, 240, 118));
        jCredit.setText("CREDITS");
        jCredit.setBorder(null);
        jCredit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCreditMouseClicked(evt);
            }
        });

        jPseudo.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 24)); // NOI18N
        jPseudo.setForeground(new java.awt.Color(249, 240, 118));
        jPseudo.setText("Pseudo");
        jPseudo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jConnexion.setBackground(new java.awt.Color(0, 18, 2));
        jConnexion.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jConnexion.setForeground(new java.awt.Color(249, 240, 118));
        jConnexion.setText("CONNEXION");
        jConnexion.setBorder(null);
        jConnexion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jConnexionMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jBackgroundLayout = new javax.swing.GroupLayout(jBackground);
        jBackground.setLayout(jBackgroundLayout);
        jBackgroundLayout.setHorizontalGroup(
            jBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jBackgroundLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPrevious, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jContinue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jNewGame, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE))
                    .addGroup(jBackgroundLayout.createSequentialGroup()
                        .addComponent(jTitre, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)))
                .addGap(512, 512, 512))
            .addGroup(jBackgroundLayout.createSequentialGroup()
                .addGroup(jBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jBackgroundLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jCredit, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jBackgroundLayout.createSequentialGroup()
                        .addGap(1139, 1139, 1139)
                        .addGroup(jBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPseudo, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jConnexion, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jBackgroundLayout.setVerticalGroup(
            jBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jBackgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPseudo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jConnexion, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jTitre, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91, 91)
                .addComponent(jNewGame, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jContinue, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jPrevious, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 115, Short.MAX_VALUE)
                .addComponent(jCredit, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jOkConnexionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jOkConnexionMouseClicked
        // TODO add your handling code here:
        jConnexionPage.dispose();                       //ferme la fenêtre popup
        String pseudo = jPseudoField.getText();         //a revoir du coup avec objet Joueur ?
        String password = jPasswordField.getText();
        System.out.println(pseudo+" "+password);
    }//GEN-LAST:event_jOkConnexionMouseClicked

    private void jConnexionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jConnexionMouseClicked
        // TODO add your handling code here:
        jPasswordField.setText("");
        jConnexionPage.setVisible(true);
        jConnexionPage.requestFocusInWindow();
        jConnexionPage.pack();
        

    }//GEN-LAST:event_jConnexionMouseClicked

    private void jCreditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCreditMouseClicked
        // TODO add your handling code here:
        jCreditPage.setVisible(true);
        jCreditPage.requestFocusInWindow();
        jCreditPage.pack();
    }//GEN-LAST:event_jCreditMouseClicked

    private void jBackCreditsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBackCreditsMouseClicked
        // TODO add your handling code here:
        jCreditPage.dispose();
    }//GEN-LAST:event_jBackCreditsMouseClicked

    private void jPseudoFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPseudoFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPseudoFieldActionPerformed

    private void jShowButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jShowButtonMousePressed
        // TODO add your handling code here:
        String mdp = jPasswordField.getText();
        jShowPassword.setText(mdp);
    }//GEN-LAST:event_jShowButtonMousePressed

    private void jShowButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jShowButtonMouseReleased
        // TODO add your handling code here:
        jShowPassword.setText("");
    }//GEN-LAST:event_jShowButtonMouseReleased

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame menuP = new Interface();
                menuP.setVisible(true);
                menuP.setResizable(false);  //empêche la redimension
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jBG;
    private javax.swing.JButton jBackCredits;
    private javax.swing.JPanel jBackground;
    private javax.swing.JButton jConnexion;
    private javax.swing.JFrame jConnexionPage;
    private javax.swing.JButton jContinue;
    private javax.swing.JButton jCredit;
    private javax.swing.JFrame jCreditPage;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton jNewGame;
    private javax.swing.JButton jOkConnexion;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField;
    private javax.swing.JButton jPrevious;
    private javax.swing.JLabel jPseudo;
    private javax.swing.JTextField jPseudoField;
    private javax.swing.JButton jShowButton;
    private javax.swing.JLabel jShowPassword;
    private javax.swing.JLabel jTitre;
    // End of variables declaration//GEN-END:variables
}
