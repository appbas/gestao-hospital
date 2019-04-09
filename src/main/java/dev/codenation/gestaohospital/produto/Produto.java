package dev.codenation.gestaohospital.produto;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import dev.codenation.gestaohospital.padrao.BaseDocument;
import dev.codenation.gestaohospital.tipoproduto.TipoProduto;

@Document(collection = "produtos")
public class Produto extends BaseDocument<String> {

	@Id
	private String id;
	private String nome;
	private String descricao;
	@DBRef
	private TipoProduto tipoProduto;
	
	public Produto() {
		super();
	}
	
	public Produto(TipoProduto tipoProduto) {
		this.tipoProduto = tipoProduto;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public TipoProduto getTipoProduto() {
		return tipoProduto;
	}

	public String getId() {
		return id;
	}
}
