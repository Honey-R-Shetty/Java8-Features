package OptionalClassProblems.CombinedProblemsOnStreamAndOptional;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;

public class BankTransactionTest {
	private List<Transaction> transactions;

	@Before
	public void setUp() {
		transactions = new ArrayList<>(
				Arrays.asList(new Transaction(1, "ACC123", 6000, "DEBIT"), new Transaction(2, "ACC124", 3000, "CREDIT"),
						new Transaction(3, "ACC125", 7000, "DEBIT"), new Transaction(4, "ACC126", 2000, "CREDIT")));
	}

	@Test
	public void testAmountAbove5000() {
		List<Transaction> accounts = transactions.stream().filter(a -> a.amount > 5000).collect(Collectors.toList());
		assertEquals(2, accounts.size());
	}

	@Test
	public void testTotalSumOfTransaction() {
		Double totalAmount = transactions.stream().mapToDouble(a -> a.amount).sum();
		assertEquals(18000, totalAmount);
	}

	@Test
	public void testFirstCreditTransaction() {
		Optional<Transaction> account = transactions.stream().filter(t -> t.type.equalsIgnoreCase("credit"))
				.findFirst();
		assertTrue(account.isPresent());
		assertEquals("ACC124", account.get().accountNumber);
	}

	@Test
	public void testEmptyTransactionList() {
		transactions.clear();
		Optional<Transaction> firstCredit = transactions.stream().filter(t -> t.type.equalsIgnoreCase("credit"))
				.findFirst();

		assertThrows(RuntimeException.class, () -> {
			firstCredit.ifPresentOrElse(System.out::println, () -> {
				throw new RuntimeException("Transaction not found");
			});
		});
	}
}
