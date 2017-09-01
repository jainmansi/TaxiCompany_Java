package Vehicle;

import java.util.ArrayList;

import BusinessLogic.Constants;
import Request.RequestList;

public class MotorCycleDirectory {

	private static ArrayList<Motorcycle> motorcycleList = new ArrayList<>();
	private static RequestList requestList = RequestList.getInstance();
	
	public static Motorcycle addMotorCycle() {
		Motorcycle motorCycle = new Motorcycle(); 
		motorcycleList.add(motorCycle);
		return motorCycle;
	}
	
	public static boolean isAvailable() {
		return (Constants.NUM_MOTORCYCLES - requestList.getMotorcycleRequests().size()) != 0;
	}
}
