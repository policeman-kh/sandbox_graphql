package sandbox.graphql.resolver;

import org.reactivestreams.Publisher;
import org.springframework.stereotype.Component;

import graphql.kickstart.tools.GraphQLSubscriptionResolver;
import lombok.AllArgsConstructor;
import sandbox.graphql.model.Book;
import sandbox.graphql.processor.IBookProcessor;

@AllArgsConstructor
@Component
public class SubscriptionResolver implements GraphQLSubscriptionResolver {
    private final IBookProcessor bookProcessor;

    public Publisher<Book> subscribeBooks() {
        return bookProcessor.publish();
    }
}
