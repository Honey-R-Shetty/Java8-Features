package OptionalClassProblems.CombinedProblemsOnStreamAndOptional;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MovieRatings {
	 public static void main(String[] args) {
	        List<Movie> movies = Arrays.asList(
	            new Movie(1, "Action Blast", 9.0, "Action"),
	            new Movie(2, "Funny Times", 7.5, "Comedy"),
	            new Movie(3, "Hero Wars", 8.5, "Action"),
	            new Movie(4, "Laugh Riot", 8.0, "Comedy"),
	            new Movie(5, "Action Hero", 9.2, "Action")
	        );
	        
	        // all movies with rating > 8 and belonging to action
	        List<Movie> allMovie = movies.stream()
	        		.filter(m -> m.getRating()>8 && m.getGenre().equalsIgnoreCase("Action"))
	        		.collect(Collectors.toList());
	        System.out.println("Action movies with rating > 8: ");
	        allMovie.forEach(System.out::println);
	        
	        // Top 3 highest-rated movies.
	        System.out.println("\nTop 3 highest-rated movies : ");
	        movies.stream().sorted(Comparator.comparingDouble((Movie r) -> r.getRating()).reversed())
	        .limit(3)
	        .forEach(System.out::println);
	        
	        // At least one Comedy
	        Boolean isPresent = movies.stream().anyMatch(m -> m.getGenre().equalsIgnoreCase("comedy"));
	        System.out.println("\nIs there at least one Comedy movie? "+isPresent);
	        
	        //best rated movie
	        Optional<Movie> bestRatedMovie = movies.stream().max(Comparator.comparingDouble(m ->m.getRating()));
	        System.out.println("\nBest rated movie:");
	        bestRatedMovie.ifPresentOrElse(System.out::println,()->System.out.println("No movies found!!"));
	        	
	 }
}
