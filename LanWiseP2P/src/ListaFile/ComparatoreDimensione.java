package listaFile;

import java.util.Comparator;

/**
 * Comparatore per dimensione del file
 * 
 * @author Giuseppe Restivo
 *
 */
public class ComparatoreDimensione implements Comparator<ListaFile> {

	
	
	@Override
	public int compare(ListaFile file1, ListaFile file2) {
		
		double size1 = file1.getDimensioneFile();
		double size2 = file2.getDimensioneFile();
		if(size1 <= size2){
			return 0;
		}else{
			return 1;
		}
	}
	
}
