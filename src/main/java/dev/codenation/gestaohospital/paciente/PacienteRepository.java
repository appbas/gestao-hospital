package dev.codenation.gestaohospital.paciente;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends MongoRepository<Paciente,String>  {

}
