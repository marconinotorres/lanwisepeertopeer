package modello;

/**
 * Imposta l'utente che si � collegato all'applicazione
 * Viene utilizzato il Pattern Singleton
 * perch� una volta che un utente si � 'loggato' non pu˜ pi� cambiare.
 * 

 * 
 * @author giusepperestivo
 * 
 */
public abstract class UtenteSelected {

	private static UtenteSelected utenteSelected;

	public static UtenteSelected getUtente() {
		return utenteSelected;
	}

	public static void setUtente(UtenteSelected utente) {
		UtenteSelected.utenteSelected = utente;
	}

	private Utente utenteCollegato;

	public Utente getUtenteCollegato() {
		return utenteCollegato;
	}

	public void setUtenteCollegato(Utente utenteCollegato2) {
		this.utenteCollegato = utenteCollegato2;
	}

	/**
	 * Scrive sul file che l'utente selezionato si � collegato o scollegato,
	 * allora imposta gli indici S (collegato) ed N (scollegato)
	 * 
	 * @param utenteCollegato
	 * @param l
	 *            'indice: 'S' o 'N'
	 */
	public abstract void writeConnessione(String utenteCollegato,
			String carattere);
}
