package modello.writeUtenti;

import java.util.List;

import modello.Utente;
import modello.readUtenti.UtenteReader;

public abstract class UtenteWriter {

	private static UtenteWriter utente;
	
	public static UtenteWriter getUtente() {
		return utente;
	}
	
	public static void setUtente(UtenteWriter utente) {
		UtenteWriter.utente = utente;
	}
	
	public abstract void writeConnessione(String utenteCollegato,String carattere);
	
	private String utenteCollegato;
	
	public String getUtenteCollegato() {
		return utenteCollegato;
	}
	public void setUtenteCollegato(String utenteCollegato2) {
		this.utenteCollegato = utenteCollegato2;
	}
}
