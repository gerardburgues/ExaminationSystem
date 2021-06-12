package com.SSD.SSD;


import com.SSD.SSD.repos.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
/**
@SpringBootApplication
public class SsdApplication {

	public static void main(String[] args) {
		SpringApplication.run(SsdApplication.class, args);
	}


}
**/
import org.springframework.boot.SpringApplication;
		import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackageClasses = UserRepository.class)
@SpringBootApplication
public class SsdApplication {

	public static void main(String[] args) throws Throwable {
		SpringApplication.run(SsdApplication.class, args);
	}

}