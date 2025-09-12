package OptionalClassProblems.CombinedProblemsOnStreamAndOptional;

class Transaction {
	int id;
	String accountNumber;
	double amount;
	String type;

	public Transaction(int id, String accountNumber, double amount, String type) {
		this.id = id;
		this.accountNumber = accountNumber;
		this.amount = amount;
		this.type = type;
	}

	@Override
	public String toString() {
		return "Transaction{id=" + id + ", accountNumber='" + accountNumber + "', amount=" + amount + ", type='" + type
				+ "'}";
	}
}
