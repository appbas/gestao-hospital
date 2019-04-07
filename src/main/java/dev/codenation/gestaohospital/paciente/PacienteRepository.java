package dev.codenation.gestaohospital.paciente;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

@Repository
public interface PacienteRepository extends MongoRepository<Paciente,String>  {

}
