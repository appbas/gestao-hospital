package dev.codenation.gestaohospital.paciente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository repository;

    public Paciente cadastrar(Paciente paciente) {
        return repository.insert(paciente);
    }
    public Optional<Paciente> obterPorId(String id) {
        return repository.findById(id);
    }
    public List<Paciente> obterPorNome(String nome) {
        return repository.findAll().stream().filter(x->x.getNomeCompleto().contains(nome)).collect(Collectors.toList());
    }
    public List<Paciente> obterPorCpf(String cpf) {
        return repository.findAll().stream().filter(x->x.getCPF().contains(cpf)).collect(Collectors.toList());
    }
    public Page<Paciente> pesquisar(Pageable pageable) {
        return repository.findAll(pageable);
    }
    public Paciente atualizar(Paciente paciente) {
        return repository.save(paciente);
    }
    public void excluir(Paciente paciente) {
        repository.delete(paciente);
    }


}
