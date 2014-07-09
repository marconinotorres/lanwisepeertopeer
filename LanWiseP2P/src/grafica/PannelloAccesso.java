package grafica;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;

import modello.IUtenti;
import modello.readUtenti.TestReadUtenti;
import reti.PeerAsServer;
import reti.Utente;
import tests.Main;


public class PannelloAccesso extends JPanel {
	
	private static final long serialVersionUID = 0;
	
	
	public PannelloAccesso(){
		
		List<modello.Utente> listaUtenti =  (new TestReadUtenti().getUtenti());
		
		final ArrayList<JRadioButton> utenti=new ArrayList<>();
		
		setLayout(new GridLayout(5,1));
		TitledBorder border =new TitledBorder("Lista_Utenti");
		border.setTitleColor(Color.blue);
		setBorder(border);
		ButtonGroup gruppo=new ButtonGroup();
		
		for (int i = 0; i < listaUtenti.size(); i++) {
			
			utenti.add(new JRadioButton(listaUtenti.get(i).getNomeUtente()));
			gruppo.add(utenti.get(i));
			add(utenti.get(i));
		}
		
		for (int i = 0; i < utenti.size(); i++) {
			utenti.get(i).addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					//TODO - qualcosa che mi dice se l'utente selezionato  giˆ entrato
					
					new FrameCaricaCartella();
					Main.getFrame().dispose();
					
					Utente utente = Utente.getInstance();
					PeerAsServer pas = new PeerAsServer();
					pas.start();

				}
			});
		}
	}
}
		