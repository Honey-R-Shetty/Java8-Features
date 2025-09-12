package OptionalClassProblems.CombinedProblemsOnStreamAndOptional;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class EmployeePerformanceTest {
	List<Employee> employees = Arrays.asList(new Employee(1, "Alice", "IT", 60000), new Employee(2, "Bob", "HR", 40000),
			new Employee(3, "Charlie", "IT", 55000), new Employee(4, "Daisy", "HR", 45000),
			new Employee(5, "Eve", "Finance", 70000));

	@Test
	public void testEmployeesInIT() {
		Long count = employees.stream().filter(e -> e.department.equalsIgnoreCase("it") && e.salary > 50000).count();
		assertEquals(2, count);
	}

	@Test
	public void testCountInHR() {
		Long count = employees.stream().filter(e -> e.department.equalsIgnoreCase("Hr")).count();
		assertEquals(2, count);
	}

	@Test
	public void testHighestPaidEmployee() {
		Optional<Employee> highestPaid = employees.stream().max(Comparator.comparingDouble(s -> s.salary));
		assertTrue(highestPaid.isPresent());
		assertEquals(70000, highestPaid.get().salary);
	}

	@Test
	public void testSameMaxSalary() {
		List<Employee> sameSalary = Arrays.asList(new Employee(1, "A", "IT", 50000), new Employee(2, "B", "IT", 70000),
				new Employee(3, "C", "IT", 70000));
		Optional<Employee> highest = sameSalary.stream().max(Comparator.comparingDouble(e -> e.salary));
		assertTrue(highest.isPresent());
		assertEquals(70000, highest.get().salary);
	}
	
	@Test
	public void testEmptyEmployeeList() {
		List<Employee> empty = new ArrayList<>();
		Optional<Employee> highest = empty.stream().max(Comparator.comparingDouble(e -> e.salary));
		assertFalse(highest.isPresent());
	}
}
