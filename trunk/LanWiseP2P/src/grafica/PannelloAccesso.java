package grafica;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;

import rete.ListaUtentiRete;
import modello.ListaUtenti;
import modello.dataio.StringLinesReader;
import modello.dataio.StringLinesWriter;
import modello.letturaListaUtenti.TestWriteChangeConnessione;
import application.Main;

/**
 * Pannello che permette di identificare l'utente che si vuole connettere
 * 
 * @author giusepperestivo
 * 
 */
public class PannelloAccesso extends JPanel {

	private static final long serialVersionUID = 0;

	private final ArrayList<JRadioButton> buttonUtenti = new ArrayList<JRadioButton>();
	private ListaUtentiRete rete = new ListaUtentiRete();
	
	public PannelloAccesso() {
		rete.start();
		setLayout(new GridLayout(5, 1));
		TitledBorder border = new TitledBorder("Lista_Utenti");
		border.setTitleColor(Color.blue);
		setBorder(border);
		ButtonGroup gruppo = new ButtonGroup();

		for (int i = 0; i < ListaUtenti.getUtenti().getListaUtentiDaVisualizzare()
				.size(); i++) {
			String nome = ListaUtenti.getUtenti().getListaUtentiDaVisualizzare()
					.get(i).getNome();
			String cognome = ListaUtenti.getUtenti().getListaUtentiDaVisualizzare()
					.get(i).getCognome();
			buttonUtenti.add(new JRadioButton(nome + "  " + cognome));
			gruppo.add(buttonUtenti.get(i));
			add(buttonUtenti.get(i));

		}


		for (int i = 0; i < buttonUtenti.size(); i++) {
			
			final int index = i;
			buttonUtenti.get(i).addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					
					ListaUtenti.getUtenti().setUtenteSelected(index);
					ListaUtenti.getUtenti().getUtenteSelected().setConnesso(true);
				
					(new StringLinesWriter(new TestWriteChangeConnessione())).write("data/listaUtenti.txt");
					
					new FrameCartellaCondivisione();
					Main.getFrame().dispose();

				}
			});
		}
	}
}
