package dev.codenation.gestaohospital;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GestaoHospitalApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestaoHospitalApplication.class, args);
	}
	
	/*@Bean
    CommandLineRunner init(IHospitalRepository domainRepository) {

        return args -> {
        	
        	Hospital hospital = new Hospital();
        	hospital.setNome("Hospital do Coração");
			domainRepository.insert(hospital);

            Optional<Hospital> obj = domainRepository.findById("5c8c495c4ee4cf23106d0d42");
            System.out.println(obj);


        };

    }*/


}
