package infpp;

import java.util.LinkedList;

public class OceanControl {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int width = 1000;
        int depth = 600;
        LinkedList<OceanObject> oceanObjects;
        oceanObjects = new LinkedList<OceanObject>();
        //oceanObjects.add(new Fish(54, 19, "Nemofish", "Fish"));
        //oceanObjects.add(new Fish(578, 980, "Doriefish", "Fish"));
        //oceanObjects.add(new Stone(321, 267, "Stone", "Stone"));
        //oceanObjects.add(new Plant(163, 550, "Plant", "Plant"));
        //oceanObjects.add(new Bubble(245, 470, "Bubble", "Bubble"));
        oceanObjects.add(new Fish(100, 100, "Ralph", "Fish"));
        Ocean ocean = new Ocean(width, depth, oceanObjects);
        Ocean.instance = ocean;
        /*System.out.println(ocean);
        System.out.println(ocean.plot());
        System.out.println(ocean);
        System.out.println(ocean.plot());*/
        infpp.OceanGUI gui = new infpp.OceanGUI("Ocean"/*, ocean.plot()*/);
        gui.setLocation(0, 0);
        //gui.pack();
        gui.setVisible(true);
    }
   
}
