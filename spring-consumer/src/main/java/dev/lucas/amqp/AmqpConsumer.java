package dev.lucas.amqp;

public interface AmqpConsumer<T> {
    void consume(T t);
}
