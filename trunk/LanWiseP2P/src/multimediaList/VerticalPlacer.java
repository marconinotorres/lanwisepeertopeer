package multimediaList;

public class VerticalPlacer {
	
	
	public void placer(int[] xy,int index, int i){
		xy[0] = 100;
		xy[1]= 100 + 20 *(i-index);
	}

}
