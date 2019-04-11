package dev.codenation.gestaohospital.paciente;

import java.util.List;

import dev.codenation.gestaohospital.padrao.GestaoHospitalService;

public interface PacienteService extends GestaoHospitalService<Paciente, PacienteResource, String> {
	
	List<PacienteResource> obterPorNome(String nome);
	
	List<PacienteResource> obterPorCpf(String cpf);

}
