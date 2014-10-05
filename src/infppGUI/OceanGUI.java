package infppGUI;

import infpp.*;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class OceanGUI extends JFrame {

    private static final long serialVersionUID = 1L;
    private JButton loadButton = new JButton("Laden");
    private JButton startButton = new JButton("Start");
    private JButton saveButton = new JButton("Speichern");
    private JButton stopButton = new JButton("Stop");
    private JButton quitButton = new JButton("Quit");
    private JButton pasteButton = new JButton("Einfuegen");
    private JButton delButton = new JButton("Entfernen");
    private JButton stepButton = new JButton("Step");
    
    private JLabel oceanTT;
    
    public OceanGUI(String title, String TOcean) {
    	super(title);
        ImageIcon pic = new ImageIcon("src/3.jpg");
        JPanel menu = new JPanel();
        loadButton.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
        startButton.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
        saveButton.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
        stopButton.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
        quitButton.addMouseListener(new MouseListener() {

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub
                OceanGUI.this.dispose();
            }
        });
        pasteButton.addMouseListener(new MouseListener() {

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseClicked(MouseEvent e) {}
        });
        delButton.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
        stepButton.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent ar) {
				// TODO Auto-generated method stub
				infpp.Ocean.getInstance().move();
				oceanTT.setText(Ocean.getInstance().plot());
			}
		});
        JLabel xLabel = new JLabel("X-Koordinate");
        JLabel yLabel = new JLabel("Y-Koordinate");

        JComboBox<OceanObject> objectChooser = new JComboBox<OceanObject>();
        objectChooser.addItem(null);
        objectChooser.addItem(new Fish1(0, 0, "Fish"));
        objectChooser.addItem(new Plant(0, 0, "Plant"));
        objectChooser.addItem(new Stone(0, 0, "Stone"));
        objectChooser.addItem(new Bubble(0, 0, "Bubble"));

        JComboBox<OceanObject> objectChooser2 = new JComboBox<OceanObject>();
        objectChooser.addItem(null);

        SpinnerNumberModel fishSpinner = new SpinnerNumberModel(20, 0, 1000, 50);
        JSpinner heightSpinner = new JSpinner(fishSpinner);

        SpinnerNumberModel fishSpinner2 = new SpinnerNumberModel(20, 0, 1000, 50);
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
        menu.setLayout(new GridLayout(2, 7));
        JPanel oceanT = new JPanel();
        oceanTT = new JLabel(TOcean);
        oceanT.add(oceanTT);
        JPanel oceanP = new JPanel();
        JLabel oceanPP = new JLabel(pic);
        oceanP.add(oceanPP);
        add(menu);
        add(oceanP);
        add(oceanT);
        setLayout(new GridLayout(2, 2));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        OceanGUI gui = new OceanGUI("Ocean", "blub");
        gui.setLocation(0, 0);
        gui.pack();
        gui.setVisible(true);
    }
}
