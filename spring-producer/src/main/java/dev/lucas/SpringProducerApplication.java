package dev.lucas;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringProducerApplication.class, args);
	}

}
