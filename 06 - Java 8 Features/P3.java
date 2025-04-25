package q;

import java.util.*;
import java.util.stream.Collectors;

class Book {
    String title;
    String author;
    String genre;
    double rating;

    Book(String title, String author, String genre, double rating) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.rating = rating;
    }
}

class BookRecommendation {
    String title;
    double rating;

    BookRecommendation(String title, double rating) {
        this.title = title;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Rating: " + rating;
    }
}

public class P3 {
    public static void main(String[] args) {
        List<Book> books = Arrays.asList(
            new Book("Dune", "Frank Herbert", "Science Fiction", 4.5),
            new Book("The Martian", "Andy Weir", "Science Fiction", 4.9),
            new Book("1984", "George Orwell", "Dystopian", 4.2),
            new Book("Hyperion", "Dan Simmons", "Science Fiction", 4.3),
            new Book("Foundation", "Isaac Asimov", "Science Fiction", 4.7)
        );

        List<BookRecommendation> recommendations = books.stream()
            .filter(b -> b.genre.equals("Science Fiction") && b.rating > 4.0)
            .map(b -> new BookRecommendation(b.title, b.rating))
            .sorted((b1, b2) -> Double.compare(b2.rating, b1.rating))
            .collect(Collectors.toList());

        int page = 1;
        int pageSize = 5;
        int startIndex = (page - 1) * pageSize;
        int endIndex = Math.min(startIndex + pageSize, recommendations.size());

        recommendations.subList(startIndex, endIndex).forEach(System.out::println);
    }
}
