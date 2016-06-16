
package personnel;

/**
 *
 * @author veronique.deslandres
 */
// --- class Directeur ---
public final class Directeur extends Personnel {

    private float indemnite;
    private float prime;

    /** donne la prime d'un directeur */
    public float getPrime()  { return prime; }

    /** donne les indemnites d'un directeur */
    public float getIndemnites()  { return indemnite;}

    /** constructeur d'un directeur */
    public Directeur(String nom,String numero, float valIndemnite, 
                                                            float valPrime) {

        super(nom,numero);
        indemnite=valIndemnite;
        prime=valPrime;
    }
    public Directeur(String mat, String nom, String tel, float indemn, float valprime){
        super(mat, nom,tel);
        this.indemnite = indemn;
        prime=valprime;
    }
    /** calcul de la paie du Directeur */
    public float calculPaie() {
        return indemnite + prime;
    }


} // Directeur
