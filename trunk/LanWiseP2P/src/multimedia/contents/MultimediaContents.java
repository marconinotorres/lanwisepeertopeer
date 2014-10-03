package multimedia.contents;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import modello.FileHandler;
import modello.Utente;
import multimedia.IMultimediaContents;
import reti.CartelleUtente;
import reti.PeerAsClient;

/**
 * @author Giuseppe Restivo
 *
 */
public class MultimediaContents implements IMultimediaContents {
	
	private CartelleUtente utente = CartelleUtente.getInstance();

	private ArrayList<FileHandler> contents=new ArrayList<FileHandler>();
	
	/*
	 * (non-Javadoc)
	 * @see multimedia.IMultimediaContents#addContents(java.lang.String)
	 */
	@Override
	public void addContents(String nomeFile) {
		contents.clear();	

		try {
			BufferedReader in = new BufferedReader(new FileReader(nomeFile));
			String line = in.readLine();
			while (line!= null) {
				
				StringTokenizer token = new StringTokenizer(line,",");
				String file = token.nextToken();
				int dim = Integer.parseInt(token.nextToken());
				String cogn = token.nextToken();
				String nome = token.nextToken();
				Utente utente = new Utente(nome, cogn);
				
				contents.add(new FileHandler(file,dim,utente));
				line = in.readLine();
			} 
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
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
		
		return contents.get(index).toString();
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
