package co.gov.sic.tramites;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAutoConfiguration
@EnableJpaRepositories("co.gov.sic.tramites.*" )
@ComponentScan(basePackages = { "co.gov.sic.tramites.*" })
@EntityScan("co.gov.sic.tramites.*")  
public class PruebaSicBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(PruebaSicBackendApplication.class, args);
	}

}
