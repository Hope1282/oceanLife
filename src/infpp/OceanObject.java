package infpp;

public abstract class OceanObject {
	private int[] position = new int[2];
	private String name;
	private String object;
	
	public OceanObject(){
		this.position[0] = 0;
		this.position[1] = 0;
	}
	public OceanObject(int[] position, String name, String object){
		this.position[0] = position[0];
		this.position[1] = position[1];
		this.name = name;
		this.object = object;
	}
	public OceanObject(int x, int y, String name, String object){
		this.position[0] = x;
		this.position[1] = y;
		this.name = name;
		this.object = object;
	}
	
	public int[] getPosition(){
		return this.position;
	}
	public void setPosition(int[] position){
		this.position = position;
	}
	public String getName(){
		return this.name;
	}
	public void setName(String name){
		this.name = name;
	}
	public String getObject(){
		return this.object;
	}
	
	public abstract void move();
	
	public String toString(){
		String str ="Name = " + this.name + "; position: x = " + this.getPosition()[0] + "; y = " + this.position[1];
		return str;
	}

}
