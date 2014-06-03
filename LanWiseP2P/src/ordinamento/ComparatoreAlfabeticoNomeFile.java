package ordinamento;

import java.util.Comparator;

/**
 * Comparatore Alfabetico Per NomeFile, ordina la lista in ordine alfabetico per nomeFile
 * 
 * @author Giuseppe Restivo
 *
 */
public class ComparatoreAlfabeticoNomeFile implements Comparator<ModelListaFile> {

	
	
	@Override
	public int compare(ModelListaFile file1, ModelListaFile file2) {
		
		return file1.getNomeFile().compareTo(file2.getNomeFile());
	}
	
}

