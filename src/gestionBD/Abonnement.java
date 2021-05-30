package gestionBD;

public class Abonnement {
	private int id;
	private int idPod;
	
	public Abonnement() {
		this.id = 0;
		this.idPod = 0;
	}

	public Abonnement(int id, int idPod) {
		this.id = id;
		this.idPod = idPod;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdPod() {
		return idPod;
	}

	public void setIdPod(int idPod) {
		this.idPod = idPod;
	}

}
