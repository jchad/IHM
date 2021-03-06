/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import Personnel.*;
import conteneurGenerique.Conteneur;
import java.awt.*;
import java.io.*;
import java.awt.event.*;
import java.io.File;
import javax.swing.*;

/**
 *
 * @author Jordan
 */
public class fenetreGesPer extends javax.swing.JFrame {

    /**
     * Creates new form fenetreGesPer
     */
    private Conteneur<String,Personnel> cont;
    private int total;
    private enum TypePersonnel{EMPLOYE, COMMERCIAL, DIRECTEUR};
    private TypePersonnel typePersonnel;
    private enum ModeCourant{AFFICHAGE,SAISIE, RECHERCHE};
    private ModeCourant modeCourant;
    private JTextArea ta_fc;
    private JFileChooser fc;
    
    public fenetreGesPer() {
        initComponents();
        
        cont= new Conteneur<String, Personnel>();
        total=0;
        this.modeAffichage();
        this.afficher();
        ta_fc = new JTextArea();
        fc = new JFileChooser();
    }
    
    private void modeAffichage(){
        modeCourant= ModeCourant.AFFICHAGE;
        l_mode.setText("MODE AFFICHAGE");
        bt_lancer.setVisible(false);
        tf_mat.setEnabled(false);
        tf_indem.setEnabled(false);
        tf_mb.setEnabled(false);
        tf_nbh.setEnabled(false);
        tf_nom.setEnabled(false);
        tf_pour.setEnabled(false);
        tf_taux.setEnabled(false);
        tf_tel.setEnabled(false);
        tf_ventes.setEnabled(false);
        rb_commercial.setEnabled(false);
        rb_directeur.setEnabled(false);
        rb_employe.setEnabled(false);
        l_nbElem.setText(Integer.toString(total));
        bt_rechercher.setVisible(false);
        bt_confirmer.setVisible(false);
        bt_chercher.setVisible(true);
        bt_creer.setVisible(true);
        bt_supprimer.setVisible(true);
        }
    
    private void modeRecherche(){
        modeCourant= ModeCourant.RECHERCHE;
        l_mode.setText("MODE RECHERCHE");
        bt_chercher.setVisible(false);
        bt_creer.setVisible(false);
        bt_supprimer.setVisible(false);
        this.effacer();
        bt_creer.setText("Créer");
        tf_mat.setEnabled(true);
        tf_mat.setEditable(true);
        if (!tf_mat.isFocusable())
            tf_mat.setFocusable(true);
        tf_mat.requestFocus();
        tf_indem.setEnabled(false);
        tf_mb.setEnabled(false);
        tf_nbh.setEnabled(false);
        tf_nom.setEnabled(false);
        tf_pour.setEnabled(false);
        tf_taux.setEnabled(false);
        tf_tel.setEnabled(false);
        tf_ventes.setEnabled(false);
        rb_commercial.setEnabled(false);
        rb_directeur.setEnabled(false);
        rb_employe.setEnabled(false);
        bt_lancer.setVisible(false);
        bt_rechercher.setVisible(false);
        bt_confirmer.setVisible(false);
    }
    
    private void modeSaisie(){
        modeCourant= ModeCourant.SAISIE;
        l_mode.setText("MODE SAISIE");
        tf_mat.setEnabled(false);
        bt_lancer.setVisible(false);
        rb_employe.setEnabled(true);
        rb_employe.setSelected(true); 
        typePersonnel = TypePersonnel.EMPLOYE; 
        rb_commercial.setEnabled(true);
        rb_directeur.setEnabled(true);
        bt_creer.setText("Ajouter");
        bt_creer.setEnabled(false);
        bt_creer.setToolTipText("Ajouter ce nouveau personnel");
        bt_chercher.setEnabled(false);
        bt_supprimer.setEnabled(false);
        bt_debut.setEnabled(false);
        bt_fin.setEnabled(false);
        bt_prec.setEnabled(false);
        bt_suiv.setEnabled(false);
        tf_nom.setEnabled(true);
        tf_tel.setEnabled(true);
        bt_creer.setEnabled(true);
        
    }
    private void effacer(){
        tf_indem.setText("");
        tf_mat.setText("");
        tf_mb.setText("");
        tf_nbh.setText("");
        tf_nom.setText("");
        tf_pour.setText("");
        tf_taux.setText("");
        tf_tel.setText("");
        tf_ventes.setText("");
    }
    private  void afficher(){
        this.effacer();
        l_nbElem.setText(Integer.toString(total));
        if (cont.estVide()== false){
            Personnel pers = cont.obtenir(cont.cleCourante());
            tf_mat.setText(pers.getNumPerson());
            tf_nom.setText(pers.getNomPers());
            tf_tel.setText(pers.getNumTel());
            if (pers instanceof Employe){
                tf_nbh.setText(Float.toString(((Employe)pers).getNbHeures()));
                tf_taux.setText(Float.toString(((Employe)pers).getTauxHorraire()));
                tf_mb.setText(Float.toString(((Employe)pers).calculPaie()));
            }
            if (pers instanceof Commercial){
                tf_nbh.setText(Float.toString(((Commercial)pers).getNbHeures()));
                tf_taux.setText(Float.toString(((Commercial)pers).getTauxHorraire()));
                tf_ventes.setText(Float.toString(((Commercial)pers).getTotalVentes()));
                tf_pour.setText(Float.toString(((Commercial)pers).getPourcentage()));
                tf_mb.setText(Float.toString(((Commercial)pers).calculPaie()));
            }
            if (pers instanceof Directeur){
                tf_indem.setText(Float.toString(((Directeur)pers).getIndemnités()));
                tf_mb.setText(Float.toString(((Directeur)pers).calculPaie()));
            }
        }
    }
     private void saisir(){
            bt_rechercher.setVisible(false);
            bt_confirmer.setVisible(false);
            if (typePersonnel == TypePersonnel.EMPLOYE) {
                tf_pour.setEnabled(false);
                tf_ventes.setEnabled(false);
                tf_taux.setEnabled(true);
                tf_nbh.setEnabled(true);
                tf_indem.setEnabled(false);
                tf_mb.setEnabled(false);
            } else if (typePersonnel == TypePersonnel.COMMERCIAL) {
                tf_pour.setEnabled(true);
                tf_ventes.setEnabled(true);
                tf_taux.setEnabled(true);
                tf_nbh.setEnabled(true);
                tf_indem.setEnabled(false);
                tf_mb.setEnabled(false);
            } else if (typePersonnel == TypePersonnel.DIRECTEUR) {
                tf_pour.setEnabled(false);
                tf_ventes.setEnabled(false);
                tf_taux.setEnabled(false);
                tf_nbh.setEnabled(false);
                tf_indem.setEnabled(true);
                tf_mb.setEnabled(false);
            }
        }
    private void rechercher(){
        this.modeRecherche();
        if (cont.existe(tf_mat.getText())){
            cont.positionner(tf_mat.getText());
            this.afficher();
        }
        else{
            JOptionPane jp1;
            jp1 = new JOptionPane();
            jp1.showMessageDialog(null, "Matricule inexistant", "Ok", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void ajouter(){
        String nom = tf_nom.getText();
        String tel = tf_tel.getText();
        float txh = Float.parseFloat(tf_taux.getText());
        float nbh = Float.parseFloat(tf_nbh.getText());
        float indem = Float.parseFloat(tf_indem.getText());
        float pour = Float.parseFloat(tf_pour.getText());
        float ventes = Float.parseFloat(tf_ventes.getText());
        if (typePersonnel == TypePersonnel.EMPLOYE){
            Employe emp = new Employe(nom, tel, txh, nbh);
            cont.ajouter(emp.getNumPerson(), emp);
        }else if (typePersonnel == TypePersonnel.COMMERCIAL){
            Commercial com = new Commercial(nom, tel, txh, nbh, pour, ventes);
            cont.ajouter(com.getNumPerson(),com);
        }else if (typePersonnel == TypePersonnel.DIRECTEUR){
            Directeur dir = new Directeur(nom, tel, indem);
            cont.ajouter(dir.getNumPerson(),dir);            
        }
        total++;
    }
    private void supprimer(){
        if(cont.existe(tf_mat.getText())){
            cont.supprimer(tf_mat.getText());
            total++;
        }else{
            JOptionPane jp1;
            jp1 = new JOptionPane() ;
            jp1.showMessageDialog(null,"Matricule non existant"," Erreur",JOptionPane.WARNING_MESSAGE);
            }   
    } 
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TypesEmployés = new javax.swing.ButtonGroup();
        l_img1 = new javax.swing.JLabel();
        p_infogen = new javax.swing.JPanel();
        l_mat = new javax.swing.JLabel();
        l_tel = new javax.swing.JLabel();
        l_nom = new javax.swing.JLabel();
        tf_tel = new javax.swing.JTextField();
        tf_nom = new javax.swing.JTextField();
        tf_mat = new javax.swing.JTextField();
        bt_rechercher = new javax.swing.JButton();
        bt_confirmer = new javax.swing.JButton();
        l_img2 = new javax.swing.JLabel();
        p_typeemp = new javax.swing.JPanel();
        rb_employe = new javax.swing.JRadioButton();
        rb_commercial = new javax.swing.JRadioButton();
        rb_directeur = new javax.swing.JRadioButton();
        p_calculrem = new javax.swing.JPanel();
        l_taux = new javax.swing.JLabel();
        l_nbh = new javax.swing.JLabel();
        l_indem = new javax.swing.JLabel();
        l_ventes = new javax.swing.JLabel();
        l_pour = new javax.swing.JLabel();
        l_mb = new javax.swing.JLabel();
        tf_taux = new javax.swing.JTextField();
        tf_nbh = new javax.swing.JTextField();
        tf_indem = new javax.swing.JTextField();
        tf_ventes = new javax.swing.JTextField();
        tf_pour = new javax.swing.JTextField();
        tf_mb = new javax.swing.JTextField();
        p_gestcont = new javax.swing.JPanel();
        bt_chercher = new javax.swing.JButton();
        bt_supprimer = new javax.swing.JButton();
        bt_creer = new javax.swing.JButton();
        l_nb = new javax.swing.JLabel();
        l_nbElem = new javax.swing.JLabel();
        bt_lancer = new javax.swing.JButton();
        p_nav = new javax.swing.JPanel();
        bt_debut = new javax.swing.JButton();
        bt_prec = new javax.swing.JButton();
        bt_fin = new javax.swing.JButton();
        bt_suiv = new javax.swing.JButton();
        l_mode = new javax.swing.JLabel();
        m_menubar = new javax.swing.JMenuBar();
        m_menufile = new javax.swing.JMenu();
        mi_new = new javax.swing.JMenuItem();
        mi_load = new javax.swing.JMenuItem();
        mi_save = new javax.swing.JMenuItem();
        mi_quit = new javax.swing.JMenuItem();
        m_menuhelp = new javax.swing.JMenu();
        mi_about = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("Informations générales"); // NOI18N

        l_img1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Personnel/logo1.gif"))); // NOI18N

        p_infogen.setBorder(javax.swing.BorderFactory.createTitledBorder("Informations générales"));
        p_infogen.setToolTipText("Informations génrérales");
        p_infogen.setName("Informations générales"); // NOI18N

        l_mat.setText("Matricule");

        l_tel.setText("Tel");

        l_nom.setText("Nom");

        tf_tel.setToolTipText("");
        tf_tel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_telActionPerformed(evt);
            }
        });

        tf_mat.setToolTipText("");

        bt_rechercher.setText("RECHERCHER");
        bt_rechercher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_rechercherActionPerformed(evt);
            }
        });

        bt_confirmer.setText("CONFIRMER");
        bt_confirmer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_confirmerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout p_infogenLayout = new javax.swing.GroupLayout(p_infogen);
        p_infogen.setLayout(p_infogenLayout);
        p_infogenLayout.setHorizontalGroup(
            p_infogenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_infogenLayout.createSequentialGroup()
                .addGroup(p_infogenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(l_nom)
                    .addComponent(l_tel))
                .addGap(18, 18, 18)
                .addGroup(p_infogenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(p_infogenLayout.createSequentialGroup()
                        .addComponent(tf_tel, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 222, Short.MAX_VALUE)
                        .addComponent(l_mat)
                        .addGap(18, 18, 18)
                        .addComponent(tf_mat, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11))
                    .addGroup(p_infogenLayout.createSequentialGroup()
                        .addComponent(tf_nom)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, p_infogenLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bt_rechercher)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bt_confirmer)
                .addGap(42, 42, 42))
        );
        p_infogenLayout.setVerticalGroup(
            p_infogenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_infogenLayout.createSequentialGroup()
                .addGroup(p_infogenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(l_nom)
                    .addComponent(tf_nom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(p_infogenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(l_mat)
                    .addComponent(l_tel)
                    .addComponent(tf_tel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_mat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(p_infogenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_rechercher)
                    .addComponent(bt_confirmer))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        l_img2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Personnel/logo2.gif"))); // NOI18N

        p_typeemp.setBorder(javax.swing.BorderFactory.createTitledBorder("Type d'employés"));

        TypesEmployés.add(rb_employe);
        rb_employe.setText("Employé");
        rb_employe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_employeActionPerformed(evt);
            }
        });

        TypesEmployés.add(rb_commercial);
        rb_commercial.setText("Commercial");
        rb_commercial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_commercialActionPerformed(evt);
            }
        });

        TypesEmployés.add(rb_directeur);
        rb_directeur.setText("Directeur");
        rb_directeur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_directeurActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout p_typeempLayout = new javax.swing.GroupLayout(p_typeemp);
        p_typeemp.setLayout(p_typeempLayout);
        p_typeempLayout.setHorizontalGroup(
            p_typeempLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, p_typeempLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rb_employe)
                .addGap(18, 18, 18)
                .addComponent(rb_commercial)
                .addGap(18, 18, 18)
                .addComponent(rb_directeur)
                .addGap(140, 140, 140))
        );
        p_typeempLayout.setVerticalGroup(
            p_typeempLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, p_typeempLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(p_typeempLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rb_directeur)
                    .addComponent(rb_commercial)
                    .addComponent(rb_employe))
                .addGap(57, 57, 57))
        );

        p_calculrem.setBorder(javax.swing.BorderFactory.createTitledBorder("Informations pour le calcul de la rémunération"));

        l_taux.setText("Taux Horraire");

        l_nbh.setText("Nombres d'heures");

        l_indem.setText("Indemnités");

        l_ventes.setText("Ventes");

        l_pour.setText("Pourcentage");

        l_mb.setText("Montant Brut");

        tf_mb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_mbActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout p_calculremLayout = new javax.swing.GroupLayout(p_calculrem);
        p_calculrem.setLayout(p_calculremLayout);
        p_calculremLayout.setHorizontalGroup(
            p_calculremLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_calculremLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(p_calculremLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(p_calculremLayout.createSequentialGroup()
                        .addGroup(p_calculremLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(p_calculremLayout.createSequentialGroup()
                                .addComponent(l_taux)
                                .addGap(29, 29, 29)
                                .addComponent(tf_taux, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(p_calculremLayout.createSequentialGroup()
                                .addComponent(l_nbh)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(p_calculremLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tf_nbh)
                                    .addComponent(tf_indem))))
                        .addGap(31, 31, 31)
                        .addGroup(p_calculremLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(l_pour)
                            .addComponent(l_ventes))
                        .addGap(18, 18, 18)
                        .addGroup(p_calculremLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_ventes, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_pour, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(p_calculremLayout.createSequentialGroup()
                        .addComponent(l_indem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(l_mb)
                        .addGap(18, 18, 18)
                        .addComponent(tf_mb, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        p_calculremLayout.setVerticalGroup(
            p_calculremLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_calculremLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(p_calculremLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(l_taux)
                    .addComponent(l_ventes)
                    .addComponent(tf_taux, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_ventes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(p_calculremLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(l_nbh)
                    .addComponent(l_pour)
                    .addComponent(tf_nbh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_pour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(p_calculremLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(l_mb)
                    .addComponent(tf_mb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l_indem)
                    .addComponent(tf_indem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        p_gestcont.setBorder(javax.swing.BorderFactory.createTitledBorder("Gestion du conteneur"));

        bt_chercher.setText("Chercher");
        bt_chercher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_chercherActionPerformed(evt);
            }
        });

        bt_supprimer.setText("Supprimer");
        bt_supprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_supprimerActionPerformed(evt);
            }
        });

        bt_creer.setText("Creer");
        bt_creer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_creerActionPerformed(evt);
            }
        });

        l_nb.setText("Nombre d'objets présents dans le conteneur :");

        l_nbElem.setText(" ");

        bt_lancer.setText("Lancer");
        bt_lancer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_lancerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout p_gestcontLayout = new javax.swing.GroupLayout(p_gestcont);
        p_gestcont.setLayout(p_gestcontLayout);
        p_gestcontLayout.setHorizontalGroup(
            p_gestcontLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_gestcontLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(p_gestcontLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(p_gestcontLayout.createSequentialGroup()
                        .addComponent(bt_lancer)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_chercher)
                        .addGap(50, 50, 50)
                        .addComponent(bt_supprimer)
                        .addGap(54, 54, 54)
                        .addComponent(bt_creer))
                    .addGroup(p_gestcontLayout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(l_nb)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(l_nbElem)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        p_gestcontLayout.setVerticalGroup(
            p_gestcontLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_gestcontLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(p_gestcontLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_chercher)
                    .addComponent(bt_supprimer)
                    .addComponent(bt_creer)
                    .addComponent(bt_lancer))
                .addGap(18, 18, 18)
                .addGroup(p_gestcontLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(l_nb)
                    .addComponent(l_nbElem))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        p_nav.setBorder(javax.swing.BorderFactory.createTitledBorder("Navigation dans le conteneur"));

        bt_debut.setText("Début");
        bt_debut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_debutActionPerformed(evt);
            }
        });

        bt_prec.setText("<<");
        bt_prec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_precActionPerformed(evt);
            }
        });

        bt_fin.setText("Fin");
        bt_fin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_finActionPerformed(evt);
            }
        });

        bt_suiv.setText(">>");
        bt_suiv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_suivActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout p_navLayout = new javax.swing.GroupLayout(p_nav);
        p_nav.setLayout(p_navLayout);
        p_navLayout.setHorizontalGroup(
            p_navLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_navLayout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(bt_debut)
                .addGap(77, 77, 77)
                .addComponent(bt_prec)
                .addGap(86, 86, 86)
                .addComponent(bt_suiv)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bt_fin)
                .addGap(47, 47, 47))
        );
        p_navLayout.setVerticalGroup(
            p_navLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_navLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(p_navLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_debut)
                    .addComponent(bt_prec)
                    .addComponent(bt_fin)
                    .addComponent(bt_suiv))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        l_mode.setText(" ");

        m_menufile.setText("File");

        mi_new.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        mi_new.setText("Nouveau...");
        mi_new.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_newActionPerformed(evt);
            }
        });
        m_menufile.add(mi_new);

        mi_load.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.SHIFT_MASK));
        mi_load.setText("Charger...");
        mi_load.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_loadActionPerformed(evt);
            }
        });
        m_menufile.add(mi_load);

        mi_save.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        mi_save.setText("Sauvegarder...");
        mi_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_saveActionPerformed(evt);
            }
        });
        m_menufile.add(mi_save);

        mi_quit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        mi_quit.setText("Quitter");
        mi_quit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_quitActionPerformed(evt);
            }
        });
        m_menufile.add(mi_quit);

        m_menubar.add(m_menufile);

        m_menuhelp.setText("?");

        mi_about.setText("A propos");
        mi_about.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_aboutActionPerformed(evt);
            }
        });
        m_menuhelp.add(mi_about);

        m_menubar.add(m_menuhelp);

        setJMenuBar(m_menubar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(l_img1)
                        .addGap(126, 126, 126)
                        .addComponent(l_mode)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(l_img2)
                        .addGap(206, 206, 206))
                    .addComponent(p_infogen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(p_typeemp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(p_calculrem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(p_gestcont, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(p_nav, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(l_img1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(l_mode)
                            .addComponent(l_img2))))
                .addGap(55, 55, 55)
                .addComponent(p_infogen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(p_typeemp, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(p_calculrem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(p_gestcont, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(p_nav, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mi_newActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_newActionPerformed
        mi_new.addActionListener(new EcouteurMenu());
    }//GEN-LAST:event_mi_newActionPerformed

    private void mi_loadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_loadActionPerformed
        mi_load.addActionListener(new EcouteurMenu());
    }//GEN-LAST:event_mi_loadActionPerformed

    private void mi_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_saveActionPerformed
        mi_save.addActionListener(new EcouteurMenu());
    }//GEN-LAST:event_mi_saveActionPerformed

    private void mi_aboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_aboutActionPerformed
        JOptionPane jp1;
        jp1 = new JOptionPane() ;
        jp1.showMessageDialog(null,"Ce programme a été fait par Jordan CHADUIRON.","Information",JOptionPane.INFORMATION_MESSAGE);  
    }//GEN-LAST:event_mi_aboutActionPerformed

    private void tf_telActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_telActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_telActionPerformed

    private void bt_suivActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_suivActionPerformed
        if(cont.cleSuivante()!= null){
            cont.suivant();
            this.afficher();
         
        }else{
            JOptionPane jp1;
            jp1 = new JOptionPane();
            jp1.showMessageDialog(null,"Pas  de personne suivante dans le conteneur","Erreur",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_bt_suivActionPerformed

    private void bt_chercherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_chercherActionPerformed
        bt_confirmer.setVisible(false);
        if(bt_chercher.getText().compareTo("Chercher")== 0){
            this.modeRecherche();
            bt_rechercher.setVisible(true);
        }
    }//GEN-LAST:event_bt_chercherActionPerformed

    private void bt_lancerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_lancerActionPerformed
        
    }//GEN-LAST:event_bt_lancerActionPerformed

    private void tf_mbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_mbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_mbActionPerformed

    private void bt_creerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_creerActionPerformed
                /* on peut arriver a ce bouton pour 2 raisons : pour creer un
        nouveau Personnel ou pour valider une saisie de Personnel en
        l'ajoutant au conteneur : */
        if (bt_creer.getText().compareTo("Ajouter") == 0) {
            /* on aurait pu faire un test sur modeCourant... si on a
           AJOUTER, on est en mode SAISIE : il faut ajouter le Personnel au
           conteneur */
            this.ajouter(); /* cette méthode va ajouter l’élément dans
           le conteneur */
            this.modeAffichage(); /* on bascule en mode Affichage
           apres chaque saisie */
            this.afficher();
            bt_creer.setText("Creer");
        } else { /* bouton CREER : on est en mode AFFICHAGE et on veut
            passer en mode Saisie */
            this.effacer(); /* au cas ou il y a eu une saisie
            précédente */
            this.modeSaisie();
            this.saisir();
        }
    }//GEN-LAST:event_bt_creerActionPerformed

    private void rb_employeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_employeActionPerformed
        typePersonnel = TypePersonnel.EMPLOYE;
        effacer();
        saisir();
    }//GEN-LAST:event_rb_employeActionPerformed

    private void rb_commercialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_commercialActionPerformed
        typePersonnel = TypePersonnel.COMMERCIAL;
        effacer();
        saisir();
    }//GEN-LAST:event_rb_commercialActionPerformed

    private void rb_directeurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_directeurActionPerformed
        typePersonnel = TypePersonnel.DIRECTEUR;
        effacer();
        saisir();
    }//GEN-LAST:event_rb_directeurActionPerformed

    private void bt_debutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_debutActionPerformed
        if(cont.estVide()== false){
        cont.premier();
        this.afficher();
        }
    }//GEN-LAST:event_bt_debutActionPerformed

    private void bt_precActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_precActionPerformed
        if(cont.clePrecedente()!= null){
            cont.precedent();
            this.afficher();
         
        }else{
            JOptionPane jp1;
            jp1 = new JOptionPane();
            jp1.showMessageDialog(null,"Pas de personne precedente dans le conteneur","Erreur",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_bt_precActionPerformed

    private void bt_finActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_finActionPerformed
        if(cont.estVide() == false){
            cont.dernier();
        
        this.afficher();
        }
    }//GEN-LAST:event_bt_finActionPerformed

    private void bt_supprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_supprimerActionPerformed
        bt_rechercher.setVisible(false);
        if (bt_supprimer.getText().compareTo("Supprimer") == 0) {
            this.modeRecherche();
            bt_confirmer.setVisible(true);
        }
    }//GEN-LAST:event_bt_supprimerActionPerformed

    private void bt_rechercherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_rechercherActionPerformed
        this.rechercher();
        this.modeAffichage();
        this.afficher();
    }//GEN-LAST:event_bt_rechercherActionPerformed

    private void bt_confirmerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_confirmerActionPerformed
        this.supprimer();
        this.modeAffichage();
    }//GEN-LAST:event_bt_confirmerActionPerformed

    private void mi_quitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_quitActionPerformed
        mi_quit.addActionListener(new EcouteurMenu());
    }//GEN-LAST:event_mi_quitActionPerformed
   
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
            java.util.logging.Logger.getLogger(fenetreGesPer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fenetreGesPer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fenetreGesPer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fenetreGesPer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new fenetreGesPer().setVisible(true);
            }
        });
    }
        class EcouteurMenu implements ActionListener {
        private int choix;
        private JFileChooser d;
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == mi_new) {
                cont.vider();
                total =0;
                Personnel.resetDernierAttribue();
                effacer();
                l_nbElem.setText(Integer.toString(total));
            } else if (e.getSource() == mi_load) {
            
            int returnVal = fc.showOpenDialog(null);
            
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
            } 
            ta_fc.setCaretPosition(ta_fc.getDocument().getLength());
            
            
            
            //SAUVEGARDER ----------
            }//SAUVEGARDER ----------
            else if (e.getSource() == mi_save){
                
                fc = new JFileChooser(new File("."));
                fc.setDialogTitle("Sauvegarder ...");
                fc.setFileFilter(null);
                choix=fc.showOpenDialog((Component)e.getSource());
                
                if(choix == JFileChooser.APPROVE_OPTION) {
                   
                    File f= fc.getSelectedFile();
                    cont.sauvegarder(f.getAbsolutePath());
                }
                    
                    
            }else if (e.getSource() == mi_quit){
                System.exit(0);
            }
    
            
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup TypesEmployés;
    private javax.swing.JButton bt_chercher;
    private javax.swing.JButton bt_confirmer;
    private javax.swing.JButton bt_creer;
    private javax.swing.JButton bt_debut;
    private javax.swing.JButton bt_fin;
    private javax.swing.JButton bt_lancer;
    private javax.swing.JButton bt_prec;
    private javax.swing.JButton bt_rechercher;
    private javax.swing.JButton bt_suiv;
    private javax.swing.JButton bt_supprimer;
    private javax.swing.JLabel l_img1;
    private javax.swing.JLabel l_img2;
    private javax.swing.JLabel l_indem;
    private javax.swing.JLabel l_mat;
    private javax.swing.JLabel l_mb;
    private javax.swing.JLabel l_mode;
    private javax.swing.JLabel l_nb;
    private javax.swing.JLabel l_nbElem;
    private javax.swing.JLabel l_nbh;
    private javax.swing.JLabel l_nom;
    private javax.swing.JLabel l_pour;
    private javax.swing.JLabel l_taux;
    private javax.swing.JLabel l_tel;
    private javax.swing.JLabel l_ventes;
    private javax.swing.JMenuBar m_menubar;
    private javax.swing.JMenu m_menufile;
    private javax.swing.JMenu m_menuhelp;
    private javax.swing.JMenuItem mi_about;
    private javax.swing.JMenuItem mi_load;
    private javax.swing.JMenuItem mi_new;
    private javax.swing.JMenuItem mi_quit;
    private javax.swing.JMenuItem mi_save;
    private javax.swing.JPanel p_calculrem;
    private javax.swing.JPanel p_gestcont;
    private javax.swing.JPanel p_infogen;
    private javax.swing.JPanel p_nav;
    private javax.swing.JPanel p_typeemp;
    private javax.swing.JRadioButton rb_commercial;
    private javax.swing.JRadioButton rb_directeur;
    private javax.swing.JRadioButton rb_employe;
    private javax.swing.JTextField tf_indem;
    private javax.swing.JTextField tf_mat;
    private javax.swing.JTextField tf_mb;
    private javax.swing.JTextField tf_nbh;
    private javax.swing.JTextField tf_nom;
    private javax.swing.JTextField tf_pour;
    private javax.swing.JTextField tf_taux;
    private javax.swing.JTextField tf_tel;
    private javax.swing.JTextField tf_ventes;
    // End of variables declaration//GEN-END:variables
}
