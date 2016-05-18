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
public class Commercial extends Employe{
    private float pourcentage;
    private float totalVentes=0;
    
    public Commercial(String nom, String numero, float thorraire, float nbh, float pct, float tvent){
        super(nom, numero, thorraire, nbh);
        pourcentage=pct;
        totalVentes=tvent;
        
    }
    @Override
    public float calculPaie(){
        return super.
    }
    
}
