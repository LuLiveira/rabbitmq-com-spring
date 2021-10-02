package dev.lucas.amqp;

public interface AmqpProducer<T> {
    void producer(T t);
}
