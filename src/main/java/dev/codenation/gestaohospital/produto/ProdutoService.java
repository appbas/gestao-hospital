package dev.codenation.gestaohospital.produto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public Produto cadastrar(Produto produto) {
		return produtoRepository.insert(produto);
	}
	
	public List<Produto> listar() {
		return produtoRepository.findAll();
	}

}
