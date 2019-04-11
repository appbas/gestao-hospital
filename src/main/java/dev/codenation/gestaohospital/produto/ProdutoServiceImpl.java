package dev.codenation.gestaohospital.produto;

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
public class ProdutoServiceImpl implements ProdutoService {
	
	private final Function<? super Produto, ? extends ProdutoResource> MAPPER = objeto -> ProdutoResource.builder()
			.comDescricao(objeto.getDescricao()).comId(objeto.getId()).comNome(objeto.getNome())
			.comTipoProduto(objeto.getTipoProduto()).build();
	
	@Autowired
	private ProdutoRepository produtoRepository;

	protected ProdutoRepository getRepository() {
		return produtoRepository;
	}

	@Override
	public List<ProdutoResource> listar() {
		return getRepository().findAll().stream().map(MAPPER).collect(Collectors.toList());
	}

	@Override
	public Paginacao<ProdutoResource> pesquisar(Paginacao<ProdutoResource> paginacao) {

		Pageable pageable = PageRequest.of(paginacao.getPagina(), paginacao.getTamanhoPagina());
		Page<Produto> find = getRepository().findAll(pageable);
		paginacao.setTotalRegistros(find.getTotalElements());
		paginacao.setResultado(find.getContent().stream().map(MAPPER).collect(Collectors.toList()));

		return paginacao;
	}

	@Override
	public ProdutoResource cadastrar(Produto objeto) {
		return MAPPER.apply(getRepository().insert(objeto));
	}

	@Override
	public ProdutoResource alterar(Produto objeto) {
		return MAPPER.apply(getRepository().save(objeto));
	}

	@Override
	public Optional<ProdutoResource> obterPorId(String id) {
		return getRepository().findById(id).map(MAPPER);
	}

	@Override
	public void excluir(String id) {
		getRepository().deleteById(id);
	}
	
}
