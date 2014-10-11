package infpp;

import java.util.LinkedList;

import javax.swing.SwingUtilities;

public class Ocean implements OceanInterface {
	public static Ocean instance;//Instanziiere Ocean
	private int Width, Depth;
	private LinkedList<OceanObject> oceanObjects;
	
	Ocean (int width , int depth , LinkedList <OceanObject> oceanObjects ){
		this.Width= width;
		this.Depth=depth;
		this.oceanObjects=oceanObjects;
	}
	

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return this.Width;
	}

	@Override
	public void setWidth(int width) {
		// TODO Auto-generated method stub
		this.Width = width;
	}

	@Override
	public int getDepth() {
		// TODO Auto-generated method stub
		return this.Depth;
	}

	@Override
	public void setDepth(int depth) {
		// TODO Auto-generated method stub
		this.Depth = depth;
	}

	@Override
	public LinkedList<OceanObject> getOceanObjects() {
		// TODO Auto-generated method stub
		return this.oceanObjects;
	}

	@Override
	public void setOceanObjects(LinkedList<OceanObject> oceanObjects) {
		// TODO Auto-generated method stub
		this.oceanObjects = oceanObjects;
	}

	public void move() {
		// TODO Auto-generated method stub
		int s = oceanObjects.size();
		for(int i=0;i<s;i++){
			oceanObjects.get(i).move();
			if(oceanObjects.get(i).getObject().equals("Fish")){
				for(int j=0;j<s;j++){
					if(oceanObjects.get(j).getObject().equals("Plant")){
						if(oceanObjects.get(j).getPosition()[0] < oceanObjects.get(i).getPosition()[0]+50 && oceanObjects.get(j).getPosition()[0] > oceanObjects.get(i).getPosition()[0]-50){
							if(oceanObjects.get(j).getPosition()[1] < oceanObjects.get(i).getPosition()[1]+50 && oceanObjects.get(j).getPosition()[1] > oceanObjects.get(i).getPosition()[1]-50){
								for(int o=0; o<infpp.OceanGUI.getDeleteBox().getItemCount();o++){
									if(infpp.OceanGUI.getDeleteBox().getItemAt(o).equals(oceanObjects.get(j).getName())){
										infpp.OceanGUI.getDeleteBox().removeItemAt(o);
									}
								}
							oceanObjects.remove(j);
							s= s-1;
							}
						}
					}
				}
			}
			if(oceanObjects.get(i).getObject().equals("Bubble")){
				if(oceanObjects.get(i).getPosition()[1]<=0){
					int b = -1;
					for(int j=0; j<infpp.OceanGUI.getDeleteBox().getItemCount();j++){
						if(infpp.OceanGUI.getDeleteBox().getItemAt(j).equals(oceanObjects.get(i).getName())){
							b = j;//Aus der Auswahlliste entfernen, falls die Oberkante erreicht wird
						}
					}
					infpp.OceanGUI.getDeleteBox().removeItemAt(b);
					oceanObjects.remove(i);
					s = s-1;
				}
			}
		}
		infpp.OceanGUI.getOceanP().removeAll();
		infpp.OceanGUI.build();
	}
	public String toString(){
		String ob="";
		for(int i=0;i<oceanObjects.size(); i++){
			ob =ob +"\n"+ oceanObjects.get(i);
		}
		String str= "Ocean: Width: "+this.Width+" Depth: "+this.Depth+"\nObjects:"+ob+"\n";
		return str;
	}
	/*public String plot(){
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
	}*/


	public static synchronized Ocean getInstance() {
		if (instance == null) {
			instance = new Ocean(20, 20, new LinkedList<OceanObject>());
		}
		return instance;
	}

}
