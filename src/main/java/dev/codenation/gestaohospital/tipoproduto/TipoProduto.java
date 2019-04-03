package dev.codenation.gestaohospital.tipoproduto;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;

import dev.codenation.gestaohospital.documents.BaseDocument;

public class TipoProduto extends BaseDocument<Integer> {

	@Id
	@NotNull
	private Integer id;
	@NotNull
	private String descricao;
	
	public TipoProduto() {
		super();
	}
	public TipoProduto(Integer id) {
		this.id = id;
	}
	
	public TipoProduto(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getId() {
		return id;
	}

}
