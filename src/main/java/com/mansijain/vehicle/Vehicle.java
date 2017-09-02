package com.mansijain.vehicle;

public abstract class Vehicle {

	private int vehicleid;
	private static int count = 0;
	private VehicleType vehicletype;

	public Vehicle(VehicleType type) {
		this.vehicleid = count;
		this.vehicletype = type;
	}

	public enum VehicleType {
		Van("van"), Car("car"), MotorCycle("motorcycle");

		public String value;

		private VehicleType(String value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return value.toString();
		}
	}

	public int getVehicleid() {
		return vehicleid;
	}

	public void setVehicleid(int vehicleid) {
		this.vehicleid = vehicleid;
	}

	public VehicleType getVehicletype() {
		return vehicletype;
	}

	public void setVehicletype(VehicleType vehicletype) {
		this.vehicletype = vehicletype;
	}

}
