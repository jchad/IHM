/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Personnel;
import java.io.*;
/**
 *
 * @author Jordan
 */
public abstract class Personnel implements Comparable<Personnel>, Serializable {
//attribut d'instance
private String numPers; 
private String nomPers;
private String numTel;
//attribut et methode de classe
private static int dernierAttribue=1000;
//
private static void setDernierAttribue(int val){
dernierAttribue=val;
}
//
public static void resetDernierAttribue(){
dernierAttribue=1000;
}

public Personnel(String nom, String numero) {
numPers = 'M' +String.valueOf(++dernierAttribue);
nomPers = nom;
numTel = numero;
}
//methode d'instance
// pour affecter le plus grand matricule au champ statique 'dernierAttribue'
//appellel setDernierAttribue()
/* public void fixerDernierAttribue(){
//rappel: numPers a la forme 'M1002'
int val=Integer.parseInt(numPers.substring(1));
if (val> dernierAttribue)
Personnel.setDernierAttribue(val);
}*/
public String getNumPerson() {
return numPers;
}
public String getNomPers() {
return nomPers;
}
public String getNumTel() {
return numTel;
}
//meto abstraite
public abstract float calculPaie();
//methode pour comparer les personels
@Override
public int compareTo(Personnel p){
return numPers.compareTo(((Personnel)p).numPers);
}
//methode pour tester l'egalite
public boolean equals(Personnel p){
return numPers.equals(p.numPers);
}
//methode ToString
@Override
public String toString(){
return this.getClass().getName();
}
}