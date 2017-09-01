package Vehicle;

import java.util.ArrayList;

import BusinessLogic.Constants;
import Request.RequestList;

public class CarDirectory {
	
	private static ArrayList<Car> carList = new ArrayList<>();
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
