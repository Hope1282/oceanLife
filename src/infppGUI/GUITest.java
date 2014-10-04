package infppGUI;
import javax.swing.*;

public class GUITest extends JFrame{
	GUITest(String title){
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
		gui.setLocation (0,0);
		gui.setVisible(true);
	}

}
