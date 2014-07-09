package modello;

/**
 * Un generico file presente nella Lista
 * 
 * @author Giuseppe Restivo
 *
 */
public class FileHandler {

	
	private String nomeFile;
	private int dimension;
	private Utente utente;
	private String ip;
	
	public FileHandler(String nomeFile, String ip) {
		super();
		this.nomeFile = nomeFile;
		this.ip = ip;
	}
	
	

	public FileHandler(String nomeFile, int dimension, Utente utente, String ip) {
		super();
		this.nomeFile = nomeFile;
		this.dimension = dimension;
		this.utente = utente;
		this.ip = ip;
	}


	
	public int getDimension() {
		return dimension;
	}



	public void setDimension(int dimension) {
		this.dimension = dimension;
	}



	public Utente getUtente() {
		return utente;
	}



	public void setUtente(Utente utente) {
		this.utente = utente;
	}



	public String getNomeFile() {
		return nomeFile;
	}

	public void setNomeFile(String nomeFile) {
		this.nomeFile = nomeFile;
	}


	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}
	
	@Override
	public String toString() {
		return nomeFile+" - "+ip;
	}
	
}
