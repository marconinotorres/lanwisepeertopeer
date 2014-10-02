package modello;

import java.util.ArrayList;

/**
 * Generico Utente che si collega
 * 
 * @author giusepperestivo
 *
 */
public class Utente implements IListaUtenti{

	private static Utente utente = new Utente();
	private Utente() {
		// TODO Auto-generated constructor stub
	}
	
	public static Utente getUtente() {
		return utente;
	}
	
	private ArrayList<String> listaUtenti = new ArrayList<String>();
	private String utenteSelezionato;
	
	public void addUtente(String utente){
		listaUtenti.add(utente);
	}
	
	public void setUtenteSelezionato(String utenteSelezionato) {
		this.utenteSelezionato = utenteSelezionato;
	}
	
	public String getUtenteSelezionato() {
		return utenteSelezionato;
	}
	
	//restituisce true se si sta tentando di accedere con un nomeUtente giˆ connesso
	public boolean controlloAccessi(String nomeUtenteSelezionato){
		
		boolean verifica = false;
		int count = 0;
		for (int i = 0; i < listaUtenti.size(); i++) {
			String utente = listaUtenti.get(i);
			if(nomeUtenteSelezionato.equals(utente)){
				count++;
			}
		}
		if(count==1){
			verifica = false;
		}else
			verifica = true;
		return verifica;
	}
	
	
	@Override
	public ArrayList<String> getListaUtenti() {
		listaUtenti.add("Giuseppe Restivo");
		listaUtenti.add("Nicola Blago");
		listaUtenti.add("Federico Bacci");
		listaUtenti.add("Stefano Azzolina");
		listaUtenti.add("Marco Cortesi");
		return listaUtenti;
	}
	@Override
	public String toString(int index) {
		return getListaUtenti().get(index);
	}
}
