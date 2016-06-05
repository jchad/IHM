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
public class Directeur extends Personnel{
    private float indemnités;
    public Directeur(String nom, String numero, float indemnités){
        super(nom, numero);
        this.indemnités=indemnités;
    }
    
    @Override
    public float calculPaie(){
        return this.indemnités;
    }

    public float getIndemnités() {
        return indemnités;
    }
    
}
