package dev.codenation.gestaohospital.estoque;

import org.springframework.data.mongodb.core.mapping.DBRef;

import dev.codenation.gestaohospital.produto.Produto;

public class Estoque {

	@DBRef
	private Produto produto;
	private TipoQuantidadeEnum tipoQuantidade;
	private Integer quantidade;

	public Estoque() {
		super();
	}
	
	public Estoque(Produto produto, TipoQuantidadeEnum tipoQuantidade, Integer quantidade) {
		this.produto = produto;
		this.tipoQuantidade = tipoQuantidade;
		this.quantidade = quantidade;
	}

	public Produto getProduto() {
		return produto;
	}

	public TipoQuantidadeEnum getTipoQuantidade() {
		return tipoQuantidade;
	}

	public Integer getQuantidade() {
		return quantidade;
	}
	
}
