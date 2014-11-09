package ordinamento;

import java.util.Comparator;

import modello.FileHandler;

/**
 * Comparatore per dimensione del file
 * 
 * @author Giuseppe Restivo
 * 
 */
public class ComparatoreDimensione implements Comparator<FileHandler> {

	@Override
	public int compare(FileHandler file1, FileHandler file2) {

		double size1 = file1.getDimension();
		double size2 = file2.getDimension();
		if (size1 <= size2) {
			return -1;
		} else {
			return 1;
		}
	}

}
