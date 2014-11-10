package modello;

/**
 * Modello di un generico file presente nella Lista
 * 
 * @author Giuseppe Restivo
 * 
 */
public class FileHandler {

	private String nomeFile;
	private int dimension;
	private Utente utente;
	private String path;

	public FileHandler(String nomeFile, int dimension, Utente utente,
			String path) {
		super();
		this.nomeFile = nomeFile;
		this.dimension = dimension;
		this.utente = utente;
		this.path = path;
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

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public String toString() {
		return nomeFile + " - " + dimension + " - " + utente.getCognome() + " "
				+ utente.getNome();
	}

}
