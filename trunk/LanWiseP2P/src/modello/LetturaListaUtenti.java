package modello;

import java.util.ArrayList;
import java.util.List;

public class LetturaListaUtenti {

	private static LetturaListaUtenti utente = new LetturaListaUtenti();

	public static LetturaListaUtenti getUtente() {
		return utente;
	}

	//as Class
	private List<Utente> utenti = new ArrayList<Utente>();
	
	public void addUtente(Utente utente){
		utenti.add(utente);
	}
	
	public List<Utente> getUtenti() {
		return utenti;
	}
	
	/**
	 * Effettua la lettura di tutti gli utenti, non è ancora noto la fonte da
	 * cui si avrà la lista
	 * 
	 * @return la lista degli utenti che possono accedere all'applicazione
	 */
	//public abstract List<Utente> readFileUtente(List<Utente> utente);
}
