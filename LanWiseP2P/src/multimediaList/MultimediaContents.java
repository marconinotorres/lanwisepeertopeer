package multimediaList;

import java.util.ArrayList;

import modello.FileHandler;

public class MultimediaContents implements IMultimediaContents {

	private ArrayList<FileHandler> list = new ArrayList<>();
	
	
	public ArrayList<FileHandler> getList() {
		return list;
	}
	public void add(FileHandler file){
			list.add(file);
	}
	
	/* (non-Javadoc)
	 * @see multimediaList.IMultimediaContents#getTitle(int)
	 */
	@Override
	public String getTitle(int index){
		return list.get(index).getNomeFile();
	}

	/* (non-Javadoc)
	 * @see multimediaList.IMultimediaContents#sizeList()
	 */
	@Override
	public int sizeList(){
		return list.size();
	}
	
	
	@Override
	public String toString(int index) {
		
		return list.get(index).getNomeFile()+"   -   "+list.get(index).getDimensioneFile()+"   -   "+
				list.get(index).getNomeUtente();
	}
}
