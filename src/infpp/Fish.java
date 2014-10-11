package infpp;


public class Fish extends OceanObject {
	
	/**Bewegung in x-Richtung invertieren*/
	private boolean invX = false;
	/**Bewegung in y-Richtung invertieren*/
	private boolean invY = false;

	/**Erbt Konstruktoren von Oceanobject*/
	public Fish() {
	}

	public Fish(int[] position, String name, String object) {
		super(position, name, object);
	}

	public Fish(int x, int y, String name, String object) {
		super(x, y, name, object);
	}
	
	/**Dreht um, wenn er an eine Wand stoesst*/
	public void swim() {
		if(super.getPosition()[0] == Ocean.getInstance().getWidth()-71){
			invX = true;
		} else if(super.getPosition()[0] == 0){
			invX = false;
		}
		if(super.getPosition()[1] == Ocean.getInstance().getDepth()-71){
			invY = true;
		} else if(super.getPosition()[1] == 0){
			invY = false;
		}
		if(invX){
			super.getPosition()[0]-=1;
		} else {
			super.getPosition()[0]+=1;
		}
		if(invY){
			super.getPosition()[1]-=1;
		} else {
			super.getPosition()[1]+=1;
		}
	}
	
	/**Bewegt Fish immer nur um einen pixel weiter, um zu verhindern,
	 *  dass er z.B. den Rand des Ocean ueberspringt*/
	public void move() {
		this.swim();
		this.swim();
		this.swim();
		this.swim();
		this.swim();
		this.swim();
		this.swim();
		this.swim();
		this.swim();
		this.swim();
	}

}
