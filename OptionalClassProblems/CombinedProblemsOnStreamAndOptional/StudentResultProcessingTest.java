package OptionalClassProblems.CombinedProblemsOnStreamAndOptional;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import org.junit.Test;

public class StudentResultProcessingTest {
	List<Student> students = Arrays.asList(new Student(1, "Sam", 40), new Student(2, "Lily", 36),
			new Student(3, "Steve", 50), new Student(4, "Anna", 45));

	@Test
	public void testStudentNameStartsWithS() {
		Optional<Student> student = students.stream().filter(n -> n.name.startsWith("S")).findFirst();
		assertEquals("Sam", student.get().name);
	}

	@Test
	public void testAllStudentsScoredAbove35() {
		Boolean check = students.stream().allMatch(s -> s.score > 35);
		assertTrue(check);
	}

	@Test
	public void testCalculateAverageScore() {
		OptionalDouble average = students.stream().mapToInt(s -> s.score).average();
		assertTrue(average.isPresent());
		assertEquals(42.75, average.getAsDouble(), 0.01);
	}

	@Test
	public void testOptionalDoubleIsPresent() {
		OptionalDouble avg = students.stream().mapToInt(s -> s.score).average();
		assertTrue(avg.isPresent());
	}

	@Test
	public void testEmptyList() {
		List<Student> empty = new ArrayList<>();
		OptionalDouble avg = empty.stream().mapToInt(s -> s.score).average();
		assertFalse(avg.isPresent());
	}
}
