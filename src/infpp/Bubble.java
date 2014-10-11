package infpp;


public class Bubble extends OceanObject {

	public Bubble() {
		// TODO Auto-generated constructor stub
	}

	public Bubble(int[] position, String name, String object) {
		super(position, name, object);
		// TODO Auto-generated constructor stub
	}


	public Bubble(int x, int y, String name, String object) {
		super(x, y, name, object);
		// TODO Auto-generated constructor stub
	}

	public void rise() {
		// TODO Auto-generated method stub
		super.getPosition()[1]-=1;//Bubble bewegt sich aufwaerts
	}
	public void move(){
		this.rise();
		this.rise();
		this.rise();
		this.rise();
		this.rise();
		this.rise();
	}

}
