package multimedia.contents.readFile;

import java.util.ArrayList;
import java.util.StringTokenizer;

import modello.FileHandler;
import modello.LetturaIcone;
import modello.Utente;
import modello.dataio.IFileLineReader;

public class TestLetturaContenuti implements IFileLineReader {

	private ArrayList<FileHandler> contents;

	public TestLetturaContenuti(ArrayList<FileHandler> contents) {
		super();
		this.contents = contents;
	}

	@Override
	public void readLine(String line) {

		String[] token = line.split(",");

		String path = token[0];
		int dim = Integer.parseInt(token[1]);
		String cogn = token[2];
		String nome = token[3];
		Utente utente = new Utente(nome, cogn);
		String file = token[4];
		utente.setIp(token[5]);

		StringTokenizer tok = new StringTokenizer(file, ".");
		tok.nextToken();
		String estensione = tok.nextToken();
		String nomeFileAssociato = LetturaIcone.getLetturaIcone().impostaIcona(
				estensione);
		contents.add(new FileHandler(file, dim, utente, path, nomeFileAssociato));
	}
}
