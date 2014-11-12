package modello;

import java.util.ArrayList;
import java.util.List;

public class LetturaListaUtenti {

	//as Singleton
	private static LetturaListaUtenti utente = new LetturaListaUtenti();
	private LetturaListaUtenti() {
		// TODO Auto-generated constructor stub
	}
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
}
