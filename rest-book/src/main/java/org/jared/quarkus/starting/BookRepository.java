package org.jared.quarkus.starting;

import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class BookRepository {

    @ConfigProperty(name = "books.genre", defaultValue = "Sci-Fi")
    String genre;

    public List<Book> getAllBooks() {
        return List.of(
                new Book(1, "Understanding Quarkus", "Antonio", 2020, genre),
                new Book(2, "Quarkus in Action", "Antonio", 2021, genre),
                new Book(3, "Quarkus for Java Developers", "Antonio", 2022, genre),
                new Book(4, "Quarkus for Spring Developers", "Antonio", 2023, genre),
                new Book(5, "Quarkus for Microservices", "Antonio", 2024, genre)
        );
    }

    public Optional<Book> getBook(Integer id) {
        return getAllBooks().stream()
                .filter(book -> book.id == id).findFirst();
    }

    public int countAllBooks() {
        return getAllBooks().size();
    }

}
