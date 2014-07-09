package modello;

/**
 * Identifica tramite nome e cognome gli utenti che possono accedere all'applicazione
 * 
 * @author giusepperestivo
 *
 */
public class Utente {

	private String nomeUtente, cognomeUtente;

	public Utente(String nomeUtente, String cognomeUtente) {
		super();
		this.nomeUtente = nomeUtente;
		this.cognomeUtente = cognomeUtente;
	}

	public String getNomeUtente() {
		return nomeUtente;
	}

	public void setNomeUtente(String nomeUtente) {
		this.nomeUtente = nomeUtente;
	}

	public String getCognomeUtente() {
		return cognomeUtente;
	}

	public void setCognomeUtente(String cognomeUtente) {
		this.cognomeUtente = cognomeUtente;
	}

	
	
}
