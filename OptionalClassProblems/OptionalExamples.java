package OptionalClassProblems;

import java.util.*;

class OptionalExamples {

	// 1. Return Optional<String> for username
	public static Optional<String> getUsername(String username) {
		return Optional.ofNullable(username);
	}

	// 2. Use orElse() to provide default email
	public static String getEmail(String email) {
		return Optional.ofNullable(email).orElse("default@example.com");
	}

	// 3. Use orElseThrow() to throw exception if value is missing
	public static String getValueOrThrow(String value) {
		return Optional.ofNullable(value).orElseThrow(() -> new NoSuchElementException("Value not found"));
	}

	// 4. Use map() to convert string to uppercase safely
	public static Optional<String> toUpperCase(String value) {
		return Optional.ofNullable(value).map(String::toUpperCase);
	}

	// 5. Given Optional<Integer>, multiply by 2 if present, else return -1
	public static int multiplyIfPresent(Optional<Integer> number) {
		return number.map(n -> n * 2).orElse(-1);
	}

	// Student class for problem 6
	static class Student {
		int id;
		String name;

		public Student(int id, String name) {
			this.id = id;
			this.name = name;
		}

		@Override
		public String toString() {
			return "Student{id=" + id + ", name='" + name + "'}";
		}
	}

	// 6. findStudentById method
	public static Optional<Student> findStudentById(int id, List<Student> students) {
		return students.stream().filter(s -> s.id == id).findFirst();
	}

	public static void main(String[] args) {
		// Test Optional methods
		System.out.println("Username: " + getUsername("Honey"));
		System.out.println("Username empty: " + getUsername(null));

		System.out.println("Email: " + getEmail(null));

		try {
			System.out.println("Value: " + getValueOrThrow(null));
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}

		System.out.println("Uppercase: " + toUpperCase("hello").orElse("N/A"));

		System.out.println("Multiply present: " + multiplyIfPresent(Optional.of(5)));
		System.out.println("Multiply empty: " + multiplyIfPresent(Optional.empty()));

		List<Student> students = Arrays.asList(new Student(1, "Alice"), new Student(2, "Bob"));
		Optional<Student> student = findStudentById(1, students);
		student.ifPresent(System.out::println);
	}
}
