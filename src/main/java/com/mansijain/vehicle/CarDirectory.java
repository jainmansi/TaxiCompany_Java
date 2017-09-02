package com.mansijain.vehicle;

import java.util.ArrayList;

import com.mansijain.business.Constants;
import com.mansijain.request.RequestList;


public class CarDirectory {
	
	private static ArrayList<Car> carList = new ArrayList<Car>();
	private static RequestList requestList = RequestList.getInstance();
	
	public static Car addCar() {
		Car car = new Car();
		carList.add(car);
		return car;
	}
	
	public static boolean isAvailable() {
		return (Constants.NUM_CARS - requestList.getCarRequests().size()) != 0;
	}

}
