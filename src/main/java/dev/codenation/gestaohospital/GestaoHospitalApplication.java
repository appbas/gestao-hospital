package dev.codenation.gestaohospital;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GestaoHospitalApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestaoHospitalApplication.class, args);
	}
	
//	@Bean
//	public CascadingMongoEventListener<BaseDocument<?>> cascadingMongoEventListener() {
//		return new CascadingMongoEventListener<>();
//	}
	
}
