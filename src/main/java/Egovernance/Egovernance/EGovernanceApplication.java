package Egovernance.Egovernance;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EGovernanceApplication {
    @PostConstruct
	public void startupApplication() {
		System.out.println ("Swagger URL: http://localhost:8080/swagger-ui/index.html");
		System.out.println ("Database URL: http://localhost:8080/h2-console");

	}
	public static void main(String[] args) {
		SpringApplication.run(EGovernanceApplication.class, args);
	}

}
