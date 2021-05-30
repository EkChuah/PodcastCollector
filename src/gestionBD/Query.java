package gestionBD;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import interpreteur.Audio;
import interpreteur.Media;
import interpreteur.Video;

import java.sql.ResultSet;

public class Query extends Connexion{

	
	public Query() {
		super();
	}

	public void deleteAllTable() throws SQLException {
		String sqlQuery1 = "DROP TABLE PodCollection;";
		String sqlQuery2 = "DROP TABLE Profil;";
		String sqlQuery3 = "DROP TABLE Abonnement;";
		String sqlQuery4 = "DROP TABLE Catecory;";
		
		Statement statement = this.connection.createStatement();
		try {
			statement.executeQuery(sqlQuery1);
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		try {
			statement.executeQuery(sqlQuery2);
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		try {
			statement.executeQuery(sqlQuery3);
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		try {
			statement.executeQuery(sqlQuery4);
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	/*
	public void createTableProfil() throws SQLException {
		String sqlQuery = "CREATE TABLE IF NOT EXISTS Profil (\n"
						+ "		name TEXT NOT NULL PRIMARY KEY,\n"
						+ " 	mdp TEXT NOT NULL,\n"
						+ "		idAbonnement integer DEFAULT 0\n"
						+ ");";
		
		Statement statement = this.connection.createStatement();
		try{
			statement.execute(sqlQuery);
			
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}
	*/

	public void createTableAbonnement() throws SQLException {
		String sqlQuery = "CREATE TABLE IF NOT EXISTS Abonnement (\n"
				  + "  	auteur PRIMARY KEY \n"
						+ ");";
		Statement statement = this.connection.createStatement();
		try{
			statement.execute(sqlQuery);
			
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}


	public void insertAbonnement(String auteur)throws SQLException {
		String query;
		query = "INSERT INTO Abonnement VALUES( '"+ auteur + "' );";
		Statement statement = this.connection.createStatement();
		try {
			System.out.println(query);
			statement.executeUpdate(query);
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public ArrayList<String> listeBDAbonnement(){

		ArrayList<String> listeBDAbonnement = new ArrayList<>();
		String query = "SELECT auteur FROM Abonnement ;";
		Statement statement;
		ResultSet rs;

		try {
			statement = this.connection.createStatement();
			rs = statement.executeQuery(query);
			while (rs.next()) {
				String auteur = rs.getString("auteur");
				listeBDAbonnement.add(auteur);
			}
		}
		catch(SQLException e){
			System.out.println(e.getMessage());
		}
		return listeBDAbonnement;
	}


	public int findIncrementId(String tableName) throws SQLException {
		String sqlQuery = "SELECT MAX(id) FROM " + tableName +";";
		Statement statement = this.connection.createStatement();
		ResultSet rs;
		try {
			rs = statement.executeQuery(sqlQuery);
			while(rs.next()) {
				int result = rs.getInt(1);
				return result + 1;
			}
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return 0;
	}
	
	public void createTablePodCollection() throws SQLException {
		String sqlQuery = "CREATE TABLE IF NOT EXISTS PodCollection (\n"
						+ "  	id INTEGER PRIMARY KEY \n"
						+ "		,titre TEXT\n"
						+ "		,auteur TEXT \n"
						+ "		,description TEXT \n"
						+ "		,date TEXT \n"
						+ "		,url TEXT \n"
						+ " 	,format TEXT \n"
						+ " 	,urlImage TEXT \n"
						+ " 	,category TEXT \n"
						+ ");";
		
		Statement statement = this.connection.createStatement();
		try{
			statement.execute(sqlQuery);
			
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}


	
	
	public void updateBase() {
		
	}
	
	public void insertPod(Media m) throws SQLException {
		String query;
		Statement statement = this.connection.createStatement();
		int increment = this.findIncrementId("PodCollection");
		String description = m.getDescription();
		String titre = m.getTitre();
		description = description.replace("\'", "%");
		titre = titre.replace("\'", "%");
		if(m instanceof Audio){
			Audio a = (Audio)m;
			query = "INSERT INTO PodCollection VALUES("
					+ increment + ", '" + titre + "', '" + m.getAuteur() + "', '" + description
					+ "', '" + m.getDate() + "', '" + m.getUrl() + "', '" + a.getFormat() + "', '" + a.getUrlImage() + "', '"
					+ a.getCategory() + "' );";
		}
		else {
			Video v = (Video)m;
			query = "INSERT INTO PodCollection VALUES("
					+ increment + ", '" + titre + "', '" + m.getAuteur() + "', '" + description
					+ "', '" + m.getDate() + "', '" + m.getUrl() + "', '" + v.getFormat() + "', '" + v.getUrlImage() + "', '"
					+ v.getCategory() + "' );";
		}
		try { 
			System.out.println(query);
			statement.executeUpdate(query);
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}


	public void createTableCategory() throws SQLException {
		String sqlQuery = "CREATE TABLE IF NOT EXISTS Category (\n"
				+ "  	category PRIMARY KEY \n"
				+ ");";

		Statement statement = this.connection.createStatement();
		try{
			statement.execute(sqlQuery);

		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}

	}


	public void insertCategory(String category)throws SQLException {
		String query;
		query = "INSERT INTO Category VALUES( '" + category + "' );";
		Statement statement = this.connection.createStatement();
		try {
			System.out.println(query);
			statement.executeUpdate(query);
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void insertProfil(Profil p) {
		Statement statement;
		String query;
		
		
		query = "INSERT INTO Profil VALUES(" + "'" + p.getName() + "' ," + "'" + p.getMdpProfil() +"'" +
				"," + p.getIdAbonnement() + "); ";
		
		try {
			statement = this.connection.createStatement();
			statement.executeUpdate(query);		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void selectAllFromProfil() {
		String query = "SELECT name, mdp, idAbonnement FROM Profil";
		Statement statement;
		ResultSet rs;
		try {
			statement = this.connection.createStatement();
			rs = statement.executeQuery(query);
			while(rs.next()) {
				System.out.println(rs.getString("name") + "\t" +
						rs.getInt("idAbonnement"));
			}
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void selectAllFrompodCollection() {
		String query = "SELECT id, titre, auteur, description, date, url, format, urlImage, category FROM PodCollection ;";
		Statement statement;
		ResultSet rs;
		try {
			statement = this.connection.createStatement();
			rs = statement.executeQuery(query);
			while(rs.next()) {
				System.out.println(rs.getInt("id") + "\t" +
						rs.getString("titre") + "\t" + rs.getString("auteur"));
			}
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public ArrayList<Media> remplirArrayMedia(){
		ArrayList<Media> listMedia = new ArrayList<Media>();
		
		String query = "SELECT id, titre, auteur, description, date, url, format, urlImage, category FROM PodCollection ;";
		Statement statement;
		ResultSet rs;
		try {
			statement = this.connection.createStatement();
			rs = statement.executeQuery(query);
			while(rs.next()) {
				String titre = rs.getString("titre");
				String auteur = rs.getString("auteur");
				String description = rs.getString("description");
				Date date = new Date();
				String url = rs.getString("url");
				String format = rs.getString("format");
				String urlImage = rs.getString("urlImage");
				String category = rs.getString("category");
				Media a;
				if(format.equals("mp3")){
					a = new Audio(titre, auteur, description, date, url, format, urlImage, category);
				}
				else{
					a = new Video(titre, auteur, description, date, url, format, urlImage, category);
				}
				listMedia.add(a);
				
			}
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return listMedia;
		
	}

	public ArrayList<String> listeCategory(){

		ArrayList<String> listeCategory = new ArrayList<>();
		String query = "SELECT category FROM Category ;";
		Statement statement;
		ResultSet rs;

		try {
			statement = this.connection.createStatement();
			rs = statement.executeQuery(query);
			while (rs.next()) {
				String category = rs.getString("category");
				listeCategory.add(category);
			}
		}
		catch(SQLException e){
			System.out.println(e.getMessage());
		}
		return listeCategory;
	}

	public ArrayList<Media> rechercheBDCategory(String categorie){

		ArrayList<Media> listMedia = new ArrayList<Media>();
		String query = "SELECT id, titre, auteur, description, date, url, format, urlImage, category FROM PodCollection WHERE category = '" + categorie + "' ;";
		Statement statement;
		ResultSet rs;

		try {
			statement = this.connection.createStatement();
			rs = statement.executeQuery(query);

			while(rs.next()) {
				String titre = rs.getString("titre");
				String auteur2 = rs.getString("auteur");
				String description = rs.getString("description");
				Date date = new Date();
				String url = rs.getString("url");
				String format = rs.getString("format");
				String urlImage = rs.getString("urlImage");
				String category = rs.getString("category");
				Media a;

				if(format.equals("mp3")){
					a = new Audio(titre, auteur2, description, date, url, format, urlImage, category);
				}
				else{
					a = new Video(titre, auteur2, description, date, url, format, urlImage, category);
				}
				listMedia.add(a);
			}
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}

		return listMedia;
	}

	public ArrayList<Media> rechercheBDAuteur(String auteur){
		ArrayList<Media> listMedia = new ArrayList<Media>();
		String query = "SELECT id, titre, auteur, description, date, url, format, urlImage, category FROM PodCollection WHERE auteur = '" + auteur + "' ;";


		Statement statement;
		ResultSet rs;

		try {

			statement = this.connection.createStatement();
			rs = statement.executeQuery(query);

			while(rs.next()) {
				String titre = rs.getString("titre");
				String auteur2 = rs.getString("auteur");
				String description = rs.getString("description");
				Date date = new Date();
				String url = rs.getString("url");
				String format = rs.getString("format");
				String urlImage = rs.getString("urlImage");
				String category = rs.getString("category");
				Media a;

				if(format.equals("mp3")){
					a = new Audio(titre, auteur2, description, date, url, format, urlImage, category);
				}
				else{
					a = new Video(titre, auteur2, description, date, url, format, urlImage, category);
				}
				listMedia.add(a);
			}

		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}

		return listMedia;
	}


/*
	public ArrayList<Media> rechercheBDMotCle(String motCle){
		ArrayList<Media> listMedia = new ArrayList<Media>();
		String nvMotCle = motCle.replace("\'","%");
		String query = "SELECT id, titre, auteur, description, date, url, format, urlImage, category FROM PodCollection WHERE description LIKE '%" + nvMotCle +"%' ;";


		Statement statement;
		ResultSet rs;

		try {

			statement = this.connection.createStatement();
			rs = statement.executeQuery(query);

			while(rs.next()) {
				String titre = rs.getString("titre");
				String auteur2 = rs.getString("auteur");
				String description = rs.getString("description");
				Date date = new Date();
				String url = rs.getString("url");
				String format = rs.getString("format");
				String urlImage = rs.getString("urlImage");
				String category = rs.getString("category");
				Media a;

				if(format.equals("mp3")){
					a = new Audio(titre, auteur2, description, date, url, format, urlImage, category);
				}
				else{
					a = new Video(titre, auteur2, description, date, url, format, urlImage, category);
				}
				listMedia.add(a);
			}

		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}

		return listMedia;
	}

*/
	//fonction de verification de connexion
	public int controlConnexion(String name, String mdp) {
		String query = "SELECT mdp FROM Profil WHERE name = '" + name + "' ;";
		Statement statement;
		ResultSet rs;
		try {
			statement = this.connection.createStatement();
			rs = statement.executeQuery(query);
			while(rs.next()) {
				String response = rs.getString("mdp");
				if(response.equals(mdp)) {
					System.out.println(response);
					return 1;
				}
				else {
					return 0;
				}
			}
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
			return 0;
		}
		return 0;
		
	}

	
}
