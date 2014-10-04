package infpp;


public class Stone extends OceanObject {

	public Stone() {
		// TODO Auto-generated constructor stub
	}

	public Stone(int[] position, String name) {
		super(position, name);
		// TODO Auto-generated constructor stub
	}

	public Stone(int x, int y, String name) {
		super(x, y, name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		super.getPosition()[0]-=10;
		super.getPosition()[1]+=10;
	}

}
