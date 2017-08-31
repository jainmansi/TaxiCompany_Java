package Vehicle;

import java.util.ArrayList;

import BusinessLogic.Constants;

public class MotorCycleDirectory {

	private static ArrayList<Motorcycle> motorcycleList = new ArrayList<>();
	
	public static Motorcycle addMotorCycle() {
		Motorcycle motorCycle = new Motorcycle(); 
		motorcycleList.add(motorCycle);
		return motorCycle;
	}
	
	public static boolean isAvailable() {
		return (Constants.NUM_MOTORCYCLES - motorcycleList.size()) != 0;
	}
}
