package dev.codenation.gestaohospital.leito;

import org.springframework.stereotype.Repository;

import dev.codenation.gestaohospital.padrao.GestaoHospitalRepository;

@Repository
public interface LeitoRepository extends GestaoHospitalRepository<Leito,String> {

}
