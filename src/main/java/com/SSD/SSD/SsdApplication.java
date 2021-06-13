package com.SSD.SSD;


import com.SSD.SSD.repos.UsersRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
@SpringBootApplication
public class SsdApplication {

	public static void main(String[] args) {
		SpringApplication.run(SsdApplication.class, args);
	}


}
**/
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackageClasses = UsersRepository.class)
@SpringBootApplication
public class SsdApplication {

	public static void main(String[] args) throws Throwable {
		SpringApplication.run(SsdApplication.class, args);
	}

}