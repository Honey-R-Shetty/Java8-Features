package OptionalClassProblems.CombinedProblemsOnStreamAndOptional;

import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.stream.Collectors;
import static org.junit.jupiter.api.Assertions.*;

public class LibraryManagementTest {
	List<Book> books = Arrays.asList(new Book(1, "Java Basics", "John Doe", 450),
			new Book(2, "Advanced Java", "Jane Roe", 600), new Book(3, "Spring Framework", "John Doe", 750),
			new Book(4, "Hibernate", "Mary Major", 550));

	@Test
	public void testBooksFilteredAndSorted() {
		List<Book> result = books.stream()
				.filter(p -> p.price > 500)
				.sorted(Comparator.comparingDouble(p -> p.price))
				.collect(Collectors.toList());
		assertEquals(3, result.size());
		assertTrue(result.get(0).price > 500);
		assertTrue(result.get(1).price > 500);
	}

	@Test
	public void testUniqueAuthors() {
		Set<String> author = books.stream()
				.map(a -> a.author)
				.collect(Collectors.toSet());
		assertEquals(3, author.size());
	}

	@Test
	public void testMostExpensiveBook() {
		Optional<Book> bookPrice = books.stream()
				.max(Comparator.comparingDouble(p -> p.price));
		assertTrue(bookPrice.isPresent());
		assertEquals(750, bookPrice.get().price);
	}

	@Test
	public void testEmptyBookList() {
		List<Book> empty = new ArrayList<>();
		Optional<Book> expensive = empty.stream()
				.max(Comparator.comparingDouble(b -> b.price));
		assertFalse(expensive.isPresent());
	}
}
