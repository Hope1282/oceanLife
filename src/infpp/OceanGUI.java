package infpp;

import infpp.*;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.io.*;
import java.util.LinkedList;

public class OceanGUI extends JFrame {
	
	/**Initiiere eine Vielzahl von Objekten, einige mit Hilfe von swing oder awt.*/
	

    private static final long serialVersionUID = 1L;
    
    
    public static OceanGUI instance;
    
    private JButton loadButton = new JButton("Laden");
    private JButton startButton = new JButton("Start");
    private JButton saveButton = new JButton("Speichern");
    private JButton stopButton = new JButton("Stop");
    private JButton quitButton = new JButton("Quit");
    private JButton addButton = new JButton("Einfuegen");
    private JButton delButton = new JButton("Entfernen");
    private JButton stepButton = new JButton("Step");
    
    LinkedList<OceanObject> oceanLoad;
    LinkedList<OceanObject> oceanSave;
    
    private static JComboBox<String> objectChooser;
    private static JComboBox<String> deleteList;
    
    private JSpinner heightSpinner;
    private JSpinner widthSpinner;
    
    private boolean moveOn;
    
    private Thread thread;
    
    private BufferedImage pic0;
    private BufferedImage pic1;
    private BufferedImage pic2;
    private BufferedImage pic3;
    private BufferedImage pic4;
    
    private static ImageIcon icon0;
    private static ImageIcon icon1;
    private static ImageIcon icon2;
    private static ImageIcon icon3;
    private static ImageIcon icon4;
    
    private static JPanel oceanP;
    public static JLabel[] pics;
    
    public static JPanel getOceanP(){
		return oceanP;
	}
    
    /**Build ist quasi der Kern der GUI. Die Methode erstellt fuer jedes OceanObject ein neues Label in einem Label-Array
     * Es fuegt dieses danach den oceanP Panel hinzu und passt ihre Groesse an.
     * Ausserdem laed sie das Hntergrundbild fuer die GUI.
     */
    public static void build(){
    	pics = new JLabel[Ocean.getInstance().getOceanObjects().size()+1];
        for(int i =0; i<Ocean.getInstance().getOceanObjects().size();i++){
        	if(Ocean.getInstance().getOceanObjects().get(i).getObject().equals("Fish")){
        		pics[i]  = new JLabel(icon1);
        		oceanP.add(pics[i]);
        		pics[i].setBounds(Ocean.getInstance().getOceanObjects().get(i).getPosition()[0], Ocean.getInstance().getOceanObjects().get(i).getPosition()[1]+100, 50, 50);
        	} else if(Ocean.getInstance().getOceanObjects().get(i).getObject().equals("Stone")){
        		pics[i]  = new JLabel(icon2);
        		oceanP.add(pics[i]);
        		pics[i].setBounds(Ocean.getInstance().getOceanObjects().get(i).getPosition()[0], Ocean.getInstance().getOceanObjects().get(i).getPosition()[1]+100, 50, 50);
        	} else if(Ocean.getInstance().getOceanObjects().get(i).getObject().equals("Plant")){
        		pics[i]  = new JLabel(icon3);
        		oceanP.add(pics[i]);
        		pics[i].setBounds(Ocean.getInstance().getOceanObjects().get(i).getPosition()[0], Ocean.getInstance().getOceanObjects().get(i).getPosition()[1]+100, 50, 50);
        	} else if(Ocean.getInstance().getOceanObjects().get(i).getObject().equals("Bubble")){
    			pics[i]  = new JLabel(icon4);
    			oceanP.add(pics[i]);
    			pics[i].setBounds(Ocean.getInstance().getOceanObjects().get(i).getPosition()[0], Ocean.getInstance().getOceanObjects().get(i).getPosition()[1]+100, 50, 50);
        	}
        }
        pics[Ocean.getInstance().getOceanObjects().size()] = new JLabel(icon0);
        oceanP.add(pics[Ocean.getInstance().getOceanObjects().size()]);
        pics[Ocean.getInstance().getOceanObjects().size()].setBounds(0, 100, Ocean.getInstance().getWidth(), Ocean.getInstance().getDepth());
    }
    
    public static JComboBox<String> getTypeBox(){
    	return objectChooser;
    }
    public static JComboBox<String> getDeleteBox(){
    	return deleteList;
    } 
    
    /**Diese Methode ermoeglicht das Aendern der groesse eines BufferedImage.
     * 
     * @param image
     * @param width
     * @param height
     */
    public static BufferedImage resize(BufferedImage image, int width, int height) {
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TRANSLUCENT);
        Graphics2D g2d = (Graphics2D) bi.createGraphics();
        g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
        g2d.drawImage(image, 0, 0, width, height, null);
        g2d.dispose();
        return bi;
    }
    
    
    /**Der Konstruktor der GUI enthaelt vor allem die add methoden fuer die bereits initiierten Objekte.
     * Ausserdem finden sich hier die Button-Listener in fprm von Anonymen Klassen.
     * @param title
     */
    public OceanGUI(String title) {
    	super(title);
    	
    	this.setSize(Ocean.getInstance().getWidth(), Ocean.getInstance().getDepth()+100);
    	
    	objectChooser = new JComboBox<String>();
    	deleteList = new JComboBox<String>();
    	
    	SpinnerNumberModel fishSpinner = new SpinnerNumberModel(0, 0, Ocean.getInstance().getDepth()-51, 50);
        heightSpinner = new JSpinner(fishSpinner);

        SpinnerNumberModel fishSpinner2 = new SpinnerNumberModel(0, 0, Ocean.getInstance().getWidth()-51, 50);
        widthSpinner = new JSpinner(fishSpinner2);

        
        /**Nebenlaeufiger Thread, der die move-Methode wiederholt ausfuehrt*/
    	 class GoOn implements Runnable {
         	
         	public void run(){
         		while(moveOn){
         			try{
         				Thread.sleep(100);
         				Ocean.getInstance().move();
         			}catch(InterruptedException ex){	
         			}
         		}
         	}
         }
    	
    	 /**Lade verschiedene Bilddateien*/
    	 try {
 			pic0 = ImageIO.read(new File("src/3.jpg"));
 		} catch (IOException e1) {
 			System.err.println("err");
 		}
        try {
			pic1 = ImageIO.read(new File("src/fish0.png"));
		} catch (IOException e1) {
			System.err.println("err");
		}
        try {
			pic2 = ImageIO.read(new File("src/Quarried_stone.png"));
		} catch (IOException e1) {
			System.err.println("err");
		}
        try {
			pic3 = ImageIO.read(new File("src/seaweed.png"));
		} catch (IOException e1) {
			System.err.println("err");
		}
        try {
			pic4 = ImageIO.read(new File("src/bubble.png"));
		} catch (IOException e1) {
			System.err.println("err");
		}
        
        /**Passe die groesse dieser Biddateien an*/
        pic0 = resize(pic0,Ocean.getInstance().getWidth(),Ocean.getInstance().getDepth());
        pic1 = resize(pic1, 50, 50);
        pic2 = resize(pic2,50,50);
        pic3 = resize(pic3,50,50);
        pic4 = resize(pic4,50,50);
        
        /**Erstelle aus den eingelesenen Bilddateien Icons*/
        icon0 = new ImageIcon(pic0);
        icon1 = new ImageIcon(pic1);
        icon2 = new ImageIcon(pic2);
        icon3 = new ImageIcon(pic3);
        icon4 = new ImageIcon(pic4);
        
        JPanel menu = new JPanel();
        
        /**Listener sind automatisch generiert, nur die on-Click Listener wurden verwendet*/
        
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
			/**Lade vorher gespeicherte datei mit angegebenem Dateinamen aus src-Ordner
			 * und aktualisiere die GUI.*/
			public void mouseClicked(MouseEvent arg0) {
				String fileName = JOptionPane.showInputDialog("Enter file name");
				if(fileName != null){
					try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName+".ser"))){
						infpp.Ocean.getInstance().getOceanObjects().clear();
						oceanLoad = (LinkedList<OceanObject>) in.readObject();
						Ocean.getInstance().setOceanObjects(oceanLoad);
						deleteList. removeAllItems();
						for(int i=0; i<oceanLoad.size();i++){
							deleteList.addItem(oceanLoad.get(i).getName());
						}
						infpp.OceanGUI.getOceanP().removeAll();
						infpp.OceanGUI.build();
						in.close();
					} catch (IOException i){
						System.err.println("OI Error");
						//JOptionPane.showMessageDialog(null,"Data not found.")
					} catch(ClassNotFoundException c){
						System.err.println("Class Error");
					}
				}
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
			/**Startet die GoOn Methode*/
			public void mouseClicked(MouseEvent arg0) {
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
			/**Speicher den derzeitigen Programmzutand unter einem gewaehlten Namen*/
			public void mouseClicked(MouseEvent arg0) {
			    oceanSave = infpp.Ocean.getInstance().getOceanObjects();
				String fileName = JOptionPane.showInputDialog("Enter file name");
			    try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName+".ser"))){
			    	out.writeObject(oceanSave);
			    	out.close();
			    } catch (IOException i){
			    	System.err.println("Invalide");
			    }
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
			/**Unterbricht die GoOn-Methoden, falls sie durch den Start-Button initialisiert wurde*/
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
            /**Beendet das programm*/
            public void mouseClicked(MouseEvent e) {
            	moveOn = false;
                OceanGUI.this.dispose();
            }
        });
        addButton.addMouseListener(new MouseListener() {

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            /**Erstellt Objekte der gewaehlten Klasse am gewaehlten Punkt mit einem gewaehlten Namen.
             * Aktualisiert danach die GUI*/
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
	            			infpp.Ocean.getInstance().getOceanObjects().add(new Fish(x,y,objectName,"Fish"));
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
	            			deleteList.addItem(objectName);
	            			stop = true;
	            		}
	            	}
	            infpp.OceanGUI.getOceanP().removeAll();
	        	infpp.OceanGUI.build();
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
			/**Loescht ein gewaehltes Objekt sowohl aus der OceanObjects-LinkedList als auch aus der Delete-Box.
			 * Aktualisiert danach die GUI.*/
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method
				for(int i=0;i<Ocean.getInstance().getOceanObjects().size();i++){
					if(Ocean.getInstance().getOceanObjects().get(i).getName() == deleteList.getSelectedItem()){
						Ocean.getInstance().getOceanObjects().remove(i);
					}
				}
				deleteList.removeItem(deleteList.getSelectedItem());
				infpp.OceanGUI.getOceanP().removeAll();
				infpp.OceanGUI.build();
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
			/**Fuehrt die move-Methode von Ocean ein Mal aus*/
			public void mouseClicked(MouseEvent ar) {
				// TODO Auto-generated method stub
				infpp.Ocean.getInstance().move();
			}
		});
        
        JLabel xLabel = new JLabel("X-Koordinate");
        JLabel yLabel = new JLabel("Y-Koordinate");

        objectChooser.addItem("Fish");
        objectChooser.addItem("Plant");
        objectChooser.addItem("Stone");
        objectChooser.addItem("Bubble");
        
       /**Fuege Button dem Menu-Panel hinzu*/ 
        menu.add(loadButton);
        menu.add(startButton);
        menu.add(xLabel);
        menu.add(widthSpinner);
        menu.add(objectChooser);
        menu.add(deleteList);
        menu.add(quitButton);
        menu.add(saveButton);
        menu.add(stopButton);
        menu.add(yLabel);
        menu.add(heightSpinner);
        menu.add(addButton);
        menu.add(delButton);
        menu.add(stepButton);
        menu.setLayout(new GridLayout(2, 7));
        menu.setBounds(0,0,Ocean.getInstance().getWidth(),100);
        
        
        oceanP = new JPanel();
        
        build();
       
        /**Setzt die Parameter fuer das oceanP-Panel*/
        oceanP.setLayout(null);
        oceanP.setBounds(0,100,Ocean.getInstance().getWidth(), Ocean.getInstance().getDepth());
        
        
        add(menu);
        add(oceanP);
        
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
