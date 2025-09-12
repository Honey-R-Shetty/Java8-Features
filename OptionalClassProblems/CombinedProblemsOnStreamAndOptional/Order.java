package OptionalClassProblems.CombinedProblemsOnStreamAndOptional;

class Order {
	int id;
	String customerName;
	double totalAmount;
	String status;

	public Order(int id, String customerName, double totalAmount, String status) {
		this.id = id;
		this.customerName = customerName;
		this.totalAmount = totalAmount;
		this.status = status;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", customerName=" + customerName + ", totalAmount=" + totalAmount + ", status="
				+ status + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
