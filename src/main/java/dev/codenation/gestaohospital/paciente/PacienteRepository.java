package dev.codenation.gestaohospital.paciente;

import org.springframework.stereotype.Repository;

import dev.codenation.gestaohospital.padrao.GestaoHospitalRepository;

@Repository
public interface PacienteRepository extends GestaoHospitalRepository<Paciente,String>  {

}
