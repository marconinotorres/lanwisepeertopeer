package modello;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.SwingWorker;

public class ListaCondivisione {

	ArrayList<FileHandler> multimedia = new ArrayList<FileHandler>();

	private static ListaCondivisione instance;

	private ListaCondivisione() {
	}
	
	public static synchronized ListaCondivisione getInstance() {
		if (instance == null) {
			instance = new ListaCondivisione();
		}
		return instance;
	}
	

	public ArrayList<FileHandler> getMultimedia() {
		multimedia.clear();	

		try {
			BufferedReader in = new BufferedReader(new FileReader("OtherFilesList.txt"));
			String line;
			while ((line = in.readLine()) != null) {
				multimedia.add(new FileHandler(line, in.readLine()));
			} 
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return multimedia;
	}
	
	

}



