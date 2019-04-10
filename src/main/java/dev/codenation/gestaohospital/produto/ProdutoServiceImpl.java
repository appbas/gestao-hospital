package dev.codenation.gestaohospital.produto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.codenation.gestaohospital.padrao.GestaoHospitalServiceImpl;

@Service
public class ProdutoServiceImpl extends GestaoHospitalServiceImpl<Produto, String> implements ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;

	@Override
	protected ProdutoRepository getRepository() {
		return produtoRepository;
	}
	
}
