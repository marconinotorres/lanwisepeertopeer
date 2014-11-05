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

import modello.Utente;
import modello.letturaListaUtenti.TestReadUtenti;
import modello.letturaListaUtenti.UtenteReader;
import modello.writeUtenti.UtenteWriter;
import reti.CartelleUtente;
import reti.PeerAsServer;
import tests.Main;


public class PannelloAccesso extends JPanel {
	
	private static final long serialVersionUID = 0;
	
	private final ArrayList<JRadioButton> buttonUtenti=new ArrayList<>();
	
	public PannelloAccesso(){
		
		setLayout(new GridLayout(5,1));
		TitledBorder border =new TitledBorder("Lista_Utenti");
		border.setTitleColor(Color.blue);
		setBorder(border);
		ButtonGroup gruppo=new ButtonGroup();
		
		for (int i = 0; i < UtenteReader.getUtente().readFileUtente().size(); i++) {
			String nome = UtenteReader.getUtente().readFileUtente().get(i).getNome();
			String cognome = UtenteReader.getUtente().readFileUtente().get(i).getCognome();
			buttonUtenti.add(new JRadioButton(nome+"  "+cognome));
			gruppo.add(buttonUtenti.get(i));
			add(buttonUtenti.get(i));
			
			
		}
		List<Utente> lista = UtenteReader.getUtente().readFileUtente();
		
		for (int i = 0; i < buttonUtenti.size(); i++) {
			final String utenteCollegato = lista.get(i).getCognome();
			final String nomeUtColl = lista.get(i).getNome();
			buttonUtenti.get(i).addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					
					UtenteWriter.getUtente().setUtenteCollegato(new Utente(nomeUtColl, utenteCollegato));
					UtenteWriter.getUtente().writeConnessione(utenteCollegato,"S");
					
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
		