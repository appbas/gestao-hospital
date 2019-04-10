package dev.codenation.gestaohospital.produto;

import dev.codenation.gestaohospital.padrao.GestaoHospitalRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends GestaoHospitalRepository<Produto, String> {

}
