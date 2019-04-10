package dev.codenation.gestaohospital.leito;

import dev.codenation.gestaohospital.padrao.GestaoHospitalRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeitoRepository extends GestaoHospitalRepository<Leito,String> {

}
