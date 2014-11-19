package modello;

import java.util.ArrayList;
import java.util.List;

/**
 * Unica istanza di tutti gli utenti che possono collegarsi al programma
 * 
 * @author Giuseppe Restivo
 * 
 */
public class ListaUtenti {

	// Singleton
	private static ListaUtenti utenti = new ListaUtenti();

	private ListaUtenti() {
		// TODO Auto-generated constructor stub
	}

	public static ListaUtenti getUtenti() {
		return utenti;
	}

	// as Class
	private List<Utente> listaUtenti = new ArrayList<Utente>();
	private Utente utenteSelected;

	public void addUtente(Utente utente) {
		listaUtenti.add(utente);
	}

	public List<Utente> getListaUtenti() {
		return listaUtenti;
	}

	/**
	 * Imposta l'utente che si è connesso
	 * 
	 * @param l
	 *            'indice di riferimento all'interno della lista
	 */
	public void setUtenteSelected(int index) {
		this.utenteSelected = listaUtenti.get(index);
	}

	public Utente getUtenteSelected() {
		return utenteSelected;
	}

	/**
	 * Ritorna lo stato di connessione dell'utente
	 * 
	 * @param utente
	 * @return true se l'utente è connesso, false altrimenti
	 */
	public boolean isConnected(Utente utente) {

		boolean connessione = false;
		for (int i = 0; i < ListaUtenti.getUtenti().getListaUtenti().size(); i++) {
			if (listaUtenti.get(i).getCognome().equals(utente.getCognome())
					&& listaUtenti.get(i).getNome().equals(utente.getNome())) {
				connessione = listaUtenti.get(i).isConnesso();
			}
		}
		return connessione;
	}

	/**
	 * Crea una lista a parte che contiene gli utenti che non sono connessi
	 * 
	 * @return la lista di utenti non connessi
	 */
	public List<Utente> getListaUtentiDaVisualizzare() {
		List<Utente> lista = new ArrayList<Utente>();
		lista.clear();
		for (int i = 0; i < getListaUtenti().size(); i++) {
			if (!getListaUtenti().get(i).isConnesso()) {
				lista.add(getListaUtenti().get(i));
			}
		}
		return lista;
	}

	/**
	 * Imposta true agli utenti che sono già collegati
	 * 
	 * @param indirizzo
	 *            ip dell'utente connesso
	 */
	public void impostaConnessioni(String ip) {
		for (int i = 0; i < ListaUtenti.getUtenti().getListaUtenti().size(); i++) {
			if (ListaUtenti.getUtenti().getListaUtenti().get(i).getIp()
					.equals(ip)) {
				ListaUtenti.getUtenti().getListaUtenti().get(i)
						.setConnesso(true);
			}
		}
	}
}
