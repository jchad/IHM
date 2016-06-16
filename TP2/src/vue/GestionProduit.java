/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.io.*;
import javax.swing.JFileChooser;

/**
 *
 * @author Jordan
 */
public class GestionProduit extends javax.swing.JFrame {

    /**
     * Creates new form GestionProduit
     */
    private JFileChooser jc;
    private java.applet.AudioClip son1, son2;
    public GestionProduit() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        p_carac = new javax.swing.JPanel();
        cb_cat = new javax.swing.JComboBox<>();
        tf_libelle = new javax.swing.JTextField();
        tf_pu = new javax.swing.JTextField();
        l_libelle = new javax.swing.JLabel();
        l_cat = new javax.swing.JLabel();
        l_pu = new javax.swing.JLabel();
        bt_ajouter = new javax.swing.JButton();
        bt_supprimer = new javax.swing.JButton();
        bt_modifier = new javax.swing.JButton();
        l_libprodvide = new javax.swing.JLabel();
        sc_produit = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        bt_son1 = new javax.swing.JButton();
        bt_son2 = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        p_carac.setBorder(javax.swing.BorderFactory.createTitledBorder("Caractéristiques Produit"));

        cb_cat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Appareil Photo", "Casque Audio", "Clavier", "Disque Dur externe", "Lecture Audio", "Souris" }));
        cb_cat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_catActionPerformed(evt);
            }
        });

        tf_libelle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_libelleActionPerformed(evt);
            }
        });

        l_libelle.setText("Libellé");

        l_cat.setText("Catégorie");

        l_pu.setText("Prix Unitaire");

        bt_ajouter.setText("Ajouter");
        bt_ajouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_ajouterActionPerformed(evt);
            }
        });

        bt_supprimer.setText("Supprimer");
        bt_supprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_supprimerActionPerformed(evt);
            }
        });

        bt_modifier.setText("Modifier");
        bt_modifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_modifierActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout p_caracLayout = new javax.swing.GroupLayout(p_carac);
        p_carac.setLayout(p_caracLayout);
        p_caracLayout.setHorizontalGroup(
            p_caracLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_caracLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(p_caracLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(p_caracLayout.createSequentialGroup()
                        .addGroup(p_caracLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(l_libelle)
                            .addComponent(l_cat)
                            .addComponent(l_pu))
                        .addGap(18, 18, 18)
                        .addGroup(p_caracLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cb_cat, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_pu, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_libelle, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(p_caracLayout.createSequentialGroup()
                        .addComponent(bt_ajouter)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                        .addComponent(bt_modifier)
                        .addGap(61, 61, 61)
                        .addComponent(bt_supprimer)))
                .addContainerGap())
        );
        p_caracLayout.setVerticalGroup(
            p_caracLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_caracLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(p_caracLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_libelle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l_libelle))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(p_caracLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb_cat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l_cat))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(p_caracLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_pu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l_pu))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(p_caracLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_ajouter)
                    .addComponent(bt_supprimer)
                    .addComponent(bt_modifier))
                .addContainerGap())
        );

        l_libprodvide.setForeground(java.awt.Color.red);
        l_libprodvide.setText(" ");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Libellé", "Categorie", "Prix"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        sc_produit.setViewportView(jTable2);

        bt_son1.setText("Test son1");
        bt_son1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_son1ActionPerformed(evt);
            }
        });

        bt_son2.setText("Test son 2");
        bt_son2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_son2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(p_carac, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(l_libprodvide)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(sc_produit, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(bt_son1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bt_son2)
                .addGap(66, 66, 66))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(p_carac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(l_libprodvide)
                .addGap(18, 18, 18)
                .addComponent(sc_produit, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_son1)
                    .addComponent(bt_son2))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cb_catActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_catActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_catActionPerformed

    private void tf_libelleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_libelleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_libelleActionPerformed

    private void bt_ajouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_ajouterActionPerformed
        DefaultTableModel modele = (DefaultTableModel) jTable2.getModel();
        boolean present=false;
        l_libprodvide.setText("");
        for(int i=0;i<modele.getRowCount() && present == false ;i++){
            if(modele.getValueAt(i, 0).equals(tf_libelle.getText())){
                present=true;
            }
        }
        if (present ==true){
            l_libprodvide.setText("Objet déjà existant");            
        }else if(tf_libelle.getText().trim().length()==0 ){
            l_libprodvide.setText("Libellé non renseigné");
        }else if(tf_pu.getText().trim().length()==0){
            l_libprodvide.setText("Prix unitaire non renseigné");
        }else{
            modele.addRow(new Object[]{tf_libelle.getText().trim(),cb_cat.getSelectedItem().toString(),Double.parseDouble(tf_pu.getText())});
        }   
             
    }//GEN-LAST:event_bt_ajouterActionPerformed

    private void bt_son1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_son1ActionPerformed
        java.net.URL urll = GestionProduit.class.getResource("/sons/1.wav");
        son1 = java.applet.Applet.newAudioClip(urll);
        son1.play();
    }//GEN-LAST:event_bt_son1ActionPerformed

    private void bt_son2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_son2ActionPerformed
        java.net.URL urll = GestionProduit.class.getResource("/sons/2.wav");
        son2 = java.applet.Applet.newAudioClip(urll);
        son2.play();
    }//GEN-LAST:event_bt_son2ActionPerformed

    private void bt_modifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_modifierActionPerformed
        l_libprodvide.setText("");
        if(tf_libelle.getText().trim().length()==0 ){
            l_libprodvide.setText("Libellé non renseigné");
        }else if (jTable2.getRowCount()==0){
            l_libprodvide.setText("Tableau vide");
        }else if (jTable2.getSelectedRow()==-1){
            l_libprodvide.setText("Pas de ligne sélectionnée");
        }else{
            DefaultTableModel modele = (DefaultTableModel) jTable2.getModel();
            modele.setValueAt(tf_libelle.getText().trim(),jTable2.getSelectedRow(), 0);
            modele.setValueAt(cb_cat.getSelectedItem().toString(),jTable2.getSelectedRow(), 1);
            modele.setValueAt(Double.parseDouble(tf_pu.getText()),jTable2.getSelectedRow(), 2);
        }
    }//GEN-LAST:event_bt_modifierActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        tf_libelle.setText((String)jTable2.getValueAt(jTable2.getSelectedRow(), 0));
        cb_cat.setSelectedItem((String)jTable2.getValueAt(jTable2.getSelectedRow(), 1));
        tf_pu.setText(jTable2.getValueAt(jTable2.getSelectedRow(), 2).toString());
    }//GEN-LAST:event_jTable2MouseClicked

    private void bt_supprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_supprimerActionPerformed
        l_libprodvide.setText("");
        if (jTable2.getRowCount()==0){
            l_libprodvide.setText("Tableau vide");
        }else if (jTable2.getSelectedRow()==-1){
            l_libprodvide.setText("Pas de ligne sélectionnée");
        }else{
            DefaultTableModel modele = (DefaultTableModel)jTable2.getModel();
            modele.removeRow(jTable2.getSelectedRow());
        }
    }//GEN-LAST:event_bt_supprimerActionPerformed

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
            java.util.logging.Logger.getLogger(GestionProduit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestionProduit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestionProduit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionProduit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestionProduit().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_ajouter;
    private javax.swing.JButton bt_modifier;
    private javax.swing.JButton bt_son1;
    private javax.swing.JButton bt_son2;
    private javax.swing.JButton bt_supprimer;
    private javax.swing.JComboBox<String> cb_cat;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel l_cat;
    private javax.swing.JLabel l_libelle;
    private javax.swing.JLabel l_libprodvide;
    private javax.swing.JLabel l_pu;
    private javax.swing.JPanel p_carac;
    private javax.swing.JScrollPane sc_produit;
    private javax.swing.JTextField tf_libelle;
    private javax.swing.JTextField tf_pu;
    // End of variables declaration//GEN-END:variables
}