package dev.codenation.gestaohospital.produto;

import org.springframework.stereotype.Repository;

import dev.codenation.gestaohospital.padrao.GestaoHospitalRepository;

@Repository
public interface ProdutoRepository extends GestaoHospitalRepository<Produto, String> {

}
