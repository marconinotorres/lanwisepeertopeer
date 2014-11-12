package multimedia.contents;

import java.util.ArrayList;

import modello.CartelleUtente;
import modello.FileHandler;
import modello.dataio.StringLinesReader;
import multimedia.IMultimediaContents;
import multimedia.contents.readFile.TestLetturaContenuti;
import rete.PeerAsClient;

/**
 * @author Giuseppe Restivo
 *
 */
public class MultimediaContents implements IMultimediaContents {
	
	private CartelleUtente utente = CartelleUtente.getInstance();

	private ArrayList<FileHandler> contents=new ArrayList<FileHandler>();

	@Override
	public void readContentsFile() {
		contents.clear();	
		(new StringLinesReader(new TestLetturaContenuti(contents))).readFile("data/OtherFilesList.txt");;
	}

	/*
	 * (non-Javadoc)
	 * @see multimedia.IMultimediaContents#getContentsList()
	 */
	@Override
	public ArrayList<FileHandler> getContentsList() {		
		return contents;
	}
	
	
	/* (non-Javadoc)
	 * @see contenutiMultimediali.IMultimediaContents#getContentsLength()
	 */
	@Override
	public int getContentsLength(){
		return contents.size();
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see multimedia.IMultimediaContents#execute(int)
	 */
	@Override
	public void execute(int index) {
				
		String nomeFile = contents.get(index).getPath();
		String ip = contents.get(index).getUtente().getIp();
		
		String nomeFileGiusto = contents.get(index).getNomeFile();
		
		
		PeerAsClient pac = new PeerAsClient();
		
		pac.setIP_SERVER(ip);
		pac.setFILE_TO_RECEIVED(utente.getDownFolder()+"/"+nomeFileGiusto);
		pac.setFILE_TO_REQUEST(nomeFile);
		pac.start();
		
	}
}
