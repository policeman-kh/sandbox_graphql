package sandbox.graphql.data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.jetbrains.annotations.Nullable;
import org.springframework.stereotype.Component;

import sandbox.graphql.model.Author;
import sandbox.graphql.model.Book;

@Component
public class ConstantDataProvider implements DataProvider {
    private final List<Book> books;
    private final List<Author> authors;

    public ConstantDataProvider() {
        authors = new ArrayList<>();
        authors.add(new Author("1", "Taro", "Yamada", null));
        authors.add(new Author("2", "Test1", "TestTest", null));
        authors.add(new Author("3", "ABC", "EFG", null));

        books = new ArrayList<>();
        books.add(new Book("1", "bookName1", 900, authorById("1", authors)));
        books.add(new Book("2", "bookName2", 100, authorById("2", authors)));
        books.add(new Book("3", "bookName3", 300, authorById("3", authors)));
        books.add(new Book("4", "bookName4", 1000, authorById("1", authors)));
    }

    public List<Book> books() {
        return books;
    }

    public List<Author> authors() {
        return authors;
    }

    public List<Book> booksByAuthorId(String authorId) {
        return books.stream()
                    .filter(book -> book.getAuthor().getId().equals(authorId))
                    .collect(Collectors.toList());
    }

    @Nullable
    public Book bookById(String bookId) {
        return books.stream()
                    .filter(book -> book.getId().equals(bookId))
                    .findFirst()
                    .orElse(null);
    }

    @Override
    public Author authorById(String authorId) {
        return authorById(authorId, authors);
    }

    @Nullable
    private static Author authorById(String authorId, List<Author> authors) {
        return authors.stream()
                      .filter(author -> author.getId().equals(authorId))
                      .findFirst()
                      .orElse(null);
    }
}
