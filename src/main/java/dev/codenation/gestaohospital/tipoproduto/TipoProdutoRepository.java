package dev.codenation.gestaohospital.tipoproduto;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoProdutoRepository extends MongoRepository<TipoProduto, String> {

}
