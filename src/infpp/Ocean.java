package infpp;

import java.util.LinkedList;

import javax.swing.SwingUtilities;

public class Ocean implements OceanInterface {
	
	/**Instanziiere Ocean, ind initiiere die Parameter Width, Depth und die LinkedList oceanObjects*/
	public static Ocean instance;
	private int Width, Depth;
	private LinkedList<OceanObject> oceanObjects;
	
	/**Konstruiere Ocean mit gegebenen Parametern*/
	Ocean (int width , int depth , LinkedList <OceanObject> oceanObjects ){
		this.Width= width;
		this.Depth=depth;
		this.oceanObjects=oceanObjects;
	}
	

	public int getWidth() {
		return this.Width;
	}

	public void setWidth(int width) {
		this.Width = width;
	}

	public int getDepth() {
		return this.Depth;
	}

	public void setDepth(int depth) {
		this.Depth = depth;
	}

	public LinkedList<OceanObject> getOceanObjects() {
		return this.oceanObjects;
	}

	public void setOceanObjects(LinkedList<OceanObject> oceanObjects) {
		this.oceanObjects = oceanObjects;
	}
	
	public static synchronized Ocean getInstance() {
		if (instance == null) {
			instance = new Ocean(20, 20, new LinkedList<OceanObject>());
		}
		return instance;
	}
	
	/**Ruft die move-Methoden der einzelnen OceanObject-Objecte auf 
	 * und laesst bestimmt objekte interagieren.
	 */
	public void move() {
		int s = oceanObjects.size();
		for(int i=0;i<s;i++){//gehe OceanObjects durch
			oceanObjects.get(i).move();//Bewege die OceanObject-Objekte
			if(oceanObjects.get(i).getObject().equals("Fish")){//suche nach Fish-Objekten
				for(int j=0;j<s;j++){//gehen die OceanObjects ein weiteres mal durch
					if(oceanObjects.get(j).getObject().equals("Plant")){//suche nach Plant-Objekten
						if(oceanObjects.get(j).getPosition()[0] < oceanObjects.get(i).getPosition()[0]+50 && oceanObjects.get(j).getPosition()[0] > oceanObjects.get(i).getPosition()[0]-50){//Vergleiche X-Koordinaten 
							if(oceanObjects.get(j).getPosition()[1] < oceanObjects.get(i).getPosition()[1]+50 && oceanObjects.get(j).getPosition()[1] > oceanObjects.get(i).getPosition()[1]-50){//Vergleiche Y-Koordinaten
								for(int o=0; o<infpp.OceanGUI.getDeleteBox().getItemCount();o++){//Gehe die Eintraege in der Delete-Liste der GUI durch
									if(infpp.OceanGUI.getDeleteBox().getItemAt(o).equals(oceanObjects.get(j).getName())){//Vergleiche die Objektnamen
										infpp.OceanGUI.getDeleteBox().removeItemAt(o);//Entferne den Listeneintrag
									}
								}
							oceanObjects.remove(j);//Entferne das Objekt
							s= s-1;// Verringere den Objektzaehler s um 1
							}
						}
					}
				}
			}
			if(oceanObjects.get(i).getObject().equals("Bubble")){//Suche nach Bubble-Objekten
				if(oceanObjects.get(i).getPosition()[1]<=0){//Ueberpruefe deren Position
					int b = -1;
					for(int j=0; j<infpp.OceanGUI.getDeleteBox().getItemCount();j++){
						if(infpp.OceanGUI.getDeleteBox().getItemAt(j).equals(oceanObjects.get(i).getName())){
							b = j;//Merke, an welcher Stelle der Delete-Liste sich die Bubble befindet
						}
					}
					infpp.OceanGUI.getDeleteBox().removeItemAt(b);//entferne die Bubble aus der Delete-Liste der GUI
					oceanObjects.remove(i);//Entferne Objekt
					s = s-1;// Verringere den Objektzaehler s um 1
				}
			}
		}
		infpp.OceanGUI.getOceanP().removeAll();
		infpp.OceanGUI.build();//Update der GUI
	}
	public String toString(){
		String ob="";
		for(int i=0;i<oceanObjects.size(); i++){
			ob =ob +"\n"+ oceanObjects.get(i);
		}
		String str= "Ocean: Width: "+this.Width+" Depth: "+this.Depth+"\nObjects:"+ob+"\n";
		return str;
	}
	
	/**Provisorische Methode, die den Ocean als String erstellt.
	 * wurde im fruehen Programmierstadium verwendet, und hat nun keine aktive Rolle mehr.
	 * Ist relativ rechenaufwaendig.
	 * @return
	 */
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


}
