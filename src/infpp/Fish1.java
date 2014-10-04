package infpp;


public class Fish1 extends OceanObject {

	public Fish1() {
		// TODO Auto-generated constructor stub
	}

	public Fish1(int[] position, String name) {
		super(position, name);
		// TODO Auto-generated constructor stub
	}

	public Fish1(int x, int y, String name) {
		super(x, y, name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		super.getPosition()[0]+=10;
		super.getPosition()[1]-=10;
	}

}
