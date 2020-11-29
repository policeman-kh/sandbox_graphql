package sandbox.graphql.resolver;

import java.util.List;

import org.springframework.stereotype.Component;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.AllArgsConstructor;
import sandbox.graphql.data.DataProvider;
import sandbox.graphql.model.Book;
import sandbox.graphql.processor.IBookProcessor;

@AllArgsConstructor
@Component
public class BookResolver implements GraphQLQueryResolver, GraphQLMutationResolver {
    private final DataProvider dataProvider;
    private final IBookProcessor bookProcessor;

    public List<Book> books() {
        return dataProvider.books();
    }

    public Book bookById(String bookId) {
        return dataProvider.bookById(bookId);
    }

    public Book registerBook(String id, String name, int pageCount, String authorId) {
        final Book book = new Book(id, name, pageCount,
                                   dataProvider.authorById(authorId));
        dataProvider.books().add(book);

        bookProcessor.emit(book);
        return book;
    }
}
