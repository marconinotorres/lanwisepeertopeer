package modello;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;

import ordinamento.ProxyOrdinamento;
import reti.PeerAsServer;
import reti.Utente;
import tests.Main;


public class PannelloAccesso extends JPanel {
	private static final long serialVersionUID = 0;
		
	private ProxyOrdinamento proxy = new ProxyOrdinamento(null);
	
	
	public PannelloAccesso(){
		
		final ArrayList<JRadioButton> utenti=new ArrayList<>();
		ArrayList<String> nomeUtente=new ArrayList<>();
		nomeUtente.add("Giuseppe Restivo");
		nomeUtente.add("Nicola Blago");
		nomeUtente.add("Federico Bacci");
		nomeUtente.add("Stefano Azzolina");
		nomeUtente.add("Marco Cortesi");
		setLayout(new GridLayout(5,1));
		TitledBorder border =new TitledBorder("Lista_Utenti");
		border.setTitleColor(Color.blue);
		setBorder(border);
		ButtonGroup gruppo=new ButtonGroup();
		
		for (int i = 0; i < 5; i++) {
			
			utenti.add(new JRadioButton(nomeUtente.get(i)));
			gruppo.add(utenti.get(i));
			add(utenti.get(i));
			
//			System.err.println(utenti.get(i).getText());
		}
		
		for (int i = 0; i < utenti.size(); i++) {
			utenti.get(i).addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					FrameCondivisione frameCond=new FrameCondivisione(proxy);
					Main.getFrame().dispose();
					Utente utente = Utente.getInstance();
					PeerAsServer pas = new PeerAsServer();
					pas.start();
				}
			});
		}
	}
}
		