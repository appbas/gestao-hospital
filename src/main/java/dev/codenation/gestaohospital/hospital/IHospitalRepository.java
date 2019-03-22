package dev.codenation.gestaohospital.hospital;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IHospitalRepository extends MongoRepository<Hospital, String> {
	
}
