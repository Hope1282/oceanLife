package infpp;


public class Stone extends OceanObject {

	/**Erbt Konstuktoren von OceanObject*/
	public Stone() {
	}

	public Stone(int[] position, String name, String object) {
		super(position, name, object);
		// TODO Auto-generated constructor stub
	}

	public Stone(int x, int y, String name, String object) {
		super(x, y, name, object);
		// TODO Auto-generated constructor stub
	}

	/**Sink laesst den Stein nur dann eine bewegung ausfueren,
	 * wenn er sich nicht am unteren Ende des Ocean befindet,
	 * und auch keine anderen Steine unter ihm sind
	 */
	public void sink() {
		boolean fall = true;
		if(super.getPosition()[1]<Ocean.getInstance().getDepth()-100){
			for(int i=0; i<Ocean.getInstance().getOceanObjects().size();i++){
				if(Ocean.getInstance().getOceanObjects().get(i).getObject().equals("Stone")){
					if(Ocean.getInstance().getOceanObjects().get(i).getPosition()[1] == this.getPosition()[1]+50){
						if(Ocean.getInstance().getOceanObjects().get(i).getPosition()[0] < this.getPosition()[0]+50 && Ocean.getInstance().getOceanObjects().get(i).getPosition()[0] > this.getPosition()[0]-50){
						fall = false;
						}
					}
				}
			}
			if(fall){
				this.getPosition()[1]+=1;
			}
		}
		
	}
	
	/**Bewegt Stone immer nur um einen pixel weiter, um zu verhindern,
	 *  dass er z.B. den Rand des Ocean ueberspringt*/
	public void move() {
		this.sink();
		this.sink();
		this.sink();
		this.sink();
	}

}
