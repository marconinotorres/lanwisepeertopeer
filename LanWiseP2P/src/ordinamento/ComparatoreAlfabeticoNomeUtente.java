package ordinamento;

import java.util.Comparator;

import modello.FileHandler;

/**
 * Comparatore Alfabetico Per NomeUtente, ordina la lista in ordine alfabetico
 * per nomeUtente
 * 
 * @author Giuseppe Restivo
 * 
 */
public class ComparatoreAlfabeticoNomeUtente implements Comparator<FileHandler> {

	@Override
	public int compare(FileHandler file1, FileHandler file2) {

		return file1.getUtente().getCognome()
				.compareTo(file2.getUtente().getCognome());
	}
}
