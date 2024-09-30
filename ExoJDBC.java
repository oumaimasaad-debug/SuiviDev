/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exo1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
public class ExoJDBC {
    private static String user= "root";
    private static String password= "";
    private static String url= "jdbc:mysql://localhost/mydb";
    private static Connection cn = null;
    private static Statement st = null;
    public static Connection getCn(){
       try {
           // 1. Charger le driver JDBC de MySQL
            Class.forName("com.mysql.jdbc.Driver");
            // 2. Ouvrir une connexion à la base MySQL
            cn = DriverManager.getConnection(url, user, password);
            } catch (ClassNotFoundException ex) {
            System.out.println("Driver introvable");
        } catch (SQLException ex) {
            Logger.getLogger(ExoJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
            return cn;
    }
            // 3. Créer un Statement
            public static void main(String[] args) {
               /* try{
            st = getCn().createStatement();
            String createreq = "CREATE TABLE DevData (" +
                                    "Developpeurs VARCHAR(32), " +
                                    "Jour CHAR(11), " +
                                    "NbScripts INTEGER)";
            st.executeUpdate(createreq);
             String inserttable = "INSERT INTO DevData VALUES " +
                                   "('ALAMI', 'Lundi', 1), " +
                                   "('WAFI', 'Lundi', 2), " +
                                   "('SALAMI', 'Mardi', 9), " +
                                   "('SAFI', 'Mardi', 2), " +
                                   "('ALAMI', 'Mardi', 2), " +
                                   "('SEBIHI', 'Mercredi', 2), " +
                                   "('WAFI', 'Jeudi', 3), " +
                                   "('ALAOUI', 'Vendredi', 9), " +
                                   "('WAFI', 'Vendredi', 3), " +
                                   "('SEBIHI', 'Vendredi', 4)";
            st.executeUpdate(inserttable);
       }catch(SQLException e){
        System.out.println("Erreur SQL");
    }finally{
        try{
            //Etape 5
            st.close();
            cn.close();
        }catch (SQLException ex){
 System.out.println("Impossible de libérer les ressource");
    }
        }*/
                //MaxScripts();
                //OrdreDev();
                //Somme();
                SommeParDev("ALAMI");
    }
            public static void MaxScripts() {
        String query = "SELECT Developpeurs, jour, max(NBScripts) FROM devdata GROUP BY jour";
        try {
            Statement stmt = getCn().createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                System.out.println("Le developpeur est " + rs.getString("Developpeurs") + ",le jour est: " + rs.getString("jour") + ",le Max des scripts est: " + rs.getInt("max(NBScripts)"));
            }
        }
        catch (SQLException e) {
           Logger.getLogger(ExoJDBC.class.getName()).log(Level.SEVERE, null, e);
        }
    }
             public static void OrdreDev() {
        String req = "SELECT Developpeurs, SUM(NBScripts) AS c FROM devdata GROUP BY Developpeurs ORDER BY c DESC";
        try {
            Statement stmt = getCn().createStatement();
            ResultSet rs = stmt.executeQuery(req);
            while (rs.next()) {
                System.out.println("Developer: " + rs.getString("Developpeurs") + ", Total Scripts: " + rs.getInt("c"));
            }
        }
        catch (SQLException e) {
           Logger.getLogger(ExoJDBC.class.getName()).log(Level.SEVERE, null, e);
        }
           }
                 public static void Somme() {
        String req = "SELECT SUM(NBScripts) AS t FROM devdata";
        try {
            Statement stmt = getCn().createStatement();
            ResultSet rs = stmt.executeQuery(req);
            while (rs.next()) {
                System.out.println("Le nombre totale des scripts est " + rs.getInt("t"));
            }
        }
        catch (SQLException e) {
           Logger.getLogger(ExoJDBC.class.getName()).log(Level.SEVERE, null, e);
        }}

    public static void SommeParDev(String developpeur) {
        String req = "SELECT SUM(NBScripts) AS total FROM devdata WHERE Developpeurs = '"+developpeur+"'";
        try {
            Statement stmt = getCn().createStatement();
            ResultSet rs = stmt.executeQuery(req);
            while (rs.next()) {
                System.out.println("Le nombre totale des scripts pour"+ developpeur +" est " + rs.getInt("total"));
            }
        }
        catch (SQLException e) {
           Logger.getLogger(ExoJDBC.class.getName()).log(Level.SEVERE, null, e);
        }
           }
             
}
    

