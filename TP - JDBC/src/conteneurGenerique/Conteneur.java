package conteneurGenerique;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Conteneur personnalisé basé sur un TreeMap
 * Les éléments insérés sont rangés selon l'ordre naturel de leur clef
 * Attention : methode supprimer() différente du TP1 !
 * @author VDe, IUT Lyon Departement Informatique
 * @param <K> clef de l'objet dans la collection, doit être un type comparable et sérialisable
 * @param <V> valeur de l'objet dans la collection, doit être un type sérialisable
 */

public class Conteneur<K extends Comparable<K> & Serializable,
        V extends Serializable> {

    private TreeMap<K, V> tM;
    private K cleCourante;

    /** 
     * Constructeur par copie
     * @param t le TreeMap à insérer dans le conteneur
     */
    public Conteneur(TreeMap<K, V> t) {
        tM = t;
        cleCourante = t.firstKey();
    }
    /**
     * Constructeur vide
     */
     public Conteneur() {
        tM = new TreeMap<K, V>();
        cleCourante = null; // le conteneur est encore vide
    }

    /**
     * Vide le conteneur et met la clef courante à null
     */
    public void vider() {
        tM.clear();
        cleCourante = null;
    }

    // renvoie le nombre d'objets presents dans le conteneur
    public int nbElements() {
       //if (!tM.isEmpty()) return tM.size(); else return 0;
       return tM.size();
       // sinon NullPointerException
    }

    // indique si le conteneur est vide
    public boolean estVide() {
        return tM.isEmpty();
    }

    /**
     * ajoute un element dans le conteneur
     * @param cle Clef de l'élément à insérer
     * @param valeur Objet à insérer
     * @return FALSE si la clef est deja présente; pas d'insertion effectuee
     *         TRUE si insertion effectuee et clefCourante est alors positionnee sur l'element inséré
     */
    public boolean ajouter(K cle, V valeur) {
        if (tM.containsKey(cle))
            return false;
        tM.put(cle, valeur);
        cleCourante=cle;
        return true;
    }

    /**
     * Obtenir un element du conteneur à partir de sa clef
     * @param cle : Clef de l'élément à obtenir
     * @return l'objet s'il a été trouvé, null sinon
     */
    public V obtenir(K cle) {
        if (!tM.isEmpty()) {
            return tM.get(cle); // return null si pas presente
        }
            
        return null;
    }

    /**
     * Indique si la cle existe dans le conteneur
     * @param cle : Clef à rechercher
     * @return TRUE si la clef a été trouvée, FALSE sinon
     */
    public boolean existe(K cle) {
        if (tM.containsKey(cle))
            return true;
        return false;
    }

    /**
     * Positionne cleCourante sur la cle proposée si elle existe
     * sinon ne modifie pas cleCourante
     * @param cle : Clef à rechercher
     */
    public void positionner(K cle) {
        if (tM.containsKey(cle))
            cleCourante=cle;
    }

    /**
     * Supprime l'element de la cle proposée si elle existe
     * et positionne cleCourante sur le suivant
     * (sur le precedent si l'elt a supprimer est le dernier)
     * si clef pas trouvée, ne modifie pas cleCourante 
     * @param cle : Clef à rechercher
     * @return false si la suppression n'a pas pu être faite, true sinon
     */
    public boolean supprimer(K cle) {
        if (tM.isEmpty()) {
            cleCourante = null;
            return false;
        }
        if (!tM.containsKey(cle)) {
            return false;
        }
        if (cle.compareTo(tM.lastKey()) == 0) {
            precedent();
        } else {
            suivant();
        }
        tM.remove(cle);
        return true;
    }

    /**
     * Si le conteneur n'est pas vide, et que la clef courante n'est pas déjà 
     * sur le dernier élément,
     * se positionne sur l'element suivant dans l'ordre des cles;
     * sinon ne fait rien
     */
    public void suivant() {

        if(!tM.isEmpty() && cleCourante != tM.lastKey()) {
            this.cleCourante = tM.higherKey(cleCourante);
        }
    }

    /**
     * Renvoie la cle de l'element suivant dans l'ordre des cles
     * et se positionne dessus
     * @return la clef suivante ou la derniere clef si on est au bout de conteneur
     */
    public K cleSuivante() {
        this.suivant();
        return cleCourante;
    }

    /**
     * Si le conteneur n'est pas vide, et que la clef courante n'est pas déjà 
     * sur le premier élément,
     * se positionne sur l'element précédent dans l'ordre des cles;
     * sinon ne fait rien
     */
    public void precedent() {
        if(!tM.isEmpty() && cleCourante != tM.firstKey()) {
            this.cleCourante = tM.lowerKey(cleCourante);
        }
    }
    
    /**
     * Renvoie la cle de l'element précédent dans l'ordre des cles
     * et se positionne dessus
     * @return la clef précédente ou la 1ere clef si on est au début de conteneur
     */
    public K clePrecedente() {
        this.precedent();
        return cleCourante;
    }

    /** 
     * Se positionne sur le premier element du conteneur
     * s'il n'est pas vide
     */
    public void premier() {
        if (!tM.isEmpty())
            cleCourante = tM.firstKey();
    }

    /**
     * Renvoie la plus petite cle
     * @return la clef min
     */
    public K cleMin() {
        return (tM.firstKey());
    }

    /**
     * Se positionne sur le dernier element du conteneur
     * s'il n'est pas vide
     */ 
    public void dernier() {
        if (!tM.isEmpty())
            cleCourante = tM.lastKey();
    }

    /**
     * Renvoie la plus grande cle
     * @return la clef max
     */
    public K cleMax() {
        return (tM.lastKey());
    }

    /**
     * Renvoie la cle de l'objet courant
     * @return clefCourante
     */
    public K cleCourante() {
        return cleCourante;
    }

    // necessaire pour les tests
    public TreeMap<K,V> gettM() {
        return this.tM;
    }

    /** 
     * Serialise (écriture binaire) du TreeMap dans un fichier 
     * @param nomFic nom du fichier cible
     */ 
    public void sauvegarder(String nomFic){
        
        try {
            File f1 = new File(nomFic); 
            FileOutputStream fs = new FileOutputStream(f1);
            ObjectOutputStream fsObj = new ObjectOutputStream(fs);
            //Definition des flots tampons
            
            fsObj.writeObject(tM); // Ecriture du conteneur
            fsObj.close(); //On ferme le flot
            
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Lecture binaire du TreeMap depuis un fichier
     * Les types K et V doivent donc être sérialisables
     * @param nomFic nom du fichier source
     */
    public void charger(String nomFic){
        
        try {
            
            File f1 = new File(nomFic); 
            FileInputStream fe = new FileInputStream(f1);
            try (ObjectInputStream feObj = new ObjectInputStream(fe)) {
                // On lit un Object, il faut le convertir au type attendu, ici un TreeMap
                tM = (TreeMap<K, V>) feObj.readObject();
            }
            
            if (!tM.isEmpty())          // on instancie la clef courante
                cleCourante=tM.firstKey();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conteneur.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ERREUR : le contenu du fichier ne peut pas etre "
                    + "converti dans le TreeMap attendu");
            
        } catch(IOException e) {
            System.out.println("Fichier inaccessible !");
        }
    }
    
} // fin de la classe Conteneur