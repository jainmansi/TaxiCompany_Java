package com.mansijain.business;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import com.mansijain.request.Request;
import com.mansijain.request.RequestList;
import com.mansijain.vehicle.Car;
import com.mansijain.vehicle.CarDirectory;
import com.mansijain.vehicle.MotorCycleDirectory;
import com.mansijain.vehicle.Motorcycle;
import com.mansijain.vehicle.Van;
import com.mansijain.vehicle.VanDirectory;
import com.mansijain.vehicle.Vehicle;

public class Simulator {

	private static Random random;
	private static int randomDelay = 0;
	private static int totalCount = 0;
	private static RequestList requestList;

	public static void init() {
		random = new Random();
		randomDelay = random.nextInt((10 - 5) + 1) + 5;
		requestList = RequestList.getInstance();
	}

	public static void main(String args[]) {
		init();

		final Timer timerTask = new Timer();

		timerTask.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				if (totalCount < Constants.TOTAL_REQUESTS) {

					totalCount++;
					
					Request request = RequestHandler.generateRequest();
					int groupSize = request.getCustomer().getGroupSize();
					Vehicle vehicle = VehicleHandler.getVehicle(groupSize);
					randomDelay = random.nextInt((10 - 5) + 1) + 5;

					removeCompletedRequests();
					addNewRequest(request, vehicle);
					manageWaitList();

				} else {
					System.out.println("Completed " + totalCount + " requests");
					printTotalAvailable();
					timerTask.cancel();
				}
			}
		}, randomDelay * 1000, randomDelay * 1000);
	}
	
	//Method to remove all the completed trips from request lists

	public static void removeCompletedRequests() {

		List<Request> removeVanRequests = new ArrayList<Request>();
		List<Request> removeCarRequests = new ArrayList<Request>();
		List<Request> removeMotorCycleRequests = new ArrayList<Request>();

		for (Request request : requestList.getVanRequests()) {
			if (System.currentTimeMillis() > request.getEndTime()) {
				removeVanRequests.add(request);
				System.out.println("+1 Van Request Completed");
			}
		}

		requestList.getVanRequests().removeAll(removeVanRequests);

		for (Request request : requestList.getCarRequests()) {
			if (System.currentTimeMillis() > request.getEndTime()) {
				removeCarRequests.add(request);
				System.out.println("+1 Car Request Completed");
			}
		}

		requestList.getCarRequests().removeAll(removeCarRequests);

		for (Request request : requestList.getMotorcycleRequests()) {
			if (System.currentTimeMillis() > request.getEndTime()) {
				removeMotorCycleRequests.add(request);
				System.out.println("+1 Motorcycle Request Completed");
			}
		}

		requestList.getMotorcycleRequests().removeAll(removeMotorCycleRequests);
	}
	

	//Method to add incoming vehicle requests
	private static void addNewRequest(Request request, Vehicle vehicle) {
		
		if (vehicle instanceof Van) {
			if (VanDirectory.isAvailable()) {
				System.out.println("This is Van request");
				request.setEndTime(System.currentTimeMillis() + request.getDuration() * 1000);
				requestList.getVanRequests().add(request);
				System.out.println("Total Van requests " + requestList.getVanRequests().size());
			} else {
				System.out.println("Request added to Van Waitlist");
				requestList.getVanWaitlist().add(request);
			}
		} else if (vehicle instanceof Car) {
			if (CarDirectory.isAvailable()) {
				System.out.println("This is Car request");
				request.setEndTime(System.currentTimeMillis() + request.getDuration() * 1000);
				requestList.getCarRequests().add(request);
				System.out.println("Total Car requests " + requestList.getCarRequests().size());
			} else {
				System.out.println("Request add to Car Waitlist");
				requestList.getCarWaitlist().add(request);
			}
		} else if (vehicle instanceof Motorcycle) {
			if (MotorCycleDirectory.isAvailable()) {
				System.out.println("This is Motorcycle request");
				request.setEndTime(System.currentTimeMillis() + request.getDuration() * 1000);
				requestList.getMotorcycleRequests().add(request);
				System.out.println("Total Motorcycle requests " + requestList.getMotorcycleRequests().size());
			} else {
				System.out.println("Request added to MotorCycle waitlist");
				requestList.getMotorcycleWaitlist().add(request);
			}
		}
	}

	private static void manageWaitList() {
		
		List<Request> removeVanRequests = new ArrayList<Request>();
		List<Request> removeCarRequests = new ArrayList<Request>();
		List<Request> removeMotorCycleRequests = new ArrayList<Request>();
		
		for (Request request : requestList.getVanWaitlist()) {
			if (VanDirectory.isAvailable()) {
				System.out.println("Request removed from Van waitlist");
				removeVanRequests.add(request);
				requestList.getVanRequests().add(request);
			} else
				break;
		}
		
		requestList.getVanWaitlist().removeAll(removeVanRequests);

		for (Request request : requestList.getCarWaitlist()) {

			if (CarDirectory.isAvailable()) {
				System.out.println("Request removed from Car waitlist");
				removeCarRequests.add(request);
				requestList.getCarRequests().add(request);
			} else
				break;
		}
		
		requestList.getCarWaitlist().removeAll(removeCarRequests);

		for (Request request : requestList.getMotorcycleWaitlist()) {
			if (MotorCycleDirectory.isAvailable()) {
				System.out.println("Request removed from MotorCycle waitlist");
				removeMotorCycleRequests.add(request);
				requestList.getMotorcycleRequests().add(request);
			} else
				break;
		}
		
		requestList.getMotorcycleWaitlist().removeAll(removeMotorCycleRequests);
	}
	
	private static void printTotalAvailable() {
		System.out.println("Total Number of Vans Available " + (Constants.NUM_VANS - requestList.getVanRequests().size()));
		System.out.println("Total Number of Cars Available " + (Constants.NUM_CARS - requestList.getCarRequests().size()));
		System.out.println("Total Number of MotorCycle Available " + (Constants.NUM_MOTORCYCLES - requestList.getMotorcycleRequests().size()));
	}
}
