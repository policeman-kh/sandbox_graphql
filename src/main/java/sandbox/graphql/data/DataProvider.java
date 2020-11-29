package sandbox.graphql.data;

import java.util.List;

import sandbox.graphql.model.Author;
import sandbox.graphql.model.Book;

public interface DataProvider {
    List<Book> books();

    List<Author> authors();

    List<Book> booksByAuthorId(String authorId);

    Book bookById(String bookId);

    Author authorById(String authorId);
}
