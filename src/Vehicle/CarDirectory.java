package Vehicle;

import java.util.ArrayList;

import BusinessLogic.Constants;

public class CarDirectory {
	
	private static ArrayList<Car> carList = new ArrayList<>();
	
	public static Car addCar() {
		Car car = new Car();
		carList.add(car);
		return car;
	}
	
	public static boolean isAvailable() {
		return (Constants.NUM_CARS - carList.size()) != 0;
	}

}
