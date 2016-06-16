/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package personnel;

/**
 *
 * @author veronique.deslandres
 */
//--- Classe Employe ---
public class Employe extends Personnel {
    // attributs d'Employe
    private float tauxHoraire;
    private float nbHeures;

    //  donne le taux d'un employe
    public float getTaux()  {return tauxHoraire;}

    // nombre d'heure d'un employe
    public float getNbHeures()  {return nbHeures;}

    // constructeur d'un employe
    public Employe(String nom,String numero, float valTaux, float heures) {
        super(nom,numero);
        tauxHoraire=valTaux;
        nbHeures=heures;
    }
    public Employe(String mat, String nom, String tel, float txHoraire, float nbH)
    {
        super(mat, nom, tel);
        this.tauxHoraire = txHoraire;
        this.nbHeures = nbH;
    }
    // calcul de la paie de l'employe
    @Override
    public float calculPaie(){ return tauxHoraire * nbHeures;}

} // Employe