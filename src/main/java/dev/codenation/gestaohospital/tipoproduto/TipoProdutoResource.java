package dev.codenation.gestaohospital.tipoproduto;

import dev.codenation.gestaohospital.padrao.GestaoHospitalResource;

public class TipoProdutoResource implements GestaoHospitalResource {

	private String id;
	private String descricao;

	public TipoProdutoResource() {
		super();
	}

	private TipoProdutoResource(Builder builder) {
		this.id = builder.id;
		this.descricao = builder.descricao;
	}

	public String getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static Builder builder() {
		return new Builder();
	}

	public static class Builder {
		private String id;
		private String descricao;

		public Builder comId(String id) {
			this.id = id;
			return this;
		}

		public Builder comDescricao(String descricao) {
			this.descricao = descricao;
			return this;
		}

		public TipoProdutoResource build() {
			return new TipoProdutoResource(this);
		}
	}
}
