package infpp;

public class Fish extends OceanObject {
	private int[] position = new int[2];
	private String name;

	public Fish() {
		this.position[0] = 0;
		this.position[1] = 0;
	}

	public Fish(int[] position, String name) {
		this.position[0] = position[0];
		this.position[1] = position[1];
		this.name = name;
	}

	public Fish(int x, int y, String name) {
		this.position[0] = x;
		this.position[1] = y;
		this.name = name;
	}

	public int[] getPosition() {
		return position;
	}

	public void setPosition(int[] position) {
		this.position[0] = position[0];
		this.position[1] = position[1];
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public void move(){
		
	}

	public String toString() {
		String str = "x=" + this.getPosition()[0] + " y=" + this.position[1]
				+ " name=" + this.name;
		return str;
	}
}
