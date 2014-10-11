package infpp;


public class Bubble extends OceanObject {
	
	/**Erbt Konstuktoren von OceanObject*/
	public Bubble() {
	}

	public Bubble(int[] position, String name, String object) {
		super(position, name, object);
	}


	public Bubble(int x, int y, String name, String object) {
		super(x, y, name, object);
	}
	
	/**Bubble bewegt sich aufwaerts*/
	public void rise() {
		super.getPosition()[1]-=1;
	}
	
	/**Bewegt Bubble immer nur um einen pixel weiter, um zu verhindern,
	 *  dass sie z.B. den Rand des Ocean ueberspringt*/
	public void move(){
		this.rise();
		this.rise();
		this.rise();
		this.rise();
		this.rise();
		this.rise();
	}

}
