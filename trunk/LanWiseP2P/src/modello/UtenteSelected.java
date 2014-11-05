package modello;


/**
 * Viene utilizzato il Patter singleton 
 * 
 * perch� una volta che un utente si � 'loggato' non pu� pi� modificarsi.
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
	 * Scrive sul file che l'utente generico si � collegato, allora imposta gli indici S ed N
	 * 
	 * @param utenteCollegato
	 * @param l'indice: 'S' o 'N'
	 */
	public abstract void writeConnessione(String utenteCollegato,
			String carattere);
}
