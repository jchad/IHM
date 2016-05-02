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
    
}
