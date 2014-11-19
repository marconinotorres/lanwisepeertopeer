package modello.letturaListaUtenti;

import java.util.Iterator;

import modello.ListaUtenti;
import modello.Utente;

/**
 * Riscrive il file 'listaUtenti.txt' quando un utente si connette, in questo
 * modo è possibile tener traccia dello stato delle connessioni
 * 
 * @author Giuseppe Restivo
 * 
 */
public class TestWriteChangeConnessione implements Iterator<String> {

	private Iterator<Utente> utente = ListaUtenti.getUtenti().getListaUtenti()
			.iterator();

	@Override
	public boolean hasNext() {
		return utente.hasNext();
	}

	@Override
	public String next() {
		Utente ut = utente.next();
		return ut.toString();
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub

	}

}
