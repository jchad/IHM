/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesBd;
import java.io.*;
import java.sql.*;
import java.util.*;
import java.util.logging.*;
import oracle.jdbc.OracleConnection;
import oracle.jdbc.pool.OracleDataSource;
import personnel.*;

/**
 *
 * @author Jordan
 */
public class AccesBdOracle {
    private static AccesBdOracle instance = null;
    private static Statement stmt = null;
    private static Connection connec = null;
    private static ResultatSet rs = null;
    
    private AccesBdOracle throws{
        connec=creerConnexion();
    }
    
    public static Connection creerConnexion() throws SQLException, FileNotFoundException, IOException {
        Properties props = new Properties();
        FileInputStream fichier = null;
        try {
            fichier = new FileInputStream("src/accesBd /connexionOracle.properties");
            props.load(fichier);
        }
        catch (FileNotFoundException e) {
            System.out.println("**** Fichier décrivant les propriétés d'accès à la BD non trouvé !"+e.getMessage());
        } catch (IOException ex) {
            Logger.getLogger(OracleConnection.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
            fichier.close();
            } catch (IOException ex) {
            Logger.getLogger(OracleConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
         }
        try {
            OracleDataSource ods = new OracleDataSource();
            ods.setDriverType(props.getProperty("pilote"));
            ods.setPortNumber(new Integer(props.getProperty("port")).intValue());
            ods.setServiceName(props.getProperty("service"));
            ods.setUser(props.getProperty("user"));
            ods.setPassword(props.getProperty("pwd"));
            ods.setServerName(props.getProperty("serveur"));

            System.out.println("==> Connexion ORACLE établie...");
            return ( ods.getConnection() );
        } catch (Exception e) {
            System.err.println("Erreur de connexion au serveur ORACLE...");
            return null;
        }
     }
    
    public void fermer() throws SQLException {
        connec.close();
        System.out.println("deconnection ok");
    }
    
    public void charger(TreeMap<String, Personnel> tMap) throws SQLException {
        String query = "SELECT numpers, nompers, numtel, tauxhorraire, nbheures, indemnite, prime, pourcentage, ventes, typepersonnel FROM personnel order by numpers";
        Personnel elt = null;
        stmt = connec.createStatement();
        rs = stmt.executeQuery(query);
        while (rs.next()) {
            String cle = rs.getString(1);
            String cat = rs.getString(4);
            switch (cat) {
                case "Employe":
                    elt = new Employe(cle, rs.getString(2), rs.getString(3), rs.getFloat(5), rs.getFloat(6));
                    break;
                case "Commercial":
                    elt = new Commercial(cle, rs.getString(2), rs.getString(3), rs.getFloat(4), rs.getFloat(5), rs.getFloat(8), rs.getFloat(9));
                    break;
                case "Directeur":
                    elt = new Directeur(cle, rs.getString(2), rs.getString(3), rs.getFloat(6), rs.getFloat(7));
                    break;
            }
        tMap.put(cle, elt);
        }   
    }
    
    public void supprimer(TreeMap<String, Personnel> tMap, String mat) throws SQLException{
        PreparedStatement query = connec.prepareStatement("Delete from personnel where numpers = ?");
        query.setString(1,mat);
        query.executeUpdate();
    }
    
    public void inserer(TreeMap<String, Personnel> tMap, Personnel pers) throws SQLException{
        PreparedStatement pstmt = connec.prepareStatement("Insert into Personnel values(?,?,?,?,?,?,?,?,?,?");
        pstmt.setString(1, pers.getNumPers());
        pstmt.setString(2, pers.getNomPers());
        pstmt.setString(3, pers.getNumTel());
        
        if (pers instanceof Employe){
            
        }
        if (pers instanceof Commercial){
            
        }
        if (pers instanceof Directeur){
            
        }
    }
    
    public static AccesBdOracle getInstance(){
        return instance;
    }
    
 }

