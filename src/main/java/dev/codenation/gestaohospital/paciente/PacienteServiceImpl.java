package dev.codenation.gestaohospital.paciente;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import dev.codenation.gestaohospital.padrao.Paginacao;

@Service
public class PacienteServiceImpl implements PacienteService {
	
	public static final Function<? super Paciente, ? extends PacienteResource> MAPPER = objeto -> PacienteResource.builder()
			.comCpf(objeto.getCpf()).comDataNascimento(objeto.getDataNascimento()).comGenero(objeto.getGenero())
			.comId(objeto.getId()).comNomeCompleto(objeto.getNomeCompleto()).build();

    @Autowired
    private PacienteRepository repository;
    
    protected PacienteRepository getRepository() {
		return repository;
	}

    public List<PacienteResource> obterPorNome(String nome) {
        return repository.findAll().stream().filter(x->x.getNomeCompleto().contains(nome)).map(MAPPER).collect(Collectors.toList());
    }
    
    public List<PacienteResource> obterPorCpf(String cpf) {
        return repository.findAll().stream().filter(x->x.getCpf().contains(cpf)).map(MAPPER).collect(Collectors.toList());
    }
    
	@Override
	public List<PacienteResource> listar() {
		return getRepository().findAll().stream().map(MAPPER).collect(Collectors.toList());
	}

	@Override
	public Paginacao<PacienteResource> pesquisar(Paginacao<PacienteResource> paginacao) {

		Pageable pageable = PageRequest.of(paginacao.getPagina(), paginacao.getTamanhoPagina());
		Page<Paciente> find = getRepository().findAll(pageable);
		paginacao.setTotalRegistros(find.getTotalElements());
		paginacao.setResultado(find.getContent().stream().map(MAPPER).collect(Collectors.toList()));

		return paginacao;
	}

	@Override
	public PacienteResource cadastrar(Paciente objeto) {
		return MAPPER.apply(getRepository().insert(objeto));
	}

	@Override
	public PacienteResource alterar(Paciente objeto) {
		return MAPPER.apply(getRepository().save(objeto));
	}

	@Override
	public Optional<PacienteResource> obterPorId(String id) {
		return getRepository().findById(id).map(MAPPER);
	}

	@Override
	public void excluir(String id) {
		getRepository().deleteById(id);		
	}
}
