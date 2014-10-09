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

	@Override
	public void move() {
		// TODO Auto-generated method stub
		super.getPosition()[0]+=10;
	}

}
