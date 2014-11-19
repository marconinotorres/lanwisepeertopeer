package modello.letturaListaUtenti;

import modello.ListaUtenti;
import modello.Utente;
import modello.dataio.IFileLineReader;

/**
 * @author Giuseppe Restivo
 * 
 */
public class TestReadUtenti implements IFileLineReader {

	/*
	 * (non-Javadoc)
	 * 
	 * @see modello.dataio.IFileLineReader#readLine(java.lang.String)
	 */
	@Override
	public void readLine(String line) {

		String[] parts = line.split(" ");
		boolean connessione = false;
		if (parts[2].equals("false")) {
			connessione = false;
		} else {
			connessione = true;
		}
		ListaUtenti.getUtenti().addUtente(
				new Utente(parts[0], parts[1], connessione));
	}
}
