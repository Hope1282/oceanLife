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
    
    private boolean moveOn;
    
    private Thread thread;
    
    private JLabel oceanTT;
    
   
    
    public OceanGUI(String title, String TOcean) {
    	super(title);
    	
    	 class GoOn implements Runnable {
         	
         	public void run(){
         		while(moveOn){
         			try{
         				Thread.sleep(100);
         				Ocean.getInstance().move();
         				oceanTT.setText(Ocean.getInstance().plot());
         			}catch(InterruptedException ex){	
         			}
         		}
         	}
         }
    	
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
				GoOn job = new GoOn();
				moveOn = true;
				thread = new Thread(job);
				thread.start();
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
				moveOn = false;
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
            	moveOn = false;
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
            public void mouseClicked(MouseEvent e) {
            	//if()
            }
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

        JComboBox<String> objectChooser = new JComboBox<String>();
        objectChooser.addItem(null);
        objectChooser.addItem("Fish");
        objectChooser.addItem("Plant");
        objectChooser.addItem("Stone");
        objectChooser.addItem("Bubble");

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
}
