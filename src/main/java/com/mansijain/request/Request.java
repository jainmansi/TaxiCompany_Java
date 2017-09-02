package com.mansijain.request;

import com.mansijain.customer.Customer;
import com.mansijain.vehicle.Vehicle;

public class Request {

	private long endTime;
	private int duration;
	private int requestId;
	private Vehicle vehicle;
	private Customer customer;
	private static int count = 0;

	public Request(int duration, Vehicle vehicle, Customer customer) {
		this.customer = customer;
		this.vehicle = vehicle;
		this.duration = duration;
		this.requestId = count;
		count++;
	}

	public long getEndTime() {
		return endTime;
	}

	public void setEndTime(long endTime) {
		this.endTime = endTime;
	}

	public int getRequestId() {
		return requestId;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

}
