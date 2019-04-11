package dev.codenation.gestaohospital.paciente;

import dev.codenation.gestaohospital.padrao.GestaoHospitalRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends GestaoHospitalRepository<Paciente,String> {

}
