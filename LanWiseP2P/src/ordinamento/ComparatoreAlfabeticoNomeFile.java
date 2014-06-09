package ordinamento;

import java.util.Comparator;

import modello.FileHandler;


/**
 * Comparatore Alfabetico Per NomeFile, ordina la lista in ordine alfabetico per nomeFile
 * 
 * @author Giuseppe Restivo
 *
 */
public class ComparatoreAlfabeticoNomeFile implements Comparator<FileHandler> {

	
	
	@Override
	public int compare(FileHandler file1, FileHandler file2) {
		
		return file1.getNomeFile().compareTo(file2.getNomeFile());
	}
	
}

