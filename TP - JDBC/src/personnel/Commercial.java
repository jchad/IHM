/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package personnel;

/**
 *
 * @author veronique.deslandres
 */
//--- class commercial ---
public final class Commercial extends Employe {

    private static final long serialVersionUID = 42L; // for serialisation/
    //deserialization compatibility
    
    private float pourcentage;
    private float ventes;

    /** donne le pourcentage d'un commercial */
    public float getPourcentage()  {return pourcentage;}


    /** donne les ventes d'un commercial */
    public float getVentes()  {return ventes;}

    /** constructeur d'un commercial */
    public Commercial(String nom, String numero, float valTaux, float Heures,
            float valPourcent, float valVentes) {
        super(nom,numero,valTaux,Heures);
        pourcentage=valPourcent;
        ventes=valVentes;
    }
    public Commercial(String mat, String nom, String tel, float txHoraire, float nbH, float pourcent, float totVentes){
        super(mat, nom,tel,txHoraire,nbH);
        this.pourcentage = pourcent;
        this.ventes = totVentes;
    }

    /** calcul de la paie du commercial*/
    public float calculPaie(){
        return super.calculPaie() + pourcentage * ventes/100;
    }

} // Commercial
