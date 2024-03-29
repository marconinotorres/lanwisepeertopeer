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
	private String path;
	private String icona;

	public FileHandler(String nomeFile, int dimension, Utente utente,
			String path, String icona) {
		super();
		this.nomeFile = nomeFile;
		this.dimension = dimension;
		this.utente = utente;
		this.path = path;
		this.icona = icona;
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

	public String getIcona() {
		return icona;
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
