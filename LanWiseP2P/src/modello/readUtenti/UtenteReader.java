package modello.readUtenti;

import java.util.List;

import modello.Utente;

public abstract class UtenteReader {

	private static UtenteReader utente;
	
	public static UtenteReader getUtente() {
		return utente;
	}
	
	public static void setUtente(UtenteReader utente) {
		UtenteReader.utente = utente;
	}
	
	public abstract List<Utente> readFileUtente();
}
