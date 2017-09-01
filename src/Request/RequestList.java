package Request;

import java.util.ArrayList;

public class RequestList {

	private static ArrayList<Request> vanRequests = new ArrayList<>();
	private static ArrayList<Request> carRequests = new ArrayList<>();
	private static ArrayList<Request> motorcycleRequests = new ArrayList<>();
	private static ArrayList<Request> vanWaitlist = new ArrayList<>();
	private static ArrayList<Request> carWaitlist = new ArrayList<>();
	private static ArrayList<Request> motorcycleWaitlist = new ArrayList<>();
	
	private static RequestList requestList;
	
	private RequestList(){
		
	}
	
	public static RequestList getInstance(){
		requestList = new RequestList();
		return requestList;
	}

	public ArrayList<Request> getVanRequests() {
		return vanRequests;
	}

	public void setVanRequests(ArrayList<Request> vanRequests) {
		RequestList.vanRequests = vanRequests;
	}

	public ArrayList<Request> getCarRequests() {
		return carRequests;
	}

	public void setCarRequests(ArrayList<Request> carRequests) {
		RequestList.carRequests = carRequests;
	}

	public ArrayList<Request> getMotorcycleRequests() {
		return motorcycleRequests;
	}

	public void setMotorcycleRequests(ArrayList<Request> motorcycleRequests) {
		RequestList.motorcycleRequests = motorcycleRequests;
	}

	public ArrayList<Request> getVanWaitlist() {
		return vanWaitlist;
	}

	public void setVanWaitlist(ArrayList<Request> vanWaitlist) {
		RequestList.vanWaitlist = vanWaitlist;
	}

	public ArrayList<Request> getCarWaitlist() {
		return carWaitlist;
	}

	public void setCarWaitlist(ArrayList<Request> carWaitlist) {
		RequestList.carWaitlist = carWaitlist;
	}

	public ArrayList<Request> getMotorcycleWaitlist() {
		return motorcycleWaitlist;
	}

	public void setMotorcycleWaitlist(ArrayList<Request> motorcycleWaitlist) {
		RequestList.motorcycleWaitlist = motorcycleWaitlist;
	}

}
