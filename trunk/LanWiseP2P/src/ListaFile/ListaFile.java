package listaFile;

/**
 * Un generico file presente nella Lista
 * @author Giuseppe Restivo
 *
 */
public class ListaFile {

	
	private String nomeFile;
	private double dimensioneFile;
	private String nomeUtente;
	
	public ListaFile(String nomeFile, double dimensioneFile, String nomeUtente) {
		super();
		this.nomeFile = nomeFile;
		this.dimensioneFile = dimensioneFile;
		this.nomeUtente = nomeUtente;
	}

	public String getNomeFile() {
		return nomeFile;
	}

	public void setNomeFile(String nomeFile) {
		this.nomeFile = nomeFile;
	}

	public double getDimensioneFile() {
		return dimensioneFile;
	}

	public void setDimensioneFile(double dimensioneFile) {
		this.dimensioneFile = dimensioneFile;
	}

	public String getNomeUtente() {
		return nomeUtente;
	}

	public void setNomeUtente(String nomeUtente) {
		this.nomeUtente = nomeUtente;
	}
	
	@Override
	public String toString() {
		return nomeFile+"  -  "+dimensioneFile+"  -  "+nomeUtente;
	}
	
}
