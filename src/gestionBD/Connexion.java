package gestionBD;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion {
	protected String URL;
	protected Connection connection = null;	//Pour stocker la connexion
	
	//Pour cr�er une instance de Connexion
	public Connexion(String URL) {
		// TODO Auto-generated constructor stub
		this.URL = "jdbc:sqlite:" + URL;
	}
	
	//Constructeur par d�faut
	public Connexion() {
		this.URL = "jdbc:sqlite:./BaseDeDonnees/Donnees";
	}
	
	//Pour permettre l'ouverture de connexion
	public void connect() throws SQLException {
		try{	//si la base n'existe pas d'apr�s l'URL indiqu�e, elle sera cr��e
			
			Connection conn = DriverManager.getConnection(URL);		//Connexion
			this.connection = conn;
			
			if(conn != null) {		//si tout s'est pass� correctement
				DatabaseMetaData meta = conn.getMetaData();
				System.out.println("Connexion �tablie avec la base de donn�es: " + this.URL + "\n");
			}
		} 
		catch(SQLException e) {		//On attrape les �ventuels soucis de connexion
			System.out.println(e.getMessage());
		}
	}
	//Pour permettre la fermeture de connexion
	public void close() {
		try {
			this.connection.close();
			System.out.println("Fermeture de connexion\n");
			
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
