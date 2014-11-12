package modello.readIcone;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import modello.ISetIcone;
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
			BufferedReader reader = new BufferedReader(new FileReader(file+"/fslook.txt"));
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
	
	/*
	 * (non-Javadoc)
	 * @see modello.ISetIcone#setIcone()
	 */
	public String[] readDirectoryIcone(){
		List<String> listaIcone = new ArrayList<String>();
		File file = new File("icone");
		
		File[] lista = file.listFiles();
		for (int i = 0; i < lista.length; i++) {
			if (lista[i].isDirectory()) {
				listaIcone.add(lista[i].getName());
			}
		}
		return listaIcone.toArray(new String[listaIcone.size()]);
	}
}
