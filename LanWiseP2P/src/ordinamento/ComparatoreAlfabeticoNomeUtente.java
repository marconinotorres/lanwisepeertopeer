package ordinamento;

import java.util.Comparator;

import modello.ModelFile;

/**
 * Comparatore Alfabetico Per NomeUtente, ordina la lista in ordine alfabetico per nomeUtente
 * @author Giuseppe Restivo
 *
 */
public class ComparatoreAlfabeticoNomeUtente implements Comparator<ModelFile>{

	
	@Override
	public int compare(ModelFile file1, ModelFile file2) {
		
		return file1.getNomeUtente().compareTo(file2.getNomeUtente());
	}
}
