package infppGUI;
import java.awt.GridLayout;

import javax.swing.*;

public class OceanGUI extends JFrame {
	public OceanGUI(String title, String TOcean){
		super(title);
		ImageIcon pic = new ImageIcon("C:\\Users\\Jannes Dittmann\\Desktop\\3.jpg");
		JPanel menu = new JPanel();
		JButton loadButton = new JButton("Laden");
		JButton startButton = new JButton("Start");
		JButton saveButton = new JButton("Speichern");
		JButton stopButton = new JButton("Stop");
		JButton quitButton = new JButton("Quit");
		JButton pasteButton = new JButton("Einfuegen");
		JButton delButton = new JButton("Entfernen");
		JButton stepButton = new JButton("Step");
		JLabel xLabel = new JLabel("X-Koordinate");
		JLabel yLabel = new JLabel("Y-Koordinate");
		JComboBox objectChooser = new JComboBox();
		objectChooser.addItem("");
		objectChooser.addItem("Fish");
		objectChooser.addItem("Plant");
		objectChooser.addItem("Stone");
		objectChooser.addItem("Bubble");
		JComboBox objectChooser2 = new JComboBox();
		objectChooser.addItem("");
		SpinnerNumberModel fishSpinner = new SpinnerNumberModel(20,0,1000,50);
		JSpinner heightSpinner = new JSpinner(fishSpinner);
		SpinnerNumberModel fishSpinner2 = new SpinnerNumberModel(20,0,1000,50);
		JSpinner widthSpinner = new JSpinner(fishSpinner2);
		menu.add(loadButton);
		menu.add(startButton);
		menu.add(xLabel);
		menu.add(widthSpinner);
		menu.add(objectChooser);
		menu.add(objectChooser2);
		menu.add(quitButton);
		menu.add(saveButton);
		menu.add(stopButton);
		menu.add(yLabel);
		menu.add(heightSpinner);
		menu.add(pasteButton);
		menu.add(delButton);
		menu.add(stepButton);
		menu.setLayout(new GridLayout(2,7));
		JPanel oceanT = new JPanel();
		JLabel oceanTT = new JLabel (TOcean);
		oceanT.add(oceanTT);
		JPanel oceanP = new JPanel();
		JLabel oceanPP =new JLabel(pic);
		oceanP.add(oceanPP);
		add(menu);
		add(oceanP);
		add(oceanT);
		setLayout(new GridLayout(2,2));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OceanGUI gui = new OceanGUI("Ocean", "blub");
		gui.setLocation (0,0);
		gui.pack();
		gui.setVisible(true);
	}
}
