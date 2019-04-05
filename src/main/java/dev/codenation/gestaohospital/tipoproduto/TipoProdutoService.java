package dev.codenation.gestaohospital.tipoproduto;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoProdutoService {
	
	@Autowired
	private TipoProdutoRepository tipoProdutoRepository;
	
	public List<TipoProduto> listar() {
		return tipoProdutoRepository.findAll();
	}
	
	public Optional<TipoProduto> obterPorId(String id) {
		return tipoProdutoRepository.findById(id);
	}
	
	public TipoProduto cadastrar(TipoProduto tipoProduto) {
		return tipoProdutoRepository.insert(tipoProduto);
	}

}
