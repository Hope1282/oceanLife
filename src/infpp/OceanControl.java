package infpp;

import java.util.LinkedList;

public class OceanControl {

/**Main setzt width und depth von Ocean fest, und initiiert die LinkedList,
 * in der sich die OceanObject-Objekte befinden.
 * Sie initiiert den Ocean mit diesen Parametern und aktiviert die OceanGUI.
 * @param args
 */
    public static void main(String[] args) {
        int width = 1000;
        int depth = 600;
        LinkedList<OceanObject> oceanObjects;
        oceanObjects = new LinkedList<OceanObject>();
        Ocean ocean = new Ocean(width, depth, oceanObjects);
        Ocean.instance = ocean;
        OceanGUI gui = new OceanGUI("Ocean");
        gui.setLocation(0, 0);
        gui.setVisible(true);
    }
   
}
