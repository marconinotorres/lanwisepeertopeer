package modello.letturaListaUtenti;


import modello.ListaUtenti;
import modello.Utente;
import modello.dataio.IFileLineReader;

/**
 * N -> non è connesso S -> è connesso
 * 
 * Per il momento legge da un file di testo, ma sarà sostituita da una possibile
 * base di dati
 * 
 * @author Giuseppe Restivo
 * 
 */
public class TestReadUtenti implements IFileLineReader {

	/*
	 * (non-Javadoc)
	 * @see modello.dataio.IFileLineReader#readLine(java.lang.String)
	 */
	@Override
	public void readLine(String line) {
		
		String[] parts = line.split(" ");
		boolean conn = false;
		if (parts[2].equals("false")) {
			conn = false;
		}else{
			conn = true;
		}
		ListaUtenti.getUtenti().addUtente(new Utente(parts[0], parts[1], conn));		
	}
}
