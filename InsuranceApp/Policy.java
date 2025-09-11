package InsuranceApp;

class Policy {
	private String policyNumber;
	private String holderName;
	private double premiumAmount;

	public Policy(String policyNumber, String holderName, double premiumAmount) {
		this.policyNumber = policyNumber;
		this.holderName = holderName;
		this.premiumAmount = premiumAmount;
	}

	public String getPolicyNumber() {
		return policyNumber;
	}

	public String getHolderName() {
		return holderName;
	}

	public double getPremiumAmount() {
		return premiumAmount;
	}

	@Override
	public String toString() {
		return "Policy{" + "policyNumber='" + policyNumber + '\'' + ", holderName='" + holderName + '\''
				+ ", premiumAmount=" + premiumAmount + '}';
	}
}
