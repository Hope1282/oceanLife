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
    
    private static JComboBox<String> objectChooser;
    private static JComboBox<String> objectChooser2;
    
    private JSpinner heightSpinner;
    private JSpinner widthSpinner;
    
    private boolean moveOn;
    
    private Thread thread;
    
    private JLabel oceanTT;
    
    public static JComboBox<String> getTypeBox(){
    	return objectChooser;
    }
    public static JComboBox<String> getDeleteBox(){
    	return objectChooser2;
    } 
    
    public OceanGUI(String title, String TOcean) {
    	super(title);
    	
    	objectChooser = new JComboBox<String>();
    	objectChooser2 = new JComboBox<String>();
    	
    	SpinnerNumberModel fishSpinner = new SpinnerNumberModel(5, 0, 1000, 5);
        heightSpinner = new JSpinner(fishSpinner);

        SpinnerNumberModel fishSpinner2 = new SpinnerNumberModel(5, 0, 1000, 1);
        widthSpinner = new JSpinner(fishSpinner2);

        
        
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
            	boolean stop = false;
            	boolean valName = false;
            	String objectName = "";
            	String dialog = "Insert name";
	            while(!stop){
	            	if(!valName){
	            		objectName = JOptionPane.showInputDialog(dialog);
	            		if(objectName == null){
	            			stop = true;
	            		} else {
	            			valName = true;
	            			for(int i=0;i<Ocean.getInstance().getOceanObjects().size();i++){
	            				if(objectName.equals(Ocean.getInstance().getOceanObjects().get(i).getName())){
	            					valName = false;
	            					dialog = "Insert valid name";
	            				}
	            			}
	            		}
	            	} else  {
	            		int x = (Integer)widthSpinner.getValue();
	            		int y = (Integer)heightSpinner.getValue();
	            		if(objectChooser.getSelectedItem()==objectChooser.getItemAt(0)){
	            			infpp.Ocean.getInstance().getOceanObjects().add(new Fish1(x,y,objectName,"Fish"));
	            		}
	            		if(objectChooser.getSelectedItem()==objectChooser.getItemAt(1)){
	            			infpp.Ocean.getInstance().getOceanObjects().add(new Plant(x,y,objectName,"Plant"));
	            		}
	            		if(objectChooser.getSelectedItem()==objectChooser.getItemAt(2)){
	            			infpp.Ocean.getInstance().getOceanObjects().add(new Stone(x,y,objectName,"Stone"));
	            		}
	            		if(objectChooser.getSelectedItem()==objectChooser.getItemAt(3)){
	            			infpp.Ocean.getInstance().getOceanObjects().add(new Bubble(x,y,objectName,"Bubble"));
	            		}
	            		objectChooser2.addItem(objectName);
	            		stop = true;
	            	}
	            	oceanTT.setText(Ocean.getInstance().plot());
	            }
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
				// TODO Auto-generated method
				for(int i=0;i<Ocean.getInstance().getOceanObjects().size();i++){
					if(Ocean.getInstance().getOceanObjects().get(i).getName() == objectChooser2.getSelectedItem()){
						Ocean.getInstance().getOceanObjects().remove(i);
					}
				}
				objectChooser2.removeItem(objectChooser2.getSelectedItem());
				oceanTT.setText(Ocean.getInstance().plot());
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

        objectChooser.addItem("Fish");
        objectChooser.addItem("Plant");
        objectChooser.addItem("Stone");
        objectChooser.addItem("Bubble");

        objectChooser2.addItem("Ralph");

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
