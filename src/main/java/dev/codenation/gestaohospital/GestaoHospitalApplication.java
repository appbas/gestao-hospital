package dev.codenation.gestaohospital;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import dev.codenation.gestaohospital.documents.BaseDocument;
import dev.codenation.gestaohospital.listeners.CascadingMongoEventListener;

@SpringBootApplication
public class GestaoHospitalApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestaoHospitalApplication.class, args);
	}
	
	@Bean
	public CascadingMongoEventListener<BaseDocument<?>> cascadingMongoEventListener() {
		return new CascadingMongoEventListener<>();
	}
	
}
