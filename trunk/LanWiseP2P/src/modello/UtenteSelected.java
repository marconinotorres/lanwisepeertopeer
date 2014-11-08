package modello;


/**
 * Viene utilizzato il Pattern Singleton 
 * 
 * perchè una volta che un utente si è 'loggato' non può più cambiare.
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
	 * Scrive sul file che l'utente selezionato si è collegato o scollegato, allora imposta gli indici S (collegato) 
	 * ed N (scollegato)
	 * 
	 * @param utenteCollegato
	 * @param l'indice: 'S' o 'N'
	 */
	public abstract void writeConnessione(String utenteCollegato,
			String carattere);
}
