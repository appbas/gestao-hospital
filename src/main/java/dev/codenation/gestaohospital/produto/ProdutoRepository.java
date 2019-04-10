package dev.codenation.gestaohospital.produto;

import dev.codenation.gestaohospital.padrao.GestaoHospitalRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends GestaoHospitalRepository<Produto, String> {

}
