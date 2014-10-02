package modello.writeUtenti;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

import modello.Utente;

/**
 * 0 -> non è connesso
 * 1 -> è connesso
 * @author giusepperestivo
 *
 */
public class TestWriteConnessione extends UtenteWriter{

	@Override
	public void writeConnessione(String utenteCollegato,String carattere) {
		
		File file = new File("data/listaUtenti.txt");
		
		try {			
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = reader.readLine();
			FileWriter writer = new FileWriter(file);
			while (line!=null) {
				StringTokenizer token = new StringTokenizer(line);
				String nome = token.nextToken();
				String co = token.nextToken();
				String con = token.nextToken();
				System.err.println(utenteCollegato);
				if (co.equals(utenteCollegato)) {
					
					writer.write(nome+" "+co+" "+carattere);
					writer.write("\n");
					System.err.println("sono entrato nel test");
				}else{
					writer.write(nome+" "+co+" "+con);
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
