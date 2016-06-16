/*
 * fenetreConteneur.java
 *
 */
package vue;

import accesBd.*;
import conteneurGenerique.Conteneur;
import personnel.Employe;
import personnel.Directeur;
import personnel.Personnel;
import personnel.Commercial;
import java.awt.*;
import java.awt.event.*;
import java.io.File; // pour les fichiers
import java.io.IOException;
import java.sql.SQLException;
import java.text.*; // pour DecimalFormat
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane; // pour les fenetres de dialogue
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.WindowConstants;

/**
 *
 * @author  VDe + APi
 */
public class FenetreConteneur extends javax.swing.JFrame {

    private Conteneur<String, Personnel> cont;  // utilisation du conteneur generique
    private int total;      // nbre de personnels presents dans le conteneur
    private AccesBdOracle inst;
    private enum TypePersonnel {
        EMPLOYE, COMMERCIAL, DIRECTEUR
    };
    private TypePersonnel typePersonnel;

    private enum ModeCourant {
        AFFICHAGE, SAISIE, RECHERCHE
    };
    private ModeCourant modeCourant;

    /** Contructeur par defaut ou l'on cree un nouveau conteneur */
    public FenetreConteneur() throws SQLException, IOException{

        initComponents();

        typePersonnel = TypePersonnel.EMPLOYE;
        // case cochee par defaut dans initComponents()
        inst = AccesBdOracle.getInstance();
        
        TreeMap<String, Personnel> tMap = new TreeMap<>();
        
        try {
            inst.charger(tMap);
        } catch (SQLException ex) {
            showMessageDialog(this,"Problème de chargement de la base de données","Erreur",ERROR_MESSAGE);
            Logger.getLogger(FenetreConteneur.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        cont = new Conteneur<>(tMap);
        cont.dernier();
        total = 0;

        // enregistrement des menus aupres de l'ecouteur dedie
        mitem_nouveau.addActionListener(new EcouteurMenu());
        mitem_ouvrir.addActionListener(new EcouteurMenu());
        mitem_sauver.addActionListener(new EcouteurMenu());
        mitem_quitter.addActionListener(new EcouteurMenu());
        mitem_apropos.addActionListener(new EcouteurMenu());

        this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

        // enregistrement de la fenetre aupres de l'ecouteur dedie
        this.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                quitter(); // idem MenuItemQuitter.doClick();
                // permet de controler s'il y a eu sauvegarde du fichier...
            }
        });


        this.modeAffichage();
        this.afficher();
    }

    /** Code genere pour l'interface : A NE PAS MODIFIER !
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btGrp_typePerso = new javax.swing.ButtonGroup();
        panneauPPal = new javax.swing.JPanel();
        panneauInfoGenerales = new javax.swing.JPanel();
        lbl_nom = new javax.swing.JLabel();
        lbl_tel = new javax.swing.JLabel();
        // j'ajoute du code depuis le design sous IDE
        tf_nom = new javax.swing.JTextField();
        tf_tel = new javax.swing.JTextField();
        lbl_matricule = new javax.swing.JLabel();
        tf_matricule = new javax.swing.JTextField();
        bt_lancerRecherche = new javax.swing.JButton();
        panneauTypePersonnel = new javax.swing.JPanel();
        rb_employe = new javax.swing.JRadioButton();
        rb_commercial = new javax.swing.JRadioButton();
        rb_directeur = new javax.swing.JRadioButton();
        panneauRemuneration = new javax.swing.JPanel();
        lbl_tauxhoraire = new javax.swing.JLabel();
        lbl_nbheures = new javax.swing.JLabel();
        lbl_indemnites = new javax.swing.JLabel();
        lbl_ventes = new javax.swing.JLabel();
        lbl_pourcentage = new javax.swing.JLabel();
        lbl_paie = new javax.swing.JLabel();
        tf_tauxhoraire = new javax.swing.JTextField();
        tf_nbheures = new javax.swing.JTextField();
        tf_indemnites = new javax.swing.JTextField();
        tf_ventes = new javax.swing.JTextField();
        tf_pourcentage = new javax.swing.JTextField();
        tf_paie = new javax.swing.JTextField();
        lbl_prime = new javax.swing.JLabel();
        tf_prime = new javax.swing.JTextField();
        panneauGestionPerso = new javax.swing.JPanel();
        bt_creer = new javax.swing.JButton();
        bt_chercher = new javax.swing.JButton();
        bt_supprimer = new javax.swing.JButton();
        panneauNavigation = new javax.swing.JPanel();
        bt_debut = new javax.swing.JButton();
        bt_precedent = new javax.swing.JButton();
        bt_suivant = new javax.swing.JButton();
        bt_fin = new javax.swing.JButton();
        lbl_nbpersonnels = new javax.swing.JLabel();
        tf_nbpersonnels = new javax.swing.JTextField();
        lbl_mode = new javax.swing.JLabel();
        lbl_image = new javax.swing.JLabel();
        lbl_logo = new javax.swing.JLabel();
        barreMenu = new javax.swing.JMenuBar();
        menuFichier = new javax.swing.JMenu();
        mitem_nouveau = new javax.swing.JMenuItem();
        mitem_ouvrir = new javax.swing.JMenuItem();
        mitem_sauver = new javax.swing.JMenuItem();
        jSeparator = new javax.swing.JSeparator();
        mitem_quitter = new javax.swing.JMenuItem();
        menuAide = new javax.swing.JMenu();
        mitem_apropos = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestion Personnel");

        panneauPPal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        panneauInfoGenerales.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Identité", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        lbl_nom.setText("Nom");

        lbl_tel.setText("Tel.");

        lbl_matricule.setText("Matricule");

        tf_matricule.setEditable(false);
        tf_matricule.setBackground(new java.awt.Color(255, 255, 204));
        tf_matricule.setText(" ");
        tf_matricule.setDisabledTextColor(new java.awt.Color(102, 102, 102));

        bt_lancerRecherche.setText("RECHERCHER");
        bt_lancerRecherche.setToolTipText("lancer la recherche sur le matricule");
        bt_lancerRecherche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_lancerRechercheActionPerformed(evt);
            }
        });

        panneauTypePersonnel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Type de personnel", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        btGrp_typePerso.add(rb_employe);
        rb_employe.setSelected(true);
        rb_employe.setText("Employe");
        rb_employe.setMargin(new java.awt.Insets(0, 0, 0, 0));
        rb_employe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_employeActionPerformed(evt);
            }
        });

        btGrp_typePerso.add(rb_commercial);
        rb_commercial.setText("Commercial");
        rb_commercial.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        rb_commercial.setMargin(new java.awt.Insets(0, 0, 0, 0));
        rb_commercial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_commercialActionPerformed(evt);
            }
        });

        btGrp_typePerso.add(rb_directeur);
        rb_directeur.setText("Directeur");
        rb_directeur.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        rb_directeur.setMargin(new java.awt.Insets(0, 0, 0, 0));
        rb_directeur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_directeurActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panneauTypePersonnelLayout = new javax.swing.GroupLayout(panneauTypePersonnel);
        panneauTypePersonnel.setLayout(panneauTypePersonnelLayout);
        panneauTypePersonnelLayout.setHorizontalGroup(
            panneauTypePersonnelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panneauTypePersonnelLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(rb_employe, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86)
                .addComponent(rb_commercial, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(rb_directeur, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panneauTypePersonnelLayout.setVerticalGroup(
            panneauTypePersonnelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panneauTypePersonnelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panneauTypePersonnelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rb_employe)
                    .addComponent(rb_directeur)
                    .addComponent(rb_commercial))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panneauInfoGeneralesLayout = new javax.swing.GroupLayout(panneauInfoGenerales);
        panneauInfoGenerales.setLayout(panneauInfoGeneralesLayout);
        panneauInfoGeneralesLayout.setHorizontalGroup(
            panneauInfoGeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panneauInfoGeneralesLayout.createSequentialGroup()
                .addGroup(panneauInfoGeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panneauInfoGeneralesLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(panneauInfoGeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_nom)
                            .addComponent(lbl_tel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panneauInfoGeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panneauInfoGeneralesLayout.createSequentialGroup()
                                .addComponent(tf_tel, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(lbl_matricule)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tf_matricule))
                            .addComponent(tf_nom))
                        .addGap(104, 104, 104)
                        .addComponent(bt_lancerRecherche))
                    .addGroup(panneauInfoGeneralesLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panneauTypePersonnel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panneauInfoGeneralesLayout.setVerticalGroup(
            panneauInfoGeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panneauInfoGeneralesLayout.createSequentialGroup()
                .addGroup(panneauInfoGeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_nom)
                    .addComponent(tf_nom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panneauInfoGeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_matricule, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_matricule)
                    .addComponent(lbl_tel)
                    .addComponent(tf_tel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_lancerRecherche))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(panneauTypePersonnel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panneauRemuneration.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Informations Rémunération", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        lbl_tauxhoraire.setText("Taux horaire");

        lbl_nbheures.setText("Nombre d'heures");

        lbl_indemnites.setText("Indemnités");

        lbl_ventes.setText("Montant Ventes");

        lbl_pourcentage.setText("Pourcentage");

        lbl_paie.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_paie.setText("Rémunération calculée");

        tf_paie.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        lbl_prime.setText("Prime");

        javax.swing.GroupLayout panneauRemunerationLayout = new javax.swing.GroupLayout(panneauRemuneration);
        panneauRemuneration.setLayout(panneauRemunerationLayout);
        panneauRemunerationLayout.setHorizontalGroup(
            panneauRemunerationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panneauRemunerationLayout.createSequentialGroup()
                .addGap(138, 138, 138)
                .addGroup(panneauRemunerationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_tauxhoraire)
                    .addComponent(lbl_indemnites)
                    .addComponent(lbl_nbheures)
                    .addComponent(lbl_prime))
                .addGap(23, 23, 23)
                .addGroup(panneauRemunerationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tf_prime)
                    .addComponent(tf_tauxhoraire, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                    .addComponent(tf_nbheures)
                    .addComponent(tf_indemnites))
                .addGap(23, 23, 23)
                .addGroup(panneauRemunerationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbl_paie)
                    .addComponent(lbl_ventes)
                    .addComponent(lbl_pourcentage))
                .addGap(20, 20, 20)
                .addGroup(panneauRemunerationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_ventes)
                    .addComponent(tf_paie)
                    .addComponent(tf_pourcentage))
                .addContainerGap())
        );
        panneauRemunerationLayout.setVerticalGroup(
            panneauRemunerationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panneauRemunerationLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panneauRemunerationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_tauxhoraire)
                    .addComponent(tf_tauxhoraire, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_ventes)
                    .addComponent(tf_ventes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(panneauRemunerationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_nbheures)
                    .addComponent(tf_nbheures, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_pourcentage)
                    .addComponent(tf_pourcentage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(panneauRemunerationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_indemnites)
                    .addComponent(tf_indemnites, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(52, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panneauRemunerationLayout.createSequentialGroup()
                .addContainerGap(136, Short.MAX_VALUE)
                .addGroup(panneauRemunerationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_paie)
                    .addComponent(tf_paie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_prime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_prime))
                .addContainerGap())
        );

        panneauGestionPerso.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Gestion des personnels", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        bt_creer.setText("Creer");
        bt_creer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_creerActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout panneauGestionPersoLayout = new javax.swing.GroupLayout(panneauGestionPerso);
        panneauGestionPerso.setLayout(panneauGestionPersoLayout);
        panneauGestionPersoLayout.setHorizontalGroup(
            panneauGestionPersoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panneauGestionPersoLayout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(bt_creer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bt_chercher)
                .addGap(130, 130, 130)
                .addComponent(bt_supprimer)
                .addContainerGap())
        );

        panneauGestionPersoLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {bt_chercher, bt_creer, bt_supprimer});

        panneauGestionPersoLayout.setVerticalGroup(
            panneauGestionPersoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panneauGestionPersoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panneauGestionPersoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_creer)
                    .addComponent(bt_supprimer)
                    .addComponent(bt_chercher)))
        );

        panneauNavigation.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Navigation dans le conteneur", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        bt_debut.setText("Debut");
        bt_debut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_debutActionPerformed(evt);
            }
        });

        bt_precedent.setText("<<");
        bt_precedent.setToolTipText("précédent");
        bt_precedent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_precedentActionPerformed(evt);
            }
        });

        bt_suivant.setText(">>");
        bt_suivant.setToolTipText("suivant");
        bt_suivant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_suivantActionPerformed(evt);
            }
        });

        bt_fin.setText("Fin");
        bt_fin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_finActionPerformed(evt);
            }
        });

        lbl_nbpersonnels.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        lbl_nbpersonnels.setText("Nombre de personnels présents dans le conteneur :");

        tf_nbpersonnels.setEditable(false);
        tf_nbpersonnels.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tf_nbpersonnels.setBorder(null);
        tf_nbpersonnels.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_nbpersonnelsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panneauNavigationLayout = new javax.swing.GroupLayout(panneauNavigation);
        panneauNavigation.setLayout(panneauNavigationLayout);
        panneauNavigationLayout.setHorizontalGroup(
            panneauNavigationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panneauNavigationLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(bt_debut)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bt_precedent)
                .addGap(23, 23, 23)
                .addComponent(bt_suivant)
                .addGap(100, 100, 100)
                .addComponent(bt_fin)
                .addGap(114, 114, 114))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panneauNavigationLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_nbpersonnels)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tf_nbpersonnels, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panneauNavigationLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {bt_debut, bt_fin});

        panneauNavigationLayout.setVerticalGroup(
            panneauNavigationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panneauNavigationLayout.createSequentialGroup()
                .addGroup(panneauNavigationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_nbpersonnels)
                    .addComponent(tf_nbpersonnels, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(panneauNavigationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_precedent)
                    .addComponent(bt_suivant)
                    .addComponent(bt_debut)
                    .addComponent(bt_fin)))
        );

        lbl_mode.setText("MODE SAISIE");

        lbl_image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo1.gif"))); // NOI18N

        lbl_logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo2.gif"))); // NOI18N

        javax.swing.GroupLayout panneauPPalLayout = new javax.swing.GroupLayout(panneauPPal);
        panneauPPal.setLayout(panneauPPalLayout);
        panneauPPalLayout.setHorizontalGroup(
            panneauPPalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panneauPPalLayout.createSequentialGroup()
                .addGroup(panneauPPalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panneauPPalLayout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(lbl_image, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                        .addGap(77, 77, 77)
                        .addComponent(lbl_mode)
                        .addGap(117, 117, 117)
                        .addComponent(lbl_logo)
                        .addGap(8, 8, 8))
                    .addGroup(panneauPPalLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panneauPPalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(panneauNavigation, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panneauGestionPerso, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panneauRemuneration, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panneauInfoGenerales, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        panneauPPalLayout.setVerticalGroup(
            panneauPPalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panneauPPalLayout.createSequentialGroup()
                .addGroup(panneauPPalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_mode)
                    .addGroup(panneauPPalLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panneauPPalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbl_logo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl_image, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panneauInfoGenerales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panneauRemuneration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panneauGestionPerso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panneauNavigation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        menuFichier.setText("Fichier");

        mitem_nouveau.setText("Nouveau...");
        menuFichier.add(mitem_nouveau);

        mitem_ouvrir.setText("Ouvrir...");
        menuFichier.add(mitem_ouvrir);

        mitem_sauver.setText("Sauvegarder...");
        menuFichier.add(mitem_sauver);
        menuFichier.add(jSeparator);

        mitem_quitter.setText("Quitter");
        menuFichier.add(mitem_quitter);

        barreMenu.add(menuFichier);

        menuAide.setText("?");

        mitem_apropos.setText("A propos...");
        menuAide.add(mitem_apropos);

        barreMenu.add(menuAide);

        setJMenuBar(barreMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panneauPPal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panneauPPal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /* ***************************************************************************/
    /*   GESTION DES EVENEMENTS                                                  */
    /* ***************************************************************************/
  private void bt_suivantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_suivantActionPerformed
      cont.suivant();
      this.afficher();
  }//GEN-LAST:event_bt_suivantActionPerformed

  private void bt_precedentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_precedentActionPerformed
      cont.precedent();
      this.afficher();
  }//GEN-LAST:event_bt_precedentActionPerformed

  private void bt_lancerRechercheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_lancerRechercheActionPerformed

      String matr = tf_matricule.getText(); // on lit le matricule

      if (matr.compareTo("") != 0) {
          this.rechercher(matr);
          this.modeAffichage();
          this.afficher();
      }
  }//GEN-LAST:event_bt_lancerRechercheActionPerformed

  private void bt_chercherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_chercherActionPerformed
      if ((!cont.estVide())) {
          this.effacer();
          this.modeRecherche();
          try {
              tf_matricule.getText();
          } // pour forcer la lecture du matricule
          catch (Exception e) {
          }
      }
      // (c'est le bouton LancerRecherche qui lancera la recherche)
  }//GEN-LAST:event_bt_chercherActionPerformed

  private void bt_finActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_finActionPerformed
      cont.dernier();
      afficher();
  }//GEN-LAST:event_bt_finActionPerformed

  private void bt_supprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_supprimerActionPerformed
      int reponse = JOptionPane.showConfirmDialog(this,
              "Supprimer le personnel courant ?", "Confirmation",
              JOptionPane.YES_NO_OPTION);
      if (reponse == JOptionPane.YES_OPTION) {
          try {
                    inst.supprimer(cont.obtenir(tf_matricule.getText()).getNumPers());
                } catch (SQLException ex) {
                    showMessageDialog(this,"Problème de suppression de la base de données","Erreur",ERROR_MESSAGE);
                    Logger.getLogger(FenetreConteneur.class.getName()).log(Level.SEVERE, null, ex);
                }
          cont.supprimer(cont.cleCourante());
          afficher();
      } else {
          this.afficher();
      }
  }//GEN-LAST:event_bt_supprimerActionPerformed

  private void bt_creerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_creerActionPerformed
// on peut arriver a ce bouton pour 2 raisons : pour creer un nouveau Personnel
// ou pour valider une saisie de Personnel en l'ajoutant au conteneur :
      if (bt_creer.getText().compareTo("AJOUTER") == 0) {
          try {
              // on aurait pu faire un test sur modeCourant... si on a AJOUTER, on est en
              // mode SAISIE : il faut ajouter le Personnel au conteneur
              this.ajouter();
          } catch (IOException ex) {
              Logger.getLogger(FenetreConteneur.class.getName()).log(Level.SEVERE, null, ex);
          }
          this.modeAffichage(); // on bascule en mode Affichage apres chaque saisie
          this.afficher();
      } else { // on est en mode AFFICHAGE et on veut passer en mode Saisie
          this.effacer(); // au cas ou il y a eu une saisie precedente
          this.modeSaisie();
          this.saisir();
      }
  }//GEN-LAST:event_bt_creerActionPerformed

  private void rb_commercialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_commercialActionPerformed
      typePersonnel = TypePersonnel.COMMERCIAL;
      saisir();
  }//GEN-LAST:event_rb_commercialActionPerformed

  private void bt_debutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_debutActionPerformed
      cont.premier();
      this.afficher();
  }//GEN-LAST:event_bt_debutActionPerformed

  private void rb_directeurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_directeurActionPerformed
      typePersonnel = TypePersonnel.DIRECTEUR;
      saisir();
  }//GEN-LAST:event_rb_directeurActionPerformed

  private void rb_employeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_employeActionPerformed
      typePersonnel = TypePersonnel.EMPLOYE;
      saisir();
  }//GEN-LAST:event_rb_employeActionPerformed

  private void tf_nbpersonnelsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_nbpersonnelsActionPerformed
      // TODO add your handling code here:
  }//GEN-LAST:event_tf_nbpersonnelsActionPerformed

    /* *************************************************************************/
    /*   GESTION DU MODE COURANT                                                */
    /* **************************************************************************/
    private void modeAffichage() {
        modeCourant = ModeCourant.AFFICHAGE;
        lbl_mode.setText("MODE AFFICHAGE");

        tf_matricule.setEnabled(false);
        tf_matricule.setBackground(new Color(255, 255, 204));
        bt_lancerRecherche.setVisible(false);

        tf_nom.setEnabled(false);
        tf_nom.setBackground(new Color(255, 255, 204));
        tf_nom.setDisabledTextColor(new java.awt.Color(102, 102, 102));

        tf_tel.setEnabled(false);
        tf_tel.setBackground(new Color(255, 255, 204));
        tf_tel.setDisabledTextColor(new java.awt.Color(102, 102, 102));

        rb_employe.setEnabled(false);
        rb_commercial.setEnabled(false);
        rb_directeur.setEnabled(false);

        tf_tauxhoraire.setEnabled(false);
        tf_tauxhoraire.setBackground(new Color(255, 255, 204));
        tf_tauxhoraire.setDisabledTextColor(new java.awt.Color(102, 102, 102));

        tf_nbheures.setEnabled(false);
        tf_nbheures.setBackground(new Color(255, 255, 204));
        tf_nbheures.setDisabledTextColor(new java.awt.Color(102, 102, 102));

        tf_indemnites.setEnabled(false);
        tf_indemnites.setBackground(new Color(255, 255, 204));
        tf_indemnites.setDisabledTextColor(new java.awt.Color(102, 102, 102));

        tf_ventes.setEnabled(false);
        tf_ventes.setBackground(new Color(255, 255, 204));
        tf_ventes.setDisabledTextColor(new java.awt.Color(102, 102, 102));

        tf_pourcentage.setEnabled(false);
        tf_pourcentage.setBackground(new Color(255, 255, 204));
        tf_pourcentage.setDisabledTextColor(new java.awt.Color(102, 102, 102));

        tf_paie.setEnabled(false);
        tf_paie.setBackground(new Color(255, 255, 204));
        tf_paie.setDisabledTextColor(new java.awt.Color(102, 102, 102));

        tf_prime.setEnabled(false);
        tf_prime.setBackground(new Color(255, 255, 204));
        tf_prime.setDisabledTextColor(new java.awt.Color(102, 102, 102));

        bt_creer.setEnabled(true);
        bt_creer.setText("Creer"); // (ce bouton sert a 2 choses: creer en mode
        // affichage, et ajouter en mode saisie)
        bt_creer.setToolTipText("Saisir un nouveau personnel");
        bt_chercher.setEnabled(true);
        bt_supprimer.setEnabled(true);
        bt_debut.setEnabled(true);
        bt_precedent.setEnabled(true);
        bt_suivant.setEnabled(true);
        bt_fin.setEnabled(true);
        tf_nbpersonnels.setSelectedTextColor(Color.BLACK);
        tf_nbpersonnels.setEditable(false);
    }

    private void modeSaisie() {
        // l'appel a la methode est normalement suivi d'un appel a la methode saisir()

        modeCourant = ModeCourant.SAISIE;
        lbl_mode.setText("MODE SAISIE");

        tf_matricule.setEnabled(false);
        tf_matricule.setBackground(new Color(255, 255, 204));
        bt_lancerRecherche.setVisible(false);

        tf_nom.setEnabled(true);
        // focus sur le NOM :
        if (!tf_nom.isFocusable()) {
            tf_nom.setFocusable(true);
        }
        tf_nom.requestFocus();
        tf_nom.setBackground(new Color(255, 255, 255));
        tf_tel.setEnabled(true);
        tf_tel.setBackground(new Color(255, 255, 255));

        rb_employe.setEnabled(true);
        rb_employe.setSelected(true); // 'employe' coche par defaut
        typePersonnel = TypePersonnel.EMPLOYE; // pour que l'acces aux champs
        // soit gere

        rb_commercial.setEnabled(true);
        rb_directeur.setEnabled(true);
        // (les autres boutons seront geres par saisir() selon le type d'employe
        // saisi)

        // lors d'une saisie, on n'a plus acces aux boutons de gestion du conteneur
        // ni de navigation
        // sauf Creer qui se transforme en bt AJOUTER pour enregistrer la saisie
        bt_creer.setText("AJOUTER");
        bt_creer.setToolTipText("Ajouter ce nouveau personnel");
        bt_creer.setEnabled(true);

        tf_nbpersonnels.setText(Integer.toString(total));
        tf_nbpersonnels.setEditable(false);
        bt_chercher.setEnabled(false);
        bt_supprimer.setEnabled(false);
        bt_debut.setEnabled(false);
        bt_precedent.setEnabled(false);
        bt_suivant.setEnabled(false);
        bt_fin.setEnabled(false);

    }

    // en mode Recherche, seul le champ Matricule est actif, et un bouton apparait
    // pour lancer la recherche
    private void modeRecherche() {

        modeCourant = ModeCourant.RECHERCHE;
        lbl_mode.setText("MODE RECHERCHE");
        this.effacer();

        tf_matricule.setBackground(new Color(255, 255, 255));
        tf_matricule.setEnabled(true); // on le rend actif
        tf_matricule.setEditable(true); // et editable (car mentionne non
        // editable a la creation)
        // on donne le focus au cham Matricule
        if (!tf_matricule.isFocusable()) {
            tf_matricule.setFocusable(true);
        }
        tf_matricule.requestFocus();
        //tf_matricule.setText("M1002"); 

        bt_lancerRecherche.setVisible(true);

        tf_nom.setEnabled(false);
        tf_nom.setBackground(new Color(255, 255, 204));

        tf_tel.setEnabled(false);
        tf_tel.setBackground(new Color(255, 255, 204));
        rb_employe.setEnabled(false);
        rb_commercial.setEnabled(false);
        rb_directeur.setEnabled(false);
        tf_tauxhoraire.setEnabled(false);
        tf_tauxhoraire.setBackground(new Color(255, 255, 204));
        tf_nbheures.setEnabled(false);
        tf_nbheures.setBackground(new Color(255, 255, 204));
        tf_indemnites.setEnabled(false);
        tf_indemnites.setBackground(new Color(255, 255, 204));
        tf_ventes.setEnabled(false);
        tf_ventes.setBackground(new Color(255, 255, 204));
        tf_pourcentage.setEnabled(false);
        tf_pourcentage.setBackground(new Color(255, 255, 204));
        tf_paie.setEnabled(false);
        tf_paie.setBackground(new Color(255, 255, 204));
        tf_prime.setEnabled(false);
        tf_prime.setBackground(new Color(255, 255, 204));

        bt_creer.setEnabled(false);
        bt_chercher.setEnabled(true); // (seul le bouton Chercher est encore
        // accessible pour lancer une nouvelle recherche)
        bt_supprimer.setEnabled(false);
        bt_debut.setEnabled(false);
        bt_precedent.setEnabled(false);
        bt_suivant.setEnabled(false);
        bt_fin.setEnabled(false);

    }

    private void effacer() {   // met tous les champs a blanc
        tf_nom.setText("");
        tf_tel.setText("");
        tf_matricule.setText("");
        tf_tauxhoraire.setText("");
        tf_nbheures.setText("");
        tf_indemnites.setText("");
        tf_prime.setText("");
        tf_ventes.setText("");
        tf_pourcentage.setText("");
        tf_paie.setText("");

    }
    /* ***************************************************************************/
    /* FONCTIONS METIER : SAISIR, AFFICHER, RECHERCHER, AJOUTER, CHARGER, SAUVER */
    /* ***************************************************************************/

    private void rechercher(String matr) {

        if (cont.existe(matr)) {
            cont.positionner(matr);
        } else {
            JOptionPane.showMessageDialog(this, "Matricule inexistant",
                    "Probleme de clef", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void afficher() {

        this.effacer();
        total = cont.nbElements();
        tf_nbpersonnels.setText(Integer.toString(total));

        // S'il y a au moins un element dans le conteneur
        if (!cont.estVide()) {
            // pour gerer un affichage � 2 decimales partout o� c'est necessaire :
            NumberFormat nf = DecimalFormat.getInstance();
            nf.setMaximumFractionDigits(2);
            nf.setMinimumFractionDigits(2);

            Personnel pers = cont.obtenir(cont.cleCourante());
            tf_nom.setText(pers.getNomPers());
            tf_tel.setText(pers.getNumTel());
            tf_matricule.setText(pers.getNumPers());
            if (pers instanceof Directeur) // Directeur
            {
                // on gere l'affichage des decimales pour eviter que s'affiche n'importe quoi :
                Float indemn = ((Directeur) pers).getIndemnites();
                tf_indemnites.setText(nf.format(indemn));
                Float prime = ((Directeur) pers).getPrime();
                tf_prime.setText(nf.format(prime));
                rb_directeur.setSelected(true);
            } else {	// Commercial ou Employe
                tf_nbheures.setText(Float.toString(((Employe) pers).getNbHeures()));
                tf_tauxhoraire.setText(Float.toString(((Employe) pers).getTaux()));
                if (pers instanceof Commercial) { 	// Commercial
                    tf_ventes.setText(Float.toString(
                            ((Commercial) pers).getVentes()));
                    tf_pourcentage.setText(
                            Float.toString(((Commercial) pers).getPourcentage()));
                    rb_commercial.setSelected(true);
                } else // Employe
                {
                    rb_employe.setSelected(true);
                }
            }
            tf_paie.setText(nf.format(pers.calculPaie()));
        }

    } // fin afficher()

    private void saisir() {
// place les champs accessibles pour la saisie en fonction du type de Personnel

        if (typePersonnel == TypePersonnel.EMPLOYE) {
            tf_tauxhoraire.setEnabled(true);
            tf_tauxhoraire.setBackground(new Color(255, 255, 255));
            tf_nbheures.setEnabled(true);
            tf_nbheures.setBackground(new Color(255, 255, 255));

            tf_indemnites.setEnabled(false);
            tf_indemnites.setBackground(new Color(255, 255, 204));
            tf_ventes.setEnabled(false);
            tf_ventes.setBackground(new Color(255, 255, 204));
            tf_pourcentage.setEnabled(false);
            tf_pourcentage.setBackground(new Color(255, 255, 204));
            tf_paie.setEnabled(false);
            tf_paie.setBackground(new Color(255, 255, 204));
            tf_prime.setEnabled(false);
            tf_prime.setBackground(new Color(255, 255, 204));

        } else if (typePersonnel == TypePersonnel.COMMERCIAL) {
            tf_tauxhoraire.setEnabled(true);
            tf_tauxhoraire.setBackground(new Color(255, 255, 255));
            tf_nbheures.setEnabled(true);
            tf_nbheures.setBackground(new Color(255, 255, 255));
            tf_ventes.setEnabled(true);
            tf_ventes.setBackground(new Color(255, 255, 255));
            tf_pourcentage.setEnabled(true);
            tf_pourcentage.setBackground(new Color(255, 255, 255));

            tf_paie.setEnabled(false);
            tf_paie.setBackground(new Color(255, 255, 204));
            tf_indemnites.setEnabled(false);
            tf_indemnites.setBackground(new Color(255, 255, 204));
            tf_prime.setEnabled(false);
            tf_prime.setBackground(new Color(255, 255, 204));

        } else {
            tf_indemnites.setEnabled(true);
            tf_indemnites.setBackground(new Color(255, 255, 255));
            tf_prime.setEnabled(true);
            tf_prime.setBackground(new Color(255, 255, 255));

            tf_tauxhoraire.setEnabled(false);
            tf_tauxhoraire.setBackground(new Color(255, 255, 204));
            tf_nbheures.setEnabled(false);
            tf_nbheures.setBackground(new Color(255, 255, 204));
            tf_ventes.setEnabled(false);
            tf_ventes.setBackground(new Color(255, 255, 204));
            tf_pourcentage.setEnabled(false);
            tf_pourcentage.setBackground(new Color(255, 255, 204));
            tf_paie.setEnabled(false);
            tf_paie.setBackground(new Color(255, 255, 204));
        }
    } // de saisir()

    private void ajouter() throws IOException {
        // rappel : dans le conteneur generique, ajouter met la clef courante sur
        // l'elt ajoute
        // on gere ici les eventuelles exceptions generees par la saisie :
        String nom, tel;
        float txh, nbh, pourc, ventes, indemn, prime;
        Personnel p = null;
        nom = tf_nom.getText();
        tel = tf_tel.getText();
        Float numTel = tryParseFloat(tel);

        // V�rifie que le nom n'est pas vide
        if (nom.length() < 2) {
            JOptionPane.showMessageDialog(null,
                    "Le nom doit contenir au moins 2 lettres.",
                    "Erreur", JOptionPane.ERROR_MESSAGE);
        } else {
            if (numTel == null) {
                JOptionPane.showMessageDialog(null,
                        "Le numero de telephone ne doit contenir que des chiffres.",
                        "Erreur", JOptionPane.ERROR_MESSAGE);
                return;
            }

        }
        try {

            /** Pour recuperer un double d'une chaine:
             *  Double.valueOf(s).doubleValue(); ou Double.parseDouble()...
             **/
            if (typePersonnel == TypePersonnel.EMPLOYE) {
                txh = this.tryParseFloat(tf_tauxhoraire.getText());
                nbh = this.tryParseFloat(tf_nbheures.getText());
                p = new Employe(nom, tel, txh, nbh);
                cont.ajouter(p.getNumPers(), (Employe)p);

            } else if (typePersonnel == TypePersonnel.COMMERCIAL) {
                txh = this.tryParseFloat(tf_tauxhoraire.getText());
                nbh = this.tryParseFloat(tf_nbheures.getText());
                pourc = this.tryParseFloat(tf_pourcentage.getText());
                ventes = this.tryParseFloat(tf_ventes.getText());
                p = new Commercial(nom, tel, txh, nbh, pourc, ventes);
                cont.ajouter(p.getNumPers(), (Commercial)p);

            } else {
                indemn = this.tryParseFloat(tf_indemnites.getText());
                prime = this.tryParseFloat(tf_prime.getText());
                p = new Directeur(nom, tel, indemn, prime);
                cont.ajouter(p.getNumPers(), (Directeur)p);
            }


        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erreur de saisie ou champs non "
                    + "remplis, recommencez !",
                    "Probleme dans la saisie", JOptionPane.WARNING_MESSAGE);
        }
         try {
            inst.inserer(p);
        } catch (SQLException ex) {
            showMessageDialog(this,"Problème lors de l'insertion dans la base de données","Erreur",ERROR_MESSAGE);
            Logger.getLogger(FenetreConteneur.class.getName()).log(Level.SEVERE, null, ex);
        }

    } // de ajouter()

    private Float tryParseFloat(String num) {
        try {
            num = num.replace(',', '.');
            return Float.parseFloat(num);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private void quitter() {

        int reponse = JOptionPane.showConfirmDialog(this,
                "Si vous n'avez pas sauvergarde vos donnees avant, elles seront"
                + " perdues. Voulez-vous vraiment quitter ?", "Attention",
                JOptionPane.OK_CANCEL_OPTION);
        if (reponse == JOptionPane.OK_OPTION) {
            System.exit(0);
        } else {
            this.afficher();
        }

    }

    public void charger(String nomFic) {
// Ameliorer : reaffecter les identifiants pour qu'il n'y ait pas de trou ??
// charge un fichier existant et positionne la cle courante sur le dernier
// element
        cont.charger(nomFic);
        // on choisit d'afficher le dernier Personnel cree:
        String maxCle = cont.cleMax();
        // on initialise le dernierMatriculeAttribue de Personnel a la valeur
        // max lue dans le fichier :
        if (maxCle != null) {
            (cont.obtenir(maxCle)).fixerDernierAttribue();
        }
        afficher();

    }

    /**
     * MAIN  ------------------------------------------------------------------
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                try {
                    new FenetreConteneur().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(FenetreConteneur.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(FenetreConteneur.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar barreMenu;
    private javax.swing.ButtonGroup btGrp_typePerso;
    private javax.swing.JButton bt_chercher;
    private javax.swing.JButton bt_creer;
    private javax.swing.JButton bt_debut;
    private javax.swing.JButton bt_fin;
    private javax.swing.JButton bt_lancerRecherche;
    private javax.swing.JButton bt_precedent;
    private javax.swing.JButton bt_suivant;
    private javax.swing.JButton bt_supprimer;
    private javax.swing.JSeparator jSeparator;
    private javax.swing.JLabel lbl_image;
    private javax.swing.JLabel lbl_indemnites;
    private javax.swing.JLabel lbl_logo;
    private javax.swing.JLabel lbl_matricule;
    private javax.swing.JLabel lbl_mode;
    private javax.swing.JLabel lbl_nbheures;
    private javax.swing.JLabel lbl_nbpersonnels;
    private javax.swing.JLabel lbl_nom;
    private javax.swing.JLabel lbl_paie;
    private javax.swing.JLabel lbl_pourcentage;
    private javax.swing.JLabel lbl_prime;
    private javax.swing.JLabel lbl_tauxhoraire;
    private javax.swing.JLabel lbl_tel;
    private javax.swing.JLabel lbl_ventes;
    private javax.swing.JMenu menuAide;
    private javax.swing.JMenu menuFichier;
    private javax.swing.JMenuItem mitem_apropos;
    private javax.swing.JMenuItem mitem_nouveau;
    private javax.swing.JMenuItem mitem_ouvrir;
    private javax.swing.JMenuItem mitem_quitter;
    private javax.swing.JMenuItem mitem_sauver;
    private javax.swing.JPanel panneauGestionPerso;
    private javax.swing.JPanel panneauInfoGenerales;
    private javax.swing.JPanel panneauNavigation;
    private javax.swing.JPanel panneauPPal;
    private javax.swing.JPanel panneauRemuneration;
    private javax.swing.JPanel panneauTypePersonnel;
    private javax.swing.JRadioButton rb_commercial;
    private javax.swing.JRadioButton rb_directeur;
    private javax.swing.JRadioButton rb_employe;
    private javax.swing.JTextField tf_indemnites;
    private javax.swing.JTextField tf_matricule;
    private javax.swing.JTextField tf_nbheures;
    private javax.swing.JTextField tf_nbpersonnels;
    private javax.swing.JTextField tf_nom;
    private javax.swing.JTextField tf_paie;
    private javax.swing.JTextField tf_pourcentage;
    private javax.swing.JTextField tf_prime;
    private javax.swing.JTextField tf_tauxhoraire;
    private javax.swing.JTextField tf_tel;
    private javax.swing.JTextField tf_ventes;
    // End of variables declaration//GEN-END:variables

// classe interne ecouteur pour les evenements de type ActionEvent sur les
    // items de Menu
    class EcouteurMenu implements ActionListener {

        private int choix;
        private JFileChooser d;

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == mitem_nouveau) {
                cont.vider();
                Personnel.resetDernierAttribue();
                afficher();

            } else if (e.getSource() == mitem_ouvrir) {

                d = new JFileChooser(new File("."));
                d.setDialogTitle("Charger ...");
                d.setFileFilter(null);
                choix = d.showOpenDialog((Component) e.getSource());
                if (choix == JFileChooser.APPROVE_OPTION) {
                    File f = d.getSelectedFile();
                    charger(f.getAbsolutePath());
                }

            } else if (e.getSource() == mitem_sauver) {
                d = new JFileChooser(new File("."));
                d.setDialogTitle("Sauvegarder ...");
                choix = d.showSaveDialog((Component) e.getSource());
                if (choix == JFileChooser.APPROVE_OPTION) {
                    File f = d.getSelectedFile();
                    cont.sauvegarder(f.getAbsolutePath());
                    //afficher();
                }

            } else if (e.getSource() == mitem_quitter) {
                quitter();

            } else if (e.getSource() == mitem_apropos) {
                JOptionPane.showMessageDialog((Component) e.getSource(),
                        "Application GesPers 2047 \n by  IUT Info Villeurbanne -"
                        + "FRANCE",
                        "A Propos", JOptionPane.INFORMATION_MESSAGE);
            }
        } // fin actionPerformed
    } // fin class EcouteurMenu
}
