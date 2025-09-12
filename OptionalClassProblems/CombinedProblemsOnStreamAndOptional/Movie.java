package OptionalClassProblems.CombinedProblemsOnStreamAndOptional;

class Movie {
	private int id;
	private String title;
	private double rating;
	private String genre;

	public Movie(int id, String title, double rating, String genre) {
		this.id = id;
		this.title = title;
		this.rating = rating;
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "Movie{id=" + id + ", title='" + title + "', rating=" + rating + ", genre='" + genre + "'}";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

}
