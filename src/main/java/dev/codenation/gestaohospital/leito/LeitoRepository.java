package dev.codenation.gestaohospital.leito;

import dev.codenation.gestaohospital.paciente.Paciente;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.Date;

public interface LeitoRepository extends MongoRepository<Leito,String> {

}
