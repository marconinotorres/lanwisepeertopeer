package modello.readUtenti;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import modello.Utente;

/**
 * 0 -> non è connesso
 * 1 -> è connesso
 * @author giusepperestivo
 *
 */
public class TestReadUtenti extends UtenteReader{

	@Override
	public List<Utente> readFileUtente() {
		
		List<Utente> lista = new ArrayList<>();

		File file = new File("data/listaUtenti.txt");
		
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = reader.readLine(); 
			while (line!=null) {
				
				StringTokenizer token = new StringTokenizer(line);
				String nome = token.nextToken();
				String cognome = token.nextToken();
				String conn = token.nextToken();
				
				if (conn.equals("N")) {
					lista.add(new Utente(nome, cognome));
				}
				
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

		return lista;

	}
}
