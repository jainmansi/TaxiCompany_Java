package BusinessLogic;

import java.util.LinkedList;
import java.util.Queue;

import Vehicle.Car;
import Vehicle.CarDirectory;
import Vehicle.MotorCycleDirectory;
import Vehicle.Motorcycle;
import Vehicle.Van;
import Vehicle.VanDirectory;
import Vehicle.Vehicle;

public class VehicleHandler {

	private static Queue<Car> cars = new LinkedList<>();
	private static Queue<Motorcycle> motorcycles = new LinkedList<>();
	private static Queue<Van> vans = new LinkedList<>();

	public static Vehicle getVehicle(int groupSize) {
		Vehicle vehicle = null;
		if (groupSize == 2)
			vehicle = getMotorcyle();
		else if (groupSize == 4)
			vehicle = getCar();
		else if (groupSize == 7)
			vehicle = getVan();
		return vehicle;
	}

	private static Car getCar() {
		Car car = null;
		if (!cars.isEmpty())
			car = cars.poll();
		if (CarDirectory.isAvailable()) {
			car = CarDirectory.addCar();
			cars.offer(car);
		}
		return car;
	}

	private static Van getVan() {
		Van van = null;
		if (!vans.isEmpty())
			van = vans.poll();
		if (VanDirectory.isAvailable()) {
			van = VanDirectory.addVan();
			vans.offer(van);
		}
		return van;
	}
	
	private static Motorcycle getMotorcyle() {
		Motorcycle motorcycle = null;
		if (!motorcycles.isEmpty())
			motorcycle = motorcycles.poll();
		if (MotorCycleDirectory.isAvailable()) {
			motorcycle = MotorCycleDirectory.addMotorCycle();
			motorcycles.offer(motorcycle);
		}
		return motorcycle;
	}
}