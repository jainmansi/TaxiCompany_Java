package com.mansijain.vehicle;

import java.util.ArrayList;

import com.mansijain.business.Constants;
import com.mansijain.request.RequestList;

public class MotorCycleDirectory {

	private static ArrayList<Motorcycle> motorcycleList = new ArrayList<Motorcycle>();
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
