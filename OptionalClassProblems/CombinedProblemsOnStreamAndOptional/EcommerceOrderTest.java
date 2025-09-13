package OptionalClassProblems.CombinedProblemsOnStreamAndOptional;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;

public class EcommerceOrderTest {
	private List<Order> orders;

	@Before
	public void setUp() {
		orders = Arrays.asList(new Order(1, "Alice", 15000, "SHIPPED"), new Order(2, "Bob", 5000, "PENDING"),
				new Order(3, "Charlie", 20000, "CANCELLED"), new Order(4, "Daisy", 8000, "DELIVERED"));
	}

	@Test
	public void testCustomerWithOrderAbove10000() {
		List<Order> order = orders.stream().filter(o -> o.totalAmount > 10000).collect(Collectors.toList());
		assertEquals(2, order.size());
	}

	@Test
	public void testOrderHasStatusCancelled() {
		Boolean check = orders.stream().anyMatch(o -> o.status.equalsIgnoreCase("cancelled"));
		assertEquals(true, check);
	}

	@Test
	public void testMinimumOrderAmount() {
		Optional<Order> amount = orders.stream().min(Comparator.comparingDouble(o -> o.totalAmount));
		assertTrue(amount.isPresent());
		assertEquals(5000, amount.get().totalAmount, 0.01);
	}

	@Test
	public void testAllUniqueOrderStatuses() {
		Set<String> status = orders.stream().map(o -> o.status).collect(Collectors.toSet());
		assertEquals(4, status.size());
	}

	@Test
	public void testEmptyOrderList() {
		List<Order> empty = new ArrayList<Order>();
		Optional<Order> order = empty.stream().max(Comparator.comparingDouble(o -> o.totalAmount));
		assertFalse(order.isPresent());
	}
}
