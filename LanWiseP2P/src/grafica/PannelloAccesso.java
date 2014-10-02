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

import modello.Utente;
import reti.CartelleUtente;
import reti.PeerAsServer;
import tests.Main;


public class PannelloAccesso extends JPanel {
	
	private static final long serialVersionUID = 0;
		
	private final Utente listaUtenti;
	private final ArrayList<JRadioButton> buttonUtenti=new ArrayList<>();
	
	public PannelloAccesso(final Utente listaUtenti){
		
		this.listaUtenti = listaUtenti;
		setLayout(new GridLayout(5,1));
		TitledBorder border =new TitledBorder("Lista_Utenti");
		border.setTitleColor(Color.blue);
		setBorder(border);
		ButtonGroup gruppo=new ButtonGroup();
		
		for (int i = 0; i < 5; i++) {
			
			buttonUtenti.add(new JRadioButton(listaUtenti.getListaUtenti().get(i)));
			gruppo.add(buttonUtenti.get(i));
			add(buttonUtenti.get(i));
			
			
//			System.err.println(utenti.get(i).getText());
		}
		
		for (int i = 0; i < buttonUtenti.size(); i++) {
			final String utenteB = listaUtenti.getListaUtenti().get(i);
			buttonUtenti.get(i).addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					listaUtenti.setUtenteSelezionato(utenteB);
					listaUtenti.controlloAccessi(utenteB);
					FrameCaricaCartella cartella = new FrameCaricaCartella();
					Main.getFrame().dispose();
					CartelleUtente utente = CartelleUtente.getInstance();
					PeerAsServer pas = new PeerAsServer();
					pas.start();

				}
			});
		}
	}
}
		