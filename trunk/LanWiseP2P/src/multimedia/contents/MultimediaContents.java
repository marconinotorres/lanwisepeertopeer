package multimedia.contents;

import java.util.ArrayList;

import modello.FileHandler;
import multimedia.IMultimediaContents;

/**
 * @author Giuseppe Restivo
 *
 */
public class MultimediaContents implements IMultimediaContents {

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
		System.out.println("Executing music "+contents.get(index));
	}
}
