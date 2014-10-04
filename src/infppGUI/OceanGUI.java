package infppGUI;

import infpp.Bubble;
import infpp.Fish1;
import infpp.OceanObject;
import infpp.Plant;
import infpp.Stone;

import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class OceanGUI extends JFrame {

    private static final long serialVersionUID = 1L;

    public OceanGUI(String title, String TOcean) {
        super(title);
        ImageIcon pic = new ImageIcon("C:\\Users\\Jannes Dittmann\\Desktop\\3.jpg");
        JPanel menu = new JPanel();
        JButton loadButton = new JButton("Laden");
        JButton startButton = new JButton("Start");
        JButton saveButton = new JButton("Speichern");
        JButton stopButton = new JButton("Stop");
        JButton quitButton = new JButton("Quit");
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
        JButton pasteButton = new JButton("Einfuegen");
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
        JButton delButton = new JButton("Entfernen");
        JButton stepButton = new JButton("Step");
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
        JLabel oceanTT = new JLabel(TOcean);
        oceanT.add(oceanTT);
        JPanel oceanP = new JPanel();
        JLabel oceanPP = new JLabel(pic);
        oceanP.add(oceanPP);
        add(menu);
        add(oceanP);
        add(oceanT);
        setLayout(new GridLayout(2, 2));
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        OceanGUI gui = new OceanGUI("Ocean", "blub");
        gui.setLocation(0, 0);
        gui.pack();
        gui.setVisible(true);
    }
}
