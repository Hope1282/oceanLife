package infpp;


public class Plant extends OceanObject {

	public Plant() {
		// TODO Auto-generated constructor stub
	}

	public Plant(int[] position, String name, String object) {
		super(position, name, object);
		// TODO Auto-generated constructor stub
	}

	public Plant(int x, int y, String name, String object) {
		super(x, y, name, object);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		super.getPosition()[0]-=10;
		super.getPosition()[1]-=10;
	}

}
