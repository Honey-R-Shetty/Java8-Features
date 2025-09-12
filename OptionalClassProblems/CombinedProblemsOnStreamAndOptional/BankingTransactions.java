package OptionalClassProblems.CombinedProblemsOnStreamAndOptional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class BankingTransactions {
	public static void main(String[] args) {
		List<Transaction> transactions = Arrays.asList(
	            new Transaction(1, "ACC123", 6000, "DEBIT"),
	            new Transaction(2, "ACC124", 3000, "CREDIT"),
	            new Transaction(3, "ACC125", 7000, "DEBIT"),
	            new Transaction(4, "ACC126", 2000, "CREDIT")
	    );
		// All DEBIT transactions above 5000
        System.out.println("DEBIT transactions > 5000:");
        transactions.stream().filter(t ->t.type.equalsIgnoreCase("debit") && t.amount>5000)
        .forEach(System.out::println);
        
        // Total transaction amount
        Double totalAmount = transactions.stream().map(t -> t.amount).reduce(0.0,Double::sum);
        System.out.println("\nTotal transaction amount: "+totalAmount);
        
        //First CREDIT transaction
        Optional<Transaction> firstCredit = transactions.stream().filter(t -> t.type.equalsIgnoreCase("credit")).findFirst();
        System.out.println("\nFirst Credit transaction:");
        firstCredit.ifPresentOrElse(System.out::println, 
        		()->{throw new RuntimeException("Transaction not found");}
        );
	}
}
