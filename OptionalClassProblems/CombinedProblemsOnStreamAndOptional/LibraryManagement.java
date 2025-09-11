package OptionalClassProblems.CombinedProblemsOnStreamAndOptional;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class LibraryManagement {
	public static void main(String[] args) {
		List<Book> books = Arrays.asList(new Book(1, "Java Basics", "John Doe", 450),
				new Book(2, "Advanced Java", "Jane Roe", 600), new Book(3, "Spring Framework", "John Doe", 750),
				new Book(4, "Hibernate", "Mary Major", 550));

		// Find books priced above 500 and sort
		System.out.println("Books > 500 sorted by price:");
		books.stream().filter(b -> b.price > 500).sorted(Comparator.comparingDouble(b -> b.price))
				.forEach(System.out::println);

		// Unique authors
		Set<String> uniqueAuthor = books.stream().map(b -> b.author).collect(Collectors.toSet());
		System.out.println("\nUnique authors: " + uniqueAuthor);

		// Most expensive book
		Optional<Book> maxPrice = books.stream()
				.max(Comparator.comparingDouble(b -> b.price));
		System.out.println("\nMost expensive book:");
		maxPrice.ifPresentOrElse(System.out::println,
				()->System.out.println("\"No books available\""));

	}
}
