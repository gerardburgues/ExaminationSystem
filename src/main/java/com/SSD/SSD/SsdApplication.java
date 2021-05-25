package com.SSD.SSD;

import com.SSD.SSD.model.User;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SsdApplication {

	public static void main(String[] args) {
		SpringApplication.run(SsdApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(UserRepository userRepository){
		return args -> {
			User Joan = new User(

					123L,
					"Joan",
					"Jones",
					"maria.jones@gmail.com",
					"HelloPassword",
					123456L
			);
			userRepository.save(Joan);
		};
	}
}
