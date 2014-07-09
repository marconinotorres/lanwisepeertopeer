package modello.readUtenti;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import modello.IUtenti;
import modello.Utente;

public class TestReadUtenti implements IUtenti{

	/*
	 * (non-Javadoc)
	 * @see modello.IUtenti#getUtenti()
	 */
	@Override
	public List<Utente> getUtenti() {
		File file = new File("data/listaUtenti.txt");
		List<Utente> utenti = new ArrayList<Utente>();
		utenti.clear();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = reader.readLine(); 
			while (line!=null) {
				StringTokenizer token = new StringTokenizer(line);
				String nome = token.nextToken();
				String cognome = token.nextToken();
				utenti.add(new Utente(nome, cognome));
				line = reader.readLine();
			}
			reader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return utenti;
	}
}
