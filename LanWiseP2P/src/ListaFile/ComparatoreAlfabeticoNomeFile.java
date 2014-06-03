package listaFile;

import java.util.Comparator;

/**
 * Comparatore Alfabetico Per NomeFile, ordina la lista in ordine alfabetico per nomeFile
 * 
 * @author Giuseppe Restivo
 *
 */
public class ComparatoreAlfabeticoNomeFile implements Comparator<ListaFile> {

	
	
	@Override
	public int compare(ListaFile file1, ListaFile file2) {
		
		return file1.getNomeFile().compareTo(file2.getNomeFile());
	}
	
}
