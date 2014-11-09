package modello;

import java.util.List;

public abstract class LetturaListaUtenti {

	private static LetturaListaUtenti utente;

	public static LetturaListaUtenti getUtente() {
		return utente;
	}

	public static void setUtente(LetturaListaUtenti utente) {
		LetturaListaUtenti.utente = utente;
	}

	/**
	 * Effettua la lettura di tutti gli utenti, non è ancora noto la fonte da
	 * cui si avrà la lista
	 * 
	 * @return la lista degli utenti che possono accedere all'applicazione
	 */
	public abstract List<Utente> readFileUtente();
}
