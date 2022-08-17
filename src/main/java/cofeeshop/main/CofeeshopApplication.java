package cofeeshop.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("cofeeshop.main.repository")
public class CofeeshopApplication {

	public static void main(String[] args) {
		SpringApplication.run(CofeeshopApplication.class, args);
	}

}
