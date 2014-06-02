package modello;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;


public class PannelloAccesso extends JPanel {
	private static final long serialVersionUID = 0;
		
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
		System.err.println("ciao");
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
					
					PannelloCondivisione pannelloCondiv=new PannelloCondivisione();
					
				}
			});
		}
	
		
//		JRadioButton utente1=new JRadioButton("Utente1");
//		JRadioButton utente2=new JRadioButton("Utente2");
//		JRadioButton utente3=new JRadioButton("Utente3");
//		JRadioButton utente4=new JRadioButton("Utente4");
//		JRadioButton utente5=new JRadioButton("Utente5");
//		ButtonGroup gruppo=new ButtonGroup();
//		gruppo.add(utente1);
//		gruppo.add(utente2);
//		gruppo.add(utente3);
//		gruppo.add(utente4);
//		gruppo.add(utente5);
//		add(utente1);
//		add(utente2);
//		add(utente3);
//		add(utente4);
//		add(utente5);
//		utente1.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				JFrame frame=new JFrame("LWP2P");
//				Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//				frame.setBounds((int) screenSize.getWidth() >> 2,
//						(int) screenSize.getHeight() >> 3,
//						(int) screenSize.getWidth() >> 2,
//						(int) screenSize.getHeight() >> 2 );
//				frame.setVisible(true);
//			}
//		});
		
	}
}
		