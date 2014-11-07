package modello.service;

import java.io.File;

import javax.swing.JFileChooser;

import modello.CartelleUtente;
import modello.Servizio;

/**
 * Rimuove un file dalla Cartella condivisa
 * 
 * @author Giuseppe Restivo
 * 
 */
public class RimuoviFileCondiviso implements Servizio {

	/*
	 * (non-Javadoc)
	 * 
	 * @see modello.Servizio#service()
	 */
	@Override
	public void service() {

		CartelleUtente utente = CartelleUtente.getInstance();
		JFileChooser chooser = new JFileChooser();

		chooser.setCurrentDirectory(new File(utente.upFolder));
		chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		chooser.showDialog(chooser, "remove");

		File file = new File(chooser.getSelectedFile().getAbsolutePath());
		file.delete();

	}
}
