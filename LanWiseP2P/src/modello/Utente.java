package modello;

/**
 * Modello di un generico Utente
 * 
 * @author giusepperestivo
 * 
 */
public class Utente {

	private String nome, cognome;
	private String ip;
	private boolean connesso;

	
	public Utente(String nome, String cognome, boolean connesso) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.connesso = connesso;
	}

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

	public boolean isConnesso() {
		return connesso;
	}
	public void setConnesso(boolean connesso) {
		this.connesso = connesso;
	}
	
	@Override
	public String toString() {
		return nome + " " + cognome + " " + connesso;
	}
}
