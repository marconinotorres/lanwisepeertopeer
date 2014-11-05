package modello;

/**
 * Generico Utente
 * 
 * @author giusepperestivo
 * 
 */
public class Utente {

	private String nome, cognome;
	private String ip;

	public Utente(String nome, String cognome) {
		super();
		this.nome = nome;
		this.cognome = cognome;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getIp() {
		return ip;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

}
