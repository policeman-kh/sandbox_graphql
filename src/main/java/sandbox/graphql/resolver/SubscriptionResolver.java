package sandbox.graphql.resolver;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.springframework.stereotype.Component;

import graphql.kickstart.tools.GraphQLSubscriptionResolver;
import sandbox.graphql.model.Book;

@Component
public class SubscriptionResolver implements GraphQLSubscriptionResolver {
    BookPublisher bookPublisher = new BookPublisher();
    
    public Publisher<Book> subscribeBooks() {
        return bookPublisher;
    }

    public class BookPublisher implements Publisher<Book> {

        @Override
        public void subscribe(Subscriber<? super Book> s) {

        }
    }

    public class BookSubscriber implements Subscriber<Book> {
        private Subscription subscription;

        @Override
        public void onSubscribe(Subscription s) {
            subscription = s;
        }

        @Override
        public void onNext(Book book) {
            //subscription.
        }

        @Override
        public void onError(Throwable t) {

        }

        @Override
        public void onComplete() {

        }
    }
}
