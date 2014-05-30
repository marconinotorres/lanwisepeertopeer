package grafica;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;


public class Pannello extends JPanel {
	private static final long serialVersionUID = 0;
		
	public Pannello(){
		setLayout(new GridLayout(5,1));
		TitledBorder border =new TitledBorder("Lista_Utenti");
		border.setTitleColor(Color.blue);
		setBorder(border);
		
		JRadioButton utente1=new JRadioButton("Utente1");
		JRadioButton utente2=new JRadioButton("Utente2");
		JRadioButton utente3=new JRadioButton("Utente3");
		JRadioButton utente4=new JRadioButton("Utente4");
		JRadioButton utente5=new JRadioButton("Utente5");
		ButtonGroup gruppo=new ButtonGroup();
		gruppo.add(utente1);
		gruppo.add(utente2);
		gruppo.add(utente3);
		gruppo.add(utente4);
		gruppo.add(utente5);
		add(utente1);
		add(utente2);
		add(utente3);
		add(utente4);
		add(utente5);
		utente1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
//				JFrame frame=new JFrame("LWP2P");
//				Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//				frame.setBounds((int) screenSize.getWidth() >> 2,
//						(int) screenSize.getHeight() >> 3,
//						(int) screenSize.getWidth() >> 2,
//						(int) screenSize.getHeight() >> 2 );
//				frame.setVisible(true);		
				FileChooser.main(null);
			}
		});
		
	}
}
		