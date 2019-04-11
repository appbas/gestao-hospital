package dev.codenation.gestaohospital.paciente;

import java.util.List;

import dev.codenation.gestaohospital.padrao.GestaoHospitalService;

public interface PacienteService extends GestaoHospitalService<Paciente, String> {
	
	List<Paciente> obterPorNome(String nome);
	
	List<Paciente> obterPorCpf(String cpf);

}
