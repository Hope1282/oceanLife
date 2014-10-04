package infppT;

import infpp.Fish;

public class OceanTestT {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		OceanT oceanT = new OceanT();
		oceanT.setWidth(1024);
		oceanT.setDepth(768);
		oceanT.setNemo(new Fish (4,270, "Ulf"));
		oceanT.setDorie(new Fish(70, 200, "Rolf"));
		for (int i=0;i<5;i++)
		{
			oceanT.move();
			System.out.println(oceanT);
		}
	}

}
