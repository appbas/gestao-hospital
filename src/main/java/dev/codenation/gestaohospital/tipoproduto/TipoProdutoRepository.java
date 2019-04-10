package dev.codenation.gestaohospital.tipoproduto;

import dev.codenation.gestaohospital.padrao.GestaoHospitalRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoProdutoRepository extends GestaoHospitalRepository<TipoProduto, String> {

}
