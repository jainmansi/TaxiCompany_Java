package BusinessLogic;

import java.sql.Timestamp;
import java.util.Random;

import Customer.Customer;
import Request.Request;
import Vehicle.Vehicle;

public class RequestHandler {
	
	private static int[] capacities = {2, 4, 7};

	public static Request generateRequest() {
		Random random = new Random();
		int groupSize = capacities[random.nextInt(capacities.length)];
		Customer customer = new Customer();
		customer.setGroupSize(groupSize);
		Vehicle vehicle = null;
		int duration = random.nextInt((20 - 10) + 1) + 10;
		Request request = new Request(duration, vehicle, customer);
		return request;
	}
	
}
