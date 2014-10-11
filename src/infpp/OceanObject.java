package infpp;

import java.io.Serializable;

public abstract class OceanObject implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int[] position = new int[2];
	private String name;
	private String object;
	
	public OceanObject(){
		this.position[0] = 0;
		this.position[1] = 0;
	}
	/**Konstruktor mit Integer array*/
	public OceanObject(int[] position, String name, String object){
		this.position[0] = position[0];
		this.position[1] = position[1];
		this.name = name;
		this.object = object;
	}
	/**Konstruktor mit zwei Integer*/
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
	
	/**Praedestiniert fuer die Konsolenausgabe*/
	public String toString(){
		String str ="Name = " + this.name + "; position: x = " + this.getPosition()[0] + "; y = " + this.position[1];
		return str;
	}

}
