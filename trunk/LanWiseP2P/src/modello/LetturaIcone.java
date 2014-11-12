package modello;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class LetturaIcone {

	//as Singleton
	private static LetturaIcone letturaIcone = new LetturaIcone();
	private LetturaIcone() {
		// TODO Auto-generated constructor stub
	}
	
	public static LetturaIcone getLetturaIcone() {
		return letturaIcone;
	}
	
	//as Class
	private List<Icona> listaIcone = new ArrayList<Icona>();
	private String pathDirectory;
	
	public void addIcona(Icona icona){
		listaIcone.add(icona);
	}
	
	public List<Icona> getListaIcone() {
		return listaIcone;
	}
	
	/**
	 * Imposta il nome della directory contenente le icone da visualizzare
	 * @param nome directory
	 */
	public void setNomeDirectory(String nomeDirectory) {
		this.pathDirectory = nomeDirectory;
	}
	
	public String getNomeDirectory() {
		return pathDirectory;
	}
	
	/**
	 * Legge dentro la directory 'icone' tutti i set di icone disponibili
	 * 
	 * Tutti i set di icone,quindi, verranno aggiunte automaticamente alla lista dei set disponibili
	 * 
	 * @return i nomi delle directory che contengono tutti i set di icone disponibili.
	 */
	public String[] readDirectoryIcone(){
		List<String> listaDirectoryIcone = new ArrayList<String>();
		File file = new File("icone");
		
		File[] lista = file.listFiles();
		for (int i = 0; i < lista.length; i++) {
			if (lista[i].isDirectory()) {
				listaDirectoryIcone.add(lista[i].getName());
			}
		}
		return listaDirectoryIcone.toArray(new String[listaDirectoryIcone.size()]);
	}
	
	public String impostaIcona(String estensione) {
		String nomeIcona = null;
		for (int i = 0; i < listaIcone.size(); i++) {
			if (listaIcone.get(i).isContains(estensione)) {
				nomeIcona = getNomeDirectory()+
						listaIcone.get(i).getNomeIcona(estensione);
			}
		}
		if (nomeIcona == null) {
			nomeIcona = getNomeDirectory()+"sconosciuto.png";
		}
		return nomeIcona;
	}
}
