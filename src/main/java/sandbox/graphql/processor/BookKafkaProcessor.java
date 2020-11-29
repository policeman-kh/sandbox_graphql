package sandbox.graphql.processor;

import org.reactivestreams.Publisher;

import sandbox.graphql.model.Book;

//TODO https://github.com/reactor/reactor-kafka/tree/master/reactor-kafka-samples
public class BookKafkaProcessor implements IBookProcessor {

    @Override
    public Publisher<Book> publish() {
        return null;
    }

    @Override
    public void emit(Book book) {

    }
}
