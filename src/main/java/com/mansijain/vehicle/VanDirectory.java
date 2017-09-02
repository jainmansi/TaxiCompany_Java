package com.mansijain.vehicle;

import java.util.ArrayList;

import com.mansijain.business.Constants;
import com.mansijain.request.RequestList;


public class VanDirectory {

	private static ArrayList<Van> vanList = new ArrayList<Van>();
	private static RequestList requestList = RequestList.getInstance();
	
	public static Van addVan() {
		Van van = new Van();
		vanList.add(van);
		return van;
	}
	
	public static boolean isAvailable() {
		return (Constants.NUM_VANS - requestList.getVanRequests().size()) != 0;
	}
}
