package dev.codenation.gestaohospital.leito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LeitoService {

    @Autowired
    private LeitoRepository repository;

    public Leito cadastrar(Leito leito) {
        return repository.insert(leito);
    }
    public Optional<Leito> obterPorId(String id) {
        return repository.findById(id);
    }
    public Page<Leito> pesquisar(Pageable pageable) {
        return repository.findAll(pageable);
    }
    public Leito atualizar(Leito leito) {
        return repository.save(leito);
    }
}
