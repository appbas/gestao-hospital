package dev.codenation.gestaohospital.tipoproduto;

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
public class TipoProdutoServiceImpl implements TipoProdutoService {
	
	private final Function<? super TipoProduto, ? extends TipoProdutoResource> MAPPER = objeto -> TipoProdutoResource
			.builder().comDescricao(objeto.getDescricao()).comId(objeto.getId()).build();
	
	@Autowired
	private TipoProdutoRepository tipoProdutoRepository;

	protected TipoProdutoRepository getRepository() {
		return tipoProdutoRepository;
	}

	@Override
	public List<TipoProdutoResource> listar() {
		return getRepository().findAll().stream().map(MAPPER).collect(Collectors.toList());
	}

	public Paginacao<TipoProdutoResource> pesquisar(Paginacao<TipoProdutoResource> paginacao) {
		
		Pageable pageable = PageRequest.of(paginacao.getPagina(), paginacao.getTamanhoPagina());
		Page<TipoProduto> find = getRepository().findAll(pageable);
		paginacao.setTotalRegistros(find.getTotalElements());
		paginacao.setResultado(find.getContent().stream().map(MAPPER).collect(Collectors.toList()));

		return paginacao;
	}

	@Override
	public TipoProdutoResource cadastrar(TipoProduto objeto) {
		return MAPPER.apply(getRepository().insert(objeto));
	}

	@Override
	public TipoProdutoResource alterar(TipoProduto objeto) {
		return MAPPER.apply(getRepository().save(objeto));
	}

	@Override
	public Optional<TipoProdutoResource> obterPorId(String id) {
		return getRepository().findById(id).map(MAPPER);
	}

	@Override
	public void excluir(String id) {
		getRepository().deleteById(id);
	}

}
