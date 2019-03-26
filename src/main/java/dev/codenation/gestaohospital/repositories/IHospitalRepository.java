package dev.codenation.gestaohospital.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import dev.codenation.gestaohospital.documents.Hospital;

@Repository
public interface IHospitalRepository extends MongoRepository<Hospital, String> {
	
}
