package dev.codenation.gestaohospital.leito;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeitoRepository extends MongoRepository<Leito,String> {

}
