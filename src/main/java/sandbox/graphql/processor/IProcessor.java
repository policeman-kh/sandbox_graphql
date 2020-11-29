package sandbox.graphql.processor;

import org.reactivestreams.Publisher;

public interface IProcessor<T> {
    Publisher<T> publish();

    void emit(T t);
}
