package infpp;


import infppGUI.OceanGUI;

import java.util.LinkedList;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

public class OceanTest implements ActionListener {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int width=20;
		int depth=6;
		LinkedList<OceanObject> oceanObjects;
		oceanObjects =new LinkedList<OceanObject>();
		oceanObjects.add(new Fish1(54, 19, "Nemofish"));
		oceanObjects.add(new Fish1(578,980,"Doriefish"));
		oceanObjects.add(new Stone(321,267,"Stone"));
		oceanObjects.add(new Plant(163,550,"Plant"));
		oceanObjects.add(new Bubble(245,470,"Bubble"));
		oceanObjects.add(new Fish1(8,0,"Ralph"));
		Ocean ocean = new Ocean(width, depth, oceanObjects);
		System.out.println(ocean);
		System.out.println(ocean.plot());
		//ocean.move();
		System.out.println(ocean);
		System.out.println(ocean.plot());
		infppGUI.OceanGUI gui = new infppGUI.OceanGUI("Ocean", ocean.plot());
		gui.setLocation (0,0);
		gui.pack();
		gui.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	//@Override
	//public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	//	if(e.getSource()==gui.getJButton(stepButton);
	//}

}
