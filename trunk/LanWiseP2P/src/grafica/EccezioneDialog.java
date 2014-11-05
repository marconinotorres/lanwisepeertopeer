package grafica;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

import modello.GestioneEccezioni;

/**
 * Se si genera una eccezione si pu˜ usare questa classe che estende un JDialog
 * dove viene stampato il tipo di eccezione generato
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
