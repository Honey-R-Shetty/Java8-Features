package OptionalClassProblems.CombinedProblemsOnStreamAndOptional;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class EcommerceOrders {
	public static void main(String[] args) {
		List<Order> orders = Arrays.asList(new Order(1, "Alice", 15000, "SHIPPED"),
				new Order(2, "Bob", 5000, "PENDING"), new Order(3, "Charlie", 20000, "CANCELLED"),
				new Order(4, "Daisy", 8000, "DELIVERED"));
		
		// customers with orders greater than 10,000
		List<Order> customer = orders.stream()
				.filter(o -> o.totalAmount>10000)
				.collect(Collectors.toList());
		System.out.println("\ncustomers with orders greater than 10,000 :");
		customer.forEach(System.out::println);
		
		//any order is in "CANCELLED" status
		List<Order> isCancelled = orders.stream()
				.filter(o -> o.status.equalsIgnoreCase("Cancelled"))
				.collect(Collectors.toList());
		System.out.println("Orders in CANCELLED status : ");
		isCancelled.forEach(System.out::println);
		
		// Find minimum order amount.
	    Optional<Order> amount = orders.stream().min(Comparator.comparing(Order::getTotalAmount));
		System.out.println("\nThe minimum order amount : "+amount);
		
		//Extract all unique order statuses
		Set<String> uniqueStatus = orders.stream()
				.map(o->o.status)
				.collect(Collectors.toSet());
		System.out.println("\nAll unique order statuses : ");
		System.out.println(uniqueStatus);
		
				
	}
}
