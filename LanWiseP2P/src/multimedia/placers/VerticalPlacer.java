package multimedia.placers;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import modello.FileHandler;
import modello.FormattazioneFileHandler;
import modello.Utente;
import multimedia.IMultimediaContents;
import multimedia.IPlacer;

/**
 * @author Giuseppe Restivo
 */

public class VerticalPlacer implements IPlacer {

	private static int iconCenterX = 50;
	private static int iconCenterY = 200;

	private static int DISTANZA_CONTENUTI = 75;

	public void place(Graphics graphics, int slot, int index,
			IMultimediaContents contents) {

		Graphics2D graphics2d = (Graphics2D) graphics;

		String nomeFile = contents.getContentsList().get(index).getNomeFile();
		int dimension = contents.getContentsList().get(index).getDimension();
		Utente utente = contents.getContentsList().get(index).getUtente();
		String icona = contents.getContentsList().get(index).getIcona();

		FormattazioneFileHandler formato = new FormattazioneFileHandler();

		try {
			BufferedImage image = ImageIO.read(new File(icona));
			int halfWidth = (image.getWidth()) >> 1;
			int halfHeight = image.getHeight() >> 1;

			graphics2d.drawImage(image, iconCenterX - halfWidth,
					(iconCenterY - halfHeight) + slot * DISTANZA_CONTENUTI,
					null, null);

			String name = formato.setNCaratteri(nomeFile);
			String dim = formato.numeroDecimali(dimension);

			graphics2d.drawString(name, iconCenterX + 100, iconCenterY + slot
					* DISTANZA_CONTENUTI);
			graphics2d.drawString(dim, iconCenterX + 500, iconCenterY + slot
					* DISTANZA_CONTENUTI);
			graphics2d.drawString(utente.getCognome(), iconCenterX + 650,
					iconCenterY + slot * DISTANZA_CONTENUTI);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
