package BusinessLogic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import Request.Request;
import Request.RequestList;
import Vehicle.Car;
import Vehicle.CarDirectory;
import Vehicle.MotorCycleDirectory;
import Vehicle.Motorcycle;
import Vehicle.Van;
import Vehicle.VanDirectory;
import Vehicle.Vehicle;

public class Simulator {

	private static Random random;
	private static int randomDelay = 0;
	private static int totalCount = 0;

	public static void init() {
		random = new Random();
		randomDelay = random.nextInt((10 - 5) + 1) + 5;
	}

	public static void main(String args[]) {
		init();

		Timer timerTask = new Timer();

		timerTask.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				if (totalCount < Constants.TOTAL_REQUESTS) {

					totalCount++;
					
					Request request = RequestHandler.generateRequest();
					int groupSize = request.getCustomer().getGroupSize();
					Vehicle vehicle = VehicleHandler.getVehicle(groupSize);
					randomDelay = random.nextInt((10 - 5) + 1) + 53;

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

	public static void removeCompletedRequests() {

		List<Request> removeVanRequests = new ArrayList<>();
		List<Request> removeCarRequests = new ArrayList<>();
		List<Request> removeMotorCycleRequests = new ArrayList<>();

		for (Request request : RequestList.vanRequests) {
			if (System.currentTimeMillis() > request.getEndTime()) {
				removeVanRequests.add(request);
				System.out.println("+1 Van Request Completed");
			}
		}

		RequestList.vanRequests.removeAll(removeVanRequests);

		for (Request request : RequestList.carRequests) {
			if (System.currentTimeMillis() > request.getEndTime()) {
				removeCarRequests.add(request);
			}
		}

		RequestList.carRequests.removeAll(removeCarRequests);

		for (Request request : RequestList.motorcycleRequests) {
			if (System.currentTimeMillis() > request.getEndTime()) {
				removeMotorCycleRequests.add(request);
			}
		}

		RequestList.motorcycleRequests.removeAll(removeMotorCycleRequests);
	}

	private static void addNewRequest(Request request, Vehicle vehicle) {

		if (vehicle instanceof Van) {
			if (VanDirectory.isAvailable()) {
				System.out.println("This is Van request");
				request.setEndTime(System.currentTimeMillis() + request.getDuration() * 1000);
				RequestList.vanRequests.add(request);
				System.out.println("Total Van requests " + RequestList.vanRequests.size());
			} else {
				System.out.println("Request added to Van Waitlist");
				RequestList.vanWaitlist.add(request);
			}
		} else if (vehicle instanceof Car) {
			if (CarDirectory.isAvailable()) {
				System.out.println("This is Car request");
				request.setEndTime(System.currentTimeMillis() + request.getDuration() * 1000);
				RequestList.carRequests.add(request);
			} else {
				System.out.println("Request add to Car Waitlist");
				RequestList.carWaitlist.add(request);
			}
		} else if (vehicle instanceof Motorcycle) {
			if (MotorCycleDirectory.isAvailable()) {
				System.out.println("This is Motorcycle request");
				request.setEndTime(System.currentTimeMillis() + request.getDuration() * 1000);
				RequestList.motorcycleRequests.add(request);
			} else {
				System.out.println("Request added to MotorCycle waitlist");
				RequestList.motorcycleWaitlist.add(request);
			}
		}
	}

	private static void manageWaitList() {
		
		List<Request> removeVanRequests = new ArrayList<>();
		List<Request> removeCarRequests = new ArrayList<>();
		List<Request> removeMotorCycleRequests = new ArrayList<>();
		
		for (Request request : RequestList.vanWaitlist) {
			if (VanDirectory.isAvailable()) {
				System.out.println("Request removed from Van waitlist");
				removeVanRequests.add(request);
				RequestList.vanRequests.add(request);
			} else
				break;
		}
		
		RequestList.vanWaitlist.removeAll(removeVanRequests);

		for (Request request : RequestList.carWaitlist) {

			if (CarDirectory.isAvailable()) {
				System.out.println("Request removed from Car waitlist");
				removeCarRequests.add(request);
				RequestList.carRequests.add(request);
			} else
				break;
		}
		
		RequestList.carWaitlist.removeAll(removeCarRequests);

		for (Request request : RequestList.motorcycleWaitlist) {
			if (MotorCycleDirectory.isAvailable()) {
				System.out.println("Request removed from MotorCycle waitlist");
				removeMotorCycleRequests.add(request);
				RequestList.motorcycleRequests.add(request);
			} else
				break;
		}
		
		RequestList.motorcycleWaitlist.removeAll(removeMotorCycleRequests);
	}
	
	private static void printTotalAvailable() {
		System.out.println("Total Number of Vans Available " + (Constants.NUM_VANS - RequestList.vanRequests.size()));
		System.out.println("Total Number of Cars Available " + (Constants.NUM_CARS - RequestList.carRequests.size()));
		System.out.println("Total Number of MotorCycle Available " + (Constants.NUM_MOTORCYCLES - RequestList.motorcycleWaitlist.size()));
	}
}
