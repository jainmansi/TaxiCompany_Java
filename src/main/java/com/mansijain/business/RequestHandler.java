package com.mansijain.business;

import java.util.Random;

import com.mansijain.customer.Customer;
import com.mansijain.request.Request;
import com.mansijain.vehicle.Vehicle;

public class RequestHandler {
	
	private static final int[] capacities = {2, 4, 7};

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
