package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import modello.FileHandler;
import modello.Utente;
import ordinamento.FiltraPerDimensioneFile;
import ordinamento.FiltraPerNomeFile;
import ordinamento.FiltraPerNomeUtente;
import ordinamento.ProxyOrdinamento;

import org.junit.Before;
import org.junit.Test;

public class TestOrdinamento {

	private ArrayList<FileHandler> lista = new ArrayList<FileHandler>();

	@Before
	public void init() {
		lista.clear();

		lista.add(new FileHandler("prova1", 10, new Utente("Giuseppe",
				"Restivo"), null, null));
		lista.add(new FileHandler("prova5", 50, new Utente("Marco", "Cortesi"),
				null, null));
		lista.add(new FileHandler("prova4", 30, new Utente("Nicola", "Blago"),
				null, null));
		lista.add(new FileHandler("prova7", 15,
				new Utente("Federico", "Bacci"), null, null));
		lista.add(new FileHandler("prova6", 20, new Utente("Stefano",
				"Azzolini"), null, null));
	}

	@Test
	public void ordinamentoPerNomeUtente() {

		ArrayList<FileHandler> atteso = new ArrayList<FileHandler>();
		atteso.add(lista.get(4));
		atteso.add(lista.get(3));
		atteso.add(lista.get(2));
		atteso.add(lista.get(1));
		atteso.add(lista.get(0));
		ProxyOrdinamento ordinamento = new ProxyOrdinamento(
				new FiltraPerNomeUtente());

		for (int i = 0; i < atteso.size(); i++) {
			assertEquals(atteso.get(i).getUtente().getCognome(), ordinamento
					.filtraListaFile(lista).get(i).getUtente().getCognome());
		}
	}

	@Test
	public void ordinamentoPerNomeFile() {

		ArrayList<FileHandler> atteso = new ArrayList<FileHandler>();
		atteso.add(lista.get(0));
		atteso.add(lista.get(2));
		atteso.add(lista.get(1));
		atteso.add(lista.get(4));
		atteso.add(lista.get(3));
		ProxyOrdinamento ordinamento = new ProxyOrdinamento(
				new FiltraPerNomeFile());

		for (int i = 0; i < atteso.size(); i++) {
			assertEquals(atteso.get(i).getNomeFile(), ordinamento
					.filtraListaFile(lista).get(i).getNomeFile());
		}
	}

	@Test
	public void ordinamentoPerDimensione() {

		ArrayList<FileHandler> atteso = new ArrayList<FileHandler>();
		atteso.add(lista.get(0));
		atteso.add(lista.get(3));
		atteso.add(lista.get(4));
		atteso.add(lista.get(2));
		atteso.add(lista.get(1));

		ProxyOrdinamento ordinamento = new ProxyOrdinamento(
				new FiltraPerDimensioneFile());

		for (int i = 0; i < atteso.size(); i++) {
			assertEquals(atteso.get(i).getDimension(), ordinamento
					.filtraListaFile(lista).get(i).getDimension());
		}
	}

}
