/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Personnel;
import java.util.*;
import java.io.*;

/**
 *
 * @author Jordan
 * @param <K>
 * @param <V>
 */
//
//classe générique qui implémente un conteneur à base de TreeMap
//
public class Conteneur<K extends Comparable<K> & Serializable, V extends Serializable> {
    private TreeMap<K,V> tM;
    private K cleCourante;
    public Conteneur(){
        this.tM=new TreeMap<K,V>();
        cleCourante=null;
        
    }
    public Conteneur(java.util.TreeMap<K,V> t){
        this.tM=t;
        cleCourante=t.firstKey();
    }
    
   public boolean ajouter(K cle, V valeur){
       if (tM.containsKey(cle)==true)
            return false;
       tM.put(cle, valeur);
       cleCourante=cle;
       return true;
           
   }
   public void charger(java.lang.String nomFic){
       try{
           File f1 = new File(nomFic);
           FileInputStream fe = new FileInputStream(f1);
           ObjectInputStream feObj = new ObjectInputStream(fe);
           tM = (TreeMap<K, V>) feObj.readObject();
           feObj.close();
           if (!tM.isEmpty())
               cleCourante=tM.firstKey();
       } catch(Exception e){
           System.out.println(e.getMessage());
       }
       
   }
   public K cleCourante(){
       return this.cleCourante;
   }
   public K cleMax(){
       return tM.lastKey();
   }
   public K cleMin(){
       return tM.firstKey();
   }
   public K clePrecedente(){
       return tM.lowerKey(cleCourante);
   }
   public K cleSuivante(){
       return tM.higherKey(cleCourante);
   }
   public void dernier(){
       cleCourante=tM.lastKey();
   }
   public boolean estVide(){
       return tM.isEmpty();
   }
   public boolean existe(K cle){
       return tM.containsKey(cle);
   }
   public int nbElements(){
       return tM.size();
   }
   public V obtenir(K cle){
       return tM.get(cle);      
   }
   public void positionner(K cle){
       if (tM.containsKey(cle))
           cleCourante = cle;
   }
   public void precedent(){
       cleCourante=tM.lowerKey(cleCourante);
   }
   public void premier(){
       cleCourante=tM.firstKey();
   }   

   public void sauvegarder(String nomFic){
       try{
           File f1 = new File(nomFic);
           FileOutputStream fs = new FileOutputStream(f1);
           ObjectOutputStream fsObj = new ObjectOutputStream(fs);
           fsObj.writeObject(tM);
           fsObj.close();
        } catch(Exception e){
           System.out.println(e.getMessage());
        }
   }
   public void suivant(){
       cleCourante=tM.higherKey(cleCourante);
   }
   public void supprimer(K cle){
       tM.remove(cle);
   }
   public void vider(){
       tM.clear();
   }

}
   

