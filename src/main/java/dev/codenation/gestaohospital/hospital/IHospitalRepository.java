package dev.codenation.gestaohospital.hospital;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface IHospitalRepository extends MongoRepository<Hospital, String> {

}
