package multimediaList;

public class Placer  implements IPlacer{

	public static final int VERTICAL = 0;
	
	private int positing;
	
	public void setPositing(int positing) {
		this.positing = positing;
	}
	
	VerticalPlacer vPlacer = new VerticalPlacer();
	

	public void place(int[] xy,int index, int i) {
		
		if(positing == VERTICAL){
			vPlacer.placer(xy, index, i);
		}
	}
}
