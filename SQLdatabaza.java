package balicek;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLdatabaza {
	public Connection pripojit() {
        Connection spojeni = null;
        try {
            
            Class.forName("org.sqlite.JDBC");
            
            String url = "jdbc:sqlite:moja_databaza.db";
            
            spojeni = DriverManager.getConnection(url);
            System.out.println("Připojení k databázi úspěšné!");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Nepodařilo se připojit k databázi!");
            e.printStackTrace();
        }
        return spojeni;
	}
	
	public void vytvoritTabulku() {
        try (Connection spojeni = pripojit()){
            Statement prikaz = spojeni.createStatement();
            
            String sql = "CREATE TABLE IF NOT EXISTS knihy (id INTEGER PRIMARY KEY AUTOINCREMENT, nazev TEXT, autor TEXT, rok_vydani INTEGER, dostupnost BOOLEAN)";
            prikaz.executeUpdate(sql);
            System.out.println("Tabulka byla úspěšně vytvořena!");
        } catch (SQLException e) {
            System.out.println("Nepodařilo se vytvořit tabulku!");
            e.printStackTrace();
        } finally {
            // Uzavření spojení s databází
            // ...
        }
    }

}
