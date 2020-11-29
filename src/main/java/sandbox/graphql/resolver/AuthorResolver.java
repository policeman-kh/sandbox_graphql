package sandbox.graphql.resolver;

import java.util.List;

import org.springframework.stereotype.Component;

import graphql.kickstart.tools.GraphQLResolver;
import lombok.AllArgsConstructor;
import sandbox.graphql.data.DataProvider;
import sandbox.graphql.model.Author;
import sandbox.graphql.model.Book;

@AllArgsConstructor
@Component
public class AuthorResolver implements GraphQLResolver<Author> {
    private final DataProvider dataProvider;

    public List<Book> books(Author author) {
        return dataProvider.booksByAuthorId(author.getId());
    }
}
