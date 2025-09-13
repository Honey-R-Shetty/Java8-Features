package OptionalClassProblems.CombinedProblemsOnStreamAndOptional;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;

public class MovieRatingsTest {
	private List<Movie> movies;

	@Before
	public void setUp() {
		movies = new ArrayList<>(Arrays.asList(new Movie(1, "Action Blast", 9.0, "Action"), new Movie(2, "Funny Times", 7.5, "Comedy"),
				new Movie(3, "Hero Wars", 8.5, "Action"), new Movie(4, "Laugh Riot", 8.0, "Comedy"),
				new Movie(5, "Action Hero", 9.2, "Action"), new Movie(6, "Action Ultra", 9.2, "Action")));
	}

	@Test
	public void testActionMovieWithRatingAbove8() {
		List<Movie> actionMovie = movies.stream()
				.filter(m -> m.getGenre().equalsIgnoreCase("action") && m.getRating() > 8).collect(Collectors.toList());
		assertEquals(4, actionMovie.size());
	}

	@Test
	public void testTop3RatedMOvie() {
		List<Movie> topMovie = movies.stream().sorted(Comparator.comparingDouble((Movie r) -> r.getRating()).reversed())
				.limit(3).collect(Collectors.toList());
		assertEquals(3, topMovie.size());
		assertTrue(topMovie.get(0).getRating() > 8);
	}

	@Test
	public void testComedyMovieExist() {
		Boolean check = movies.stream().anyMatch(g -> g.getGenre().equalsIgnoreCase("Comedy"));
		assertTrue(check);
	}

	@Test
	public void testHighestRatedMovie() {
		Optional<Movie> highest = movies.stream().max(Comparator.comparingDouble(m -> m.getRating()));
		assertTrue(highest.isPresent());
		assertEquals(9.2, highest.get().getRating(), 0.01);
	}

	@Test
	public void testHighestRatedEdgeCase() {
		List<Movie> highestRated = movies.stream().filter(m -> m.getRating() == 9.2).collect(Collectors.toList());
		assertEquals(2, highestRated.size());
	}

	@Test
	public void testEmptyMovieListReturnsEmptyOptional() {
		movies.clear();
		Optional<Movie> highest = movies.stream().max(Comparator.comparingDouble(Movie::getRating));
		assertFalse(highest.isPresent());
	}
}
