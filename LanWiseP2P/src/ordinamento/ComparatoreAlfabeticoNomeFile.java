package ordinamento;

import java.util.Comparator;

import modello.ModelFile;


/**
 * Comparatore Alfabetico Per NomeFile, ordina la lista in ordine alfabetico per nomeFile
 * 
 * @author Giuseppe Restivo
 *
 */
public class ComparatoreAlfabeticoNomeFile implements Comparator<ModelFile> {

	
	
	@Override
	public int compare(ModelFile file1, ModelFile file2) {
		
		return file1.getNomeFile().compareTo(file2.getNomeFile());
	}
	
}

