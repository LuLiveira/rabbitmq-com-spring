package dev.lucas.service;

public interface ConsumerService<T> {
    void executar(T t);
}
