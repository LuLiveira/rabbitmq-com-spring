## RabbitMQ com Spring Boot

### Aula 4 - Configurando `application.yml`

- Para conectar nossa aplicação com o RabbitMQ precisamos primeiramente declarar algumas propriedades no nosso arquivo `application.yml`

`````properties
spring:
  rabbitmq:
    host: localhost
    port: 5672
    username: guest
    password: guest
`````

Também precisamos informar `exchange` e `routing-key`

```properties
exchange:
  producer: ex.producer.spring
routing-key:
  producer: qeue.producer.spring
deadletter:
  producer: dl.producer.spring
```