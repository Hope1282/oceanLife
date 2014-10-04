package infppGUI;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class GUITest extends JFrame {

    private static final long serialVersionUID = 1L;

    GUITest(String title) {
        super(title);
        JLabel helloLabel = new JLabel("Hello");
        add(helloLabel);
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        GUITest gui = new GUITest("GUI 1");
        gui.setSize(500, 500);
        gui.setLocation(0, 0);
        gui.setVisible(true);
    }

}
