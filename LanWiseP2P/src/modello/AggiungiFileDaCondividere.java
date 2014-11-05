package modello;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JFileChooser;

/**
 * Aggiunge un file nella cartella Condivisa
 * 
 * @author Giuseppe Restivo
 * 
 */
public class AggiungiFileDaCondividere implements Servizio {

	/*
	 * (non-Javadoc)
	 * 
	 * @see modello.Servizio#service()
	 */
	@Override
	public void service() {

		JFileChooser chooser = new JFileChooser();
		chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		chooser.showOpenDialog(chooser);

		CartelleUtente ut = CartelleUtente.getInstance();

		File orig = new File(chooser.getSelectedFile().getAbsolutePath());
		File dest = new File(ut.getUpFolder());

		copiaFile(orig, new File(dest + "/" + orig.getName()));
	}

	private void copiaFile(File orig, File dest) {

		int letti = 0;
		long tot = 0;
		// inizializzo uno buffer di 4Kb
		byte[] buffer = new byte[6022386];
		// inizializzo stream per la copia del file
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {

			fis = new FileInputStream(orig);
			fos = new FileOutputStream(dest);
			while ((letti = fis.read(buffer)) != -1) {
				fos.write(buffer, 0, letti);
				tot += letti;
			}
			fis.close();
			fos.close();
		} catch (FileNotFoundException e) {

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
