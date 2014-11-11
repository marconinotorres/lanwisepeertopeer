package modello.readIcone;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import modello.ISetIcone;
import modello.Icona;


public class LetturaFileIcone {

	private static LetturaFileIcone letturaIcone = new LetturaFileIcone();
	private LetturaFileIcone() {
		// TODO Auto-generated constructor stub
	}
	
	public static LetturaFileIcone getLetturaIcone() {
		return letturaIcone;
	}
	
	
	private ISetIcone setIcone;
	private String path;
	public void setSetIcone(ISetIcone setIcone) {
		this.setIcone = setIcone;
	}
	
	public ISetIcone getSetIcone() {
		return setIcone;
	}
	public String getPath(){
		return path;
	}
	public void setPath(String path){
		this.path = path;
	}
	
	/**
	 * Tutti i set di icone verranno aggiunte automaticamente alla lista dei set disponibili
	 * @return i nomi di tutti i set di icone disponibili dell'applicazione
	 */
	public String[] setIcone(){
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
