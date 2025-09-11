package OptionalClassProblems.CombinedProblemsOnStreamAndOptional;

class Book {
    int id;
    String title;
    String author;
    double price;

    public Book(int id, String title, String author, double price) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{id=" + id + ", title='" + title + "', author='" + author + "', price=" + price + "}";
    }
}
