/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1p1;
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
        
    }
    public Conteneur(java.util.TreeMap<K,V> t){
        
    }
    
   public boolean ajouter(K cle, V valeur){
       if (tM.containsKey(cle)==true)
            return false;
       tM.put(cle, valeur);
       return true;
           
   }
   public void charger(java.lang.String nomFic){
       int val = ToInt(nomFic);
       
   }
   public K cleCourante(){
       return this.cleCourante;
   }
   public K cleMax(){
       return tM.lastKey();
   }
   public K cleMix(){
       return tM.firstKey();
   }
   public K clePrecedente(){
       return tM.floorKey(cleCourante);
   }
   public K cleSuivante(){
       return tM.ceilingKey(cleCourante);
   }
   public void dernier(){
       
   }
   public boolean estVide(){
       
   }
   public boolean existe(){
       
   }

