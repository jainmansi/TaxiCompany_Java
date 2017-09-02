package com.mansijain.business;

import java.util.LinkedList;
import java.util.Queue;

import com.mansijain.vehicle.Car;
import com.mansijain.vehicle.CarDirectory;
import com.mansijain.vehicle.MotorCycleDirectory;
import com.mansijain.vehicle.Motorcycle;
import com.mansijain.vehicle.Van;
import com.mansijain.vehicle.VanDirectory;
import com.mansijain.vehicle.Vehicle;

public class VehicleHandler {

	private static Queue<Car> cars = new LinkedList<Car>();
	private static Queue<Motorcycle> motorcycles = new LinkedList<Motorcycle>();
	private static Queue<Van> vans = new LinkedList<Van>();

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