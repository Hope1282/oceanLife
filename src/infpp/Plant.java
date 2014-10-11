package infpp;


public class Plant extends OceanObject {
	
	/**Erbt Konstuktoren von OceanObject*/
	public Plant() {
	}

	public Plant(int[] position, String name, String object) {
		super(position, name, object);
	}

	public Plant(int x, int y, String name, String object) {
		super(x, y, name, object);
	}
	
	/**Die move-Methode von Plant ist leer,
	 *  sie soll sich bei laufendem programm nicht bewegen*/
	public void move() {
	}

}
