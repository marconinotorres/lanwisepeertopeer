package multimedia.contents;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import modello.CartelleUtente;
import modello.FileHandler;
import modello.Icona;
import modello.Utente;
import modello.readIcone.LetturaFileIcone;
import multimedia.IMultimediaContents;
import rete.PeerAsClient;

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
			List<Icona> listaIcona = new ArrayList<Icona>();
			listaIcona = LetturaFileIcone.getLetturaIcone().getSetIcone().leggiFile();
			
			while (line!= null) {
				
				StringTokenizer token = new StringTokenizer(line,",");
				String path = token.nextToken();
				int dim = Integer.parseInt(token.nextToken());
				String cogn = token.nextToken();
				String nome = token.nextToken();
				Utente utente = new Utente(nome, cogn);
				String file = token.nextToken();
				utente.setIp(token.nextToken());
				
				StringTokenizer tok = new StringTokenizer(file,".");
				tok.nextToken();
				String estensione = tok.nextToken();
				
				String nomeIcona=null;
				
				for (int i = 0; i < listaIcona.size(); i++) {
					if (listaIcona.get(i).isContains(estensione)) {
						nomeIcona = LetturaFileIcone.getLetturaIcone().getPath()+listaIcona.get(i).getNomeIcona(estensione);
					}
				}
				if (nomeIcona == null) {
					nomeIcona = LetturaFileIcone.getLetturaIcone().getPath()+"sconosciuto.png";
				}
				
				contents.add(new FileHandler(file, dim, utente,path,nomeIcona));
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
