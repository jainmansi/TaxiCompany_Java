package Customer;

public class Customer {

	private int customerId;
	private static int count = 0;
	private int groupSize;
	
	public Customer(){
		customerId = count;
		count++;
	}

	public int getCustomerId() {
		return customerId;
	}

	public int getGroupSize() {
		return groupSize;
	}

	public void setGroupSize(int groupSize) {
		this.groupSize = groupSize;
	}
	
}
