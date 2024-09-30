
package exo1;
import java.sql.*;
import java.util.Scanner;

public class ExoJDBC2 {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
System.out.print("Entrez votre requête SQL : ");
String query = scanner.nextLine();
try{
Statement stmt = ExoJDBC.getCn().createStatement();
if (stmt.execute(query)) {
    ResultSet rs = stmt.getResultSet();
ResultSetMetaData rsmd = rs.getMetaData();
int nmbcolonne = rsmd.getColumnCount();
System.out.println("Nombre de colonnes : " + nmbcolonne);
for (int i = 1; i <= nmbcolonne; i++) {
    System.out.println("Colonne " + i + ": " + rsmd.getColumnName(i) + " - Type: " + rsmd.getColumnTypeName(i));
}
while (rs.next()) {
    for (int i = 1; i <= nmbcolonne; i++) {
        System.out.print(rs.getString(i) + " ");
    }
    System.out.println();
}
} else { // La requête ne retourne pas de ResultSet
    int rowCount = stmt.getUpdateCount();
    System.out.println("Nombre de lignes affectées : " + rowCount);
}
} catch (SQLException e) {
}
}
    
}
