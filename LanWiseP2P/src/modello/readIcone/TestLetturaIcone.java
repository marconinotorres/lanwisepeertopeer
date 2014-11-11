package modello.readIcone;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import modello.Icona;

public class TestLetturaIcone implements ISetIcone{

	private List<Icona> lista = new ArrayList<Icona>();
	
	private File file;
	
	public TestLetturaIcone(String path) {
		super();
		file = new File(path);
	}

	/*
	 * (non-Javadoc)
	 * @see modello.readIcone.ISetIcone#leggiFile()
	 */
	@Override
	public List<Icona> leggiFile() {
		
		lista.clear();	
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = reader.readLine();
			
			while (line !=null) {
				StringTokenizer token = new StringTokenizer(line,":");
				
				String est = token.nextToken();
				String nome = token.nextToken();
				Icona ico = new Icona();
				ico.addIcona(est, nome);
				
				lista.add(ico);
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
