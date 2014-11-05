package tests;

import java.util.ArrayList;

import ordinamento.FiltraPerDimensioneFile;
import ordinamento.FiltraPerNomeFile;
import ordinamento.ProxyOrdinamento;
import modello.FileHandler;

public class TestOrdinamento {

	public static void main(String[] args) {
		
		ArrayList<FileHandler> lista  = new ArrayList<FileHandler>();

		lista.add(new FileHandler("a", 2, null, null));
		lista.add(new FileHandler("c", 9, null, null));
		lista.add(new FileHandler("b", 1, null, null));
		
		ProxyOrdinamento ordina = new ProxyOrdinamento(new FiltraPerNomeFile());
		ArrayList<FileHandler> ordinato = ordina.filtraListaFile(lista);
		for (int i = 0; i < ordinato.size(); i++) {
			System.out.println(ordinato.get(i).getNomeFile());
		}
		
		ProxyOrdinamento ordi = new ProxyOrdinamento(new FiltraPerDimensioneFile());
		ArrayList<FileHandler> ordinato2 = ordi.filtraListaFile(lista);
		for (int i = 0; i < ordinato2.size(); i++) {
			System.out.println(ordinato2.get(i).getDimension());
		}
	}

}
