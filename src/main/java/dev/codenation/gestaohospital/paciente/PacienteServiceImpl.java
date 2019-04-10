package dev.codenation.gestaohospital.paciente;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.codenation.gestaohospital.padrao.GestaoHospitalServiceImpl;

@Service
public class PacienteServiceImpl extends GestaoHospitalServiceImpl<Paciente, String> implements PacienteService {

    @Autowired
    private PacienteRepository repository;

    public List<Paciente> obterPorNome(String nome) {
        return repository.findAll().stream().filter(x->x.getNomeCompleto().contains(nome)).collect(Collectors.toList());
    }
    
    public List<Paciente> obterPorCpf(String cpf) {
        return repository.findAll().stream().filter(x->x.getCPF().contains(cpf)).collect(Collectors.toList());
    }
    
	@Override
	protected PacienteRepository getRepository() {
		return repository;
	}
}
