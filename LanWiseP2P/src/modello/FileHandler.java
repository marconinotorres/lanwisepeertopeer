package modello;

/**
 * Un generico file presente nella Lista
 * 
 * @author Giuseppe Restivo
 *
 */
public class FileHandler {

	
	private String nomeFile;
	private String ip;
	
	public FileHandler(String nomeFile, String ip) {
		super();
		this.nomeFile = nomeFile;
		this.ip = ip;
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
