package grafica;

import java.awt.BorderLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import reti.Client;
import reti.Server;

public class FileChooser extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	JButton openButton, saveButton, sendButton;
	JTextArea log;
	JFileChooser fc;
	File folderS;
	File folderD;

	public FileChooser() {
		super(new BorderLayout());

		log = new JTextArea(5,20);
		log.setMargin(new Insets(5,5,5,5));
		log.setEditable(false);
		JScrollPane logScrollPane = new JScrollPane(log);

		fc = new JFileChooser();
		fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		//fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

		openButton = new JButton("Scegli cartella origine");
		openButton.addActionListener(this);

		saveButton = new JButton("Scegli cartella destinazione");
		saveButton.addActionListener(this);

		sendButton = new JButton("Manda tutti i file a destinazione");
		sendButton.addActionListener(this);

		JPanel buttonPanel = new JPanel();
		buttonPanel.add(openButton);
		buttonPanel.add(saveButton);
		buttonPanel.add(sendButton);

		add(buttonPanel, BorderLayout.PAGE_START);
		add(logScrollPane, BorderLayout.CENTER);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == openButton) {

			int returnVal = fc.showOpenDialog(FileChooser.this);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				this.folderS = fc.getSelectedFile(); //scelgo la cartella di origine
				log.append("Source: " + folderS.getName() + ".\n");
			}
			log.setCaretPosition(log.getDocument().getLength());

		} else if (e.getSource() == saveButton) {

			int returnVal = fc.showSaveDialog(FileChooser.this);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				this.folderD = fc.getSelectedFile(); //scelgo la cartella di destinazione
				log.append("Destination: " + folderD.getName() + ".\n");
			}
			log.setCaretPosition(log.getDocument().getLength());

		} else if (e.getSource() == sendButton) {

			try {
				sendFilesForFolder(folderS, folderD); //mando i file
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			log.append("FATTO!");
			log.setCaretPosition(log.getDocument().getLength());
		}

	}

	public void sendFilesForFolder(final File folderS, final File folderD) throws Exception{
		for (final File fileEntry : folderS.listFiles()) {
			Server server = new Server();
			Client client = new Client();

			server.FILE_TO_SEND = fileEntry.getAbsolutePath();
			server.start();

			client.FILE_TO_RECEIVED = folderD.getAbsolutePath()+"/"+fileEntry.getName()+"-rcv";
			client.start();

			server.join(); //aspetto che i thread muoiano prima di avviarne 
			client.join(); //uno nuovo; problemi con le porte altrimenti;
		}
	}


	public static void main(String[] args) {
		JFrame frame = new JFrame("File transfer from one folder to another using sockets!");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.add(new FileChooser());

		frame.pack();
		frame.setVisible(true);
	}

}