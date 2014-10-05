package infpp;

import java.util.LinkedList;

public class Ocean implements OceanInterface {
	private static Ocean instance;
	private int Width, Depth;
	private LinkedList<OceanObject> oceanObjects;
	
	private Ocean (int width , int depth , LinkedList <OceanObject> oceanObjects ){
		this.Width= width;
		this.Depth=depth;
		this.oceanObjects=oceanObjects;
	}
	

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setWidth(int width) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getDepth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setDepth(int depth) {
		// TODO Auto-generated method stub

	}

	@Override
	public LinkedList<OceanObject> getOceanObjects() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setOceanObjects(LinkedList<OceanObject> oceanObjects) {
		// TODO Auto-generated method stub

	}

	public void move() {
		// TODO Auto-generated method stub
		for(int i=0;i<oceanObjects.size();i++){
			oceanObjects.get(i).move();
		}
	}
	public String toString(){
		String ob="";
		for(int i=0;i<oceanObjects.size(); i++){
			ob =ob +"\n"+ oceanObjects.get(i);
		}
		String str= "Ocean: Width: "+this.Width+" Depth: "+this.Depth+"\nObjects:"+ob+"\n";
		return str;
	}
	public String plot(){
		String str1 = "";
		String str2 = "";
		for(int i=0;i<this.Width;i++){
			str1=str1+"-";
		}
		for(int i=0;i<this.Depth;i++){
			for(int j=0;j<this.Width;j++){
				boolean ind = false;
				int[] pos = new int [2];
				pos[0] = j;
				pos[1] =i;
				for(int o=0;o<this.oceanObjects.size();o++){
					if(oceanObjects.get(o).getPosition()[0]==j){
						if(oceanObjects.get(o).getPosition()[1]==i){
							ind = true;
							}
						}
					}
				if(ind == true){
					str2 = str2 + "F";
				} else {
					str2 = str2 + "&nbsp;";
				}
			}
			str2 =str2 + "<br>";
		}
		return "<html>"+str1+"<br>"+str2+str1+"</html>";
	}


	public static synchronized Ocean getInstance() {
		if (instance == null) {
			instance = new Ocean(200, 200, new LinkedList<OceanObject>());
		}
		return instance;
	}

}
