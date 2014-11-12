package modello.letturaListaUtenti;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import modello.LetturaListaUtenti;
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
		
		if (parts[2].equals("N")) {
			LetturaListaUtenti.getUtente().addUtente(new Utente(parts[0], parts[1]));
		}	
		
	}
}
