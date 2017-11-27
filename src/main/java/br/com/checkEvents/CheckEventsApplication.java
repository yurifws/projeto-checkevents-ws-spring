package br.com.checkEvents;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@Configuration
//@EntityScan(basePackages = "br.com.novaroma.model")
//@EnableJpaRepositories("br.com.novaroma.dao")
public class CheckEventsApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(CheckEventsApplication.class, args);
	}
	
}
