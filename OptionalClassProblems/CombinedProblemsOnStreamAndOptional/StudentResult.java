package OptionalClassProblems.CombinedProblemsOnStreamAndOptional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

public class StudentResult {
	public static void main(String[] args) {
		List<Student> students = Arrays.asList(new Student(1, "Sam", 40), new Student(2, "Lily", 30),
				new Student(3, "Steve", 50), new Student(4, "Anna", 45));

		// First student with name starting with "S"
		Optional<Student> firstStudent = students.stream().filter(n -> n.name.startsWith("S")).findFirst();
		firstStudent.ifPresent(System.out::println);

		// All scored above 35?
		Boolean allAbove35 = students.stream().allMatch(s -> s.score > 35);
		System.out.println("\nAll scored above 35? " + allAbove35);

		// Average Score
		OptionalDouble average = students.stream().mapToInt(s -> s.score).average();
		System.out.println("Average Score : ");
		average.ifPresentOrElse((avg) -> System.out.println(avg), () -> System.out.println("No student found!!"));
	}
}
