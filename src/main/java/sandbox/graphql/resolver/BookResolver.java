package sandbox.graphql.resolver;

import java.util.List;

import org.springframework.stereotype.Component;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.AllArgsConstructor;
import sandbox.graphql.DataService;
import sandbox.graphql.model.Book;

@AllArgsConstructor
@Component
public class BookResolver implements GraphQLQueryResolver, GraphQLMutationResolver {
    private final DataService dataService;

    public List<Book> books() {
        return dataService.books();
    }

    public Book bookById(String bookId) {
        return dataService.bookById(bookId);
    }

    public Book registerBook(String id, String name, int pageCount, String authorId) {
        final Book book = new Book(id, name, pageCount,
                                   DataService.authorById(authorId, dataService.authors()));
        dataService.books().add(book);
        return book;
    }
}
