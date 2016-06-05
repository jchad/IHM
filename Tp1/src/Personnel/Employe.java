/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Personnel;

/**
 *
 * @author Jordan
 */
public class Employe extends Personnel {
    
    private float tauxHorraire;
    private float nbHeures;
    
    public Employe(String nom, String numero, float thorraire, float nbh){
       super(nom, numero); 
       tauxHorraire=thorraire;
       nbHeures=nbh;
    }
    
    @Override
    public float calculPaie(){
        return this.tauxHorraire*this.nbHeures;
        
    }

    public float getTauxHorraire() {
        return tauxHorraire;
    }

    public float getNbHeures() {
        return nbHeures;
    }
    
}
