package modello.writeUtenteSelezionato;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

import modello.Utente;
import modello.UtenteSelected;

/**
 * Imposta nel file "listaUtenti.txt" 'N' o 'S' l'indice N indica che l'utente
 * non è collegato, S invece, indica che l'utente è connesso.
 * 
 * @author Giuseppe Restivo
 * 
 */
public class TestWriteConnessione extends UtenteSelected {

	@Override
	public void writeConnessione(String utenteCollegato, String carattere) {

		File file = new File("data/listaUtenti.txt");

		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = reader.readLine();
			FileWriter writer = new FileWriter(file);

			while (line != null) {
				StringTokenizer token = new StringTokenizer(line);
				String nome = token.nextToken();
				String co = token.nextToken();
				String con = token.nextToken();

				if (co.equals(utenteCollegato)) {

					writer.write(nome + " " + co + " " + carattere);
					writer.write("\n");
				} else {
					writer.write(nome + " " + co + " " + con);
					writer.write("\n");

				}
				line = reader.readLine();

			}
			writer.close();
			reader.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
