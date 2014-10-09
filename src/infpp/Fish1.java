package infpp;


public class Fish1 extends OceanObject {

	public Fish1() {
		// TODO Auto-generated constructor stub
	}

	public Fish1(int[] position, String name, String object) {
		super(position, name, object);
		// TODO Auto-generated constructor stub
	}

	public Fish1(int x, int y, String name, String object) {
		super(x, y, name, object);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		super.getPosition()[0]+=10;
		super.getPosition()[1]-=10;
	}

}
