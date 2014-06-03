package ordinamento;

import java.util.Comparator;

/**
 * Comparatore per dimensione del file
 * 
 * @author Giuseppe Restivo
 *
 */
public class ComparatoreDimensione implements Comparator<ModelListaFile> {

	
	
	@Override
	public int compare(ModelListaFile file1, ModelListaFile file2) {
		
		double size1 = file1.getDimensioneFile();
		double size2 = file2.getDimensioneFile();
		if(size1 <= size2){
			return 0;
		}else{
			return 1;
		}
	}
	
}

