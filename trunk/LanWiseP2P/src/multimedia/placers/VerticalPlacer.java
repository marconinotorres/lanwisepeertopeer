package multimedia.placers;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import modello.FileHandler;
import modello.FormattazioneFileHandler;
import multimedia.IMultimediaContents;
import multimedia.IPlacer;

/**
 * @author Giuseppe Restivo
 */

public class VerticalPlacer implements IPlacer{

	
	private static int iconCenterX = 50;
	private static int iconCenterY = 200;
	private static int DISTANZA_CONTENUTI_VERTICALE=50;
	
	
	public void place(Graphics graphics, int slot,int index, IMultimediaContents contents) {
		
		Graphics2D graphics2d = (Graphics2D)graphics;
		FileHandler contenuto = new FileHandler();
		FormattazioneFileHandler formato = new FormattazioneFileHandler(30);
		try {
			
			contenuto = contents.getContentsList().get(index);
			BufferedImage image = ImageIO.read(new File(contents.getContentsList().get(index).getIcona()));
			
			int halfWidth= (image.getWidth())>>1;
			int halfHeight=image.getHeight()>>1;
			
			graphics2d.drawImage(image,iconCenterX-halfWidth,(iconCenterY-halfHeight)+slot*DISTANZA_CONTENUTI_VERTICALE, null,null);
			
			String name = formato.setNCaratteri(contenuto.getNomeFile());
			String dim = formato.numeroDecimali(contenuto.getDimension());
			
			graphics2d.drawString(name,iconCenterX+200,iconCenterY+slot*DISTANZA_CONTENUTI_VERTICALE);
			graphics2d.drawString(dim,iconCenterX+500,iconCenterY+slot*DISTANZA_CONTENUTI_VERTICALE);
			graphics2d.drawString(contenuto.getUtente().getCognome(),iconCenterX+650,iconCenterY+slot*DISTANZA_CONTENUTI_VERTICALE);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
