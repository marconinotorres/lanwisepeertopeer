package grafica;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;


/**
 * Classe che estende un JDialog dove verrà stampato il tipo di eccezione generato
 * nel caso in cui venga generata un'eccezione
 * 
 * @author giusepperestivo
 * 
 */
public class EccezioneDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	private JLabel label = new JLabel();
	private JButton ok = new JButton("Ok");

	public EccezioneDialog(Exception eccezione) {
		super();

		ok.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);

			}
		});
		setSize(300, 300);
		setLayout(new GridLayout(2, 1));
		label.setText(eccezione.getMessage());
		add(label);
		add(ok);
	}
}
