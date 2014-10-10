package infpp;


public class Fish extends OceanObject {
	
	private boolean invX = false;//Bewegung in x-Richtung invertieren
	private boolean invY = false;//Bewegung in y-Richtung invertieren

	public Fish() {
		// TODO Auto-generated constructor stub
	}

	public Fish(int[] position, String name, String object) {
		super(position, name, object);
		// TODO Auto-generated constructor stub
	}

	public Fish(int x, int y, String name, String object) {
		super(x, y, name, object);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		if(super.getPosition()[0] == Ocean.getInstance().getWidth()-1){
			invX = true;
		} else if(super.getPosition()[0] == 0){
			invX = false;
		}
		if(super.getPosition()[1] == Ocean.getInstance().getDepth()-1){
			invY = true;
		} else if(super.getPosition()[1] == 0){
			invY = false;
		}
		if(invX){
			super.getPosition()[0]-=1;
		} else {
			super.getPosition()[0]+=1;
		}
		if(invY){
			super.getPosition()[1]-=1;
		} else {
			super.getPosition()[1]+=1;
		}
	}

}
