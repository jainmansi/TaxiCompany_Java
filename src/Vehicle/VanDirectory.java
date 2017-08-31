package Vehicle;

import java.util.ArrayList;

import BusinessLogic.Constants;

public class VanDirectory {

	private static ArrayList<Van> vanList = new ArrayList<>();
	
	public static Van addVan() {
		Van van = new Van();
		vanList.add(van);
		return van;
	}
	
	public static boolean isAvailable() {
		return (Constants.NUM_VANS - vanList.size()) != 0;
	}
}
