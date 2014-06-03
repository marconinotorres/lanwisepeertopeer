package ordinamento;

import java.util.Comparator;

import modello.ModelFile;

/**
 * Comparatore per dimensione del file
 * 
 * @author Giuseppe Restivo
 *
 */
public class ComparatoreDimensione implements Comparator<ModelFile> {

	
	
	@Override
	public int compare(ModelFile file1, ModelFile file2) {
		
		double size1 = file1.getDimensioneFile();
		double size2 = file2.getDimensioneFile();
		if(size1 <= size2){
			return 0;
		}else{
			return 1;
		}
	}
	
}

