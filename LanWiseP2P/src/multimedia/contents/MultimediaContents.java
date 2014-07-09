package multimedia.contents;

import java.io.File;
import java.util.ArrayList;

import modello.FileHandler;
import multimedia.IMultimediaContents;
import reti.PeerAsClient;
import reti.PeerAsServer;
import reti.CartelleUtente;

/**
 * @author Giuseppe Restivo
 *
 */
public class MultimediaContents implements IMultimediaContents {
	
	CartelleUtente utente = CartelleUtente.getInstance();

	private ArrayList<FileHandler> contents=new ArrayList<FileHandler>();
	
	public void addContents(ArrayList<FileHandler> multimedia){
		this.contents.addAll(multimedia);
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
	 * @see multimedia.IMultimediaContents#toString(int)
	 */
	@Override
	public String toString(int index) {
		
		return contents.get(index).getNomeFile()+" - "+contents.get(index).getIp();
	}
	
	/*
	 * (non-Javadoc)
	 * @see multimedia.IMultimediaContents#execute(int)
	 */
	@Override
	public void execute(int index) {
				
		String nomeFile = contents.get(index).getNomeFile();
		String ip = contents.get(index).getIp();
		File f = new File(nomeFile);
		String nomeFileGiusto = f.getName();
		
		PeerAsClient pac = new PeerAsClient();
		pac.IP_SERVER = ip;
		pac.FILE_TO_REQUEST = nomeFile;
		pac.FILE_TO_RECEIVED = utente.getDownFolder()+"/"+nomeFileGiusto;
		pac.start();
		
		System.out.println("Nome file: "+nomeFile+" / IP: "+ip);
	}
}
