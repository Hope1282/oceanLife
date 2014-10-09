package infpp;


public class Stone extends OceanObject {

	public Stone() {
		// TODO Auto-generated constructor stub
	}

	public Stone(int[] position, String name, String object) {
		super(position, name, object);
		// TODO Auto-generated constructor stub
	}

	public Stone(int x, int y, String name, String object) {
		super(x, y, name, object);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		boolean fall = true;
		if(super.getPosition()[1]<Ocean.getInstance().getDepth()-1){
			for(int i=0; i<Ocean.getInstance().getOceanObjects().size();i++){
				if(Ocean.getInstance().getOceanObjects().get(i).getObject() == "Stone"){
					if(Ocean.getInstance().getOceanObjects().get(i).getPosition()[1] == this.getPosition()[1]+1){
						fall = false;
					}
				}
			}
			if(fall){
				this.getPosition()[1]+=1;
			}
		}
	}

}
