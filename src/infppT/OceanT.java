package infppT;

import infpp.Fish;

public class OceanT {
	private int width, depth;
	private Fish nemo, dorie;
	
	public OceanT(){
		this.width=0;
		this.depth=0;
	}
	public OceanT(int width, int depth, Fish nemo, Fish dorie){
		this.width=width;
		this.depth=depth;
		this.nemo=nemo;
		this.dorie=dorie;
	}
	
	public int getWidth(){
		return width;
	}
	public void setWidth(int width){
		this. width=width;
	}
	public int getDepth(){
		return depth;
	}
	public void setDepth(int depth){
		this.depth=depth;
	}
	
	public Fish getNemo(){
		return nemo;
	}
	public void setNemo(Fish nemo){
		this.nemo=nemo;
	}
	public Fish getDorie(){
		return dorie;
	}
	public void setDorie(Fish dorie){
		this.dorie=dorie;
	}
	
	public void move(){
		nemo.getPosition()[0]+=1;
	}
	
	public String toString(){
		String str="depth="+this.depth
				+" width="+this.width
				+" fishOne: "+this.nemo.toString()
				+" fishTwo: "+this.dorie.toString();
		return str;
	}
}
