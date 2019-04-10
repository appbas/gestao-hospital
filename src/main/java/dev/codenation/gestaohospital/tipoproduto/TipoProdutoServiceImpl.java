package dev.codenation.gestaohospital.tipoproduto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.codenation.gestaohospital.padrao.GestaoHospitalServiceImpl;

@Service
public class TipoProdutoServiceImpl extends GestaoHospitalServiceImpl<TipoProduto, String> implements TipoProdutoService {
	
	@Autowired
	private TipoProdutoRepository tipoProdutoRepository;

	@Override
	protected TipoProdutoRepository getRepository() {
		return tipoProdutoRepository;
	}

}
