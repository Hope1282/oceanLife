package infpp;


public class Bubble extends OceanObject {

	public Bubble() {
		// TODO Auto-generated constructor stub
	}

	public Bubble(int[] position, String name) {
		super(position, name);
		// TODO Auto-generated constructor stub
	}

	public Bubble(int x, int y, String name) {
		super(x, y, name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		super.getPosition()[0]+=10;
	}

}
