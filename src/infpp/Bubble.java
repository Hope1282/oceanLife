package infpp;


public class Bubble extends OceanObject {

	public Bubble() {
		// TODO Auto-generated constructor stub
	}

	public Bubble(int[] position, String name, String object) {
		super(position, name, object);
		// TODO Auto-generated constructor stub
	}


	public Bubble(int x, int y, String name, String object) {
		super(x, y, name, object);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		if(this.getPosition()[1]>0){
			super.getPosition()[1]-=1;//Bubble bewegt sich aufwaerts
		} else {
			for(int i=0; i<infppGUI.OceanGUI.getDeleteBox().getItemCount();i++){
				if(infppGUI.OceanGUI.getDeleteBox().getItemAt(i).equals(this.getName())){
					infppGUI.OceanGUI.getDeleteBox().removeItemAt(i);//Aus der Auswahlliste entfernen, falls die Oberkante erreicht wird
				}
			}
			for(int i=0; i<Ocean.getInstance().getOceanObjects().size(); i++){
				if(Ocean.getInstance().getOceanObjects().get(i) == this){
					Ocean.getInstance().getOceanObjects().remove(i);//Aus der LinkedList entfernen, falls Oberkante erreicht wird
				}
			}
		}
	}

}
