package dev.codenation.gestaohospital.tipoproduto;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import dev.codenation.gestaohospital.padrao.BaseDocument;

@Document(collection = "tiposProdutos")
public class TipoProduto extends BaseDocument<String> {

	@Id
	private String id;
	private String descricao;
	
	public TipoProduto() {
		super();
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

	public String getId() {
		return id;
	}

}
