package gestionBD;

public class Profil {
	private String name;
	private int idAbonnement;
	private String mdp;
	
	public Profil(String mdp) {
		// TODO Auto-generated constructor stub
		this.idAbonnement = 0;
		this.mdp = mdp;
	}
	
	public Profil(String name, String mdp, int idAbonnement) {
		this.name = name;
		this.idAbonnement = idAbonnement;
		this.mdp = mdp;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getIdAbonnement() {
		return idAbonnement;
	}
	public void setIdAbonnement(int idAbonnement) {
		this.idAbonnement = idAbonnement;
	}
	
	public void setMdpProfil(String mdp) {
		this.mdp = mdp;
	}
	public String getMdpProfil() {
		return this.mdp;
	}
}
