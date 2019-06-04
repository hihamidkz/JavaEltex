package ru.eltex.spring;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@ComponentScan
public class Application {
	static final Logger log = Logger.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		log.debug("Application started");	
	}
}
