package dev.codenation.gestaohospital.produto;

import dev.codenation.gestaohospital.padrao.GestaoHospitalResource;
import dev.codenation.gestaohospital.tipoproduto.TipoProduto;

public class ProdutoResource implements GestaoHospitalResource {

	private String id;
	private String nome;
	private String descricao;
	private TipoProduto tipoProduto;

	public ProdutoResource() {
		super();
	}

	private ProdutoResource(Builder builder) {
		this.id = builder.id;
		this.nome = builder.nome;
		this.descricao = builder.descricao;
		this.tipoProduto = builder.tipoProduto;
	}

	public String getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public TipoProduto getTipoProduto() {
		return tipoProduto;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static class Builder {
		private String id;
		private String nome;
		private String descricao;
		private TipoProduto tipoProduto;

		public Builder comId(String id) {
			this.id = id;
			return this;
		}

		public Builder comNome(String nome) {
			this.nome = nome;
			return this;
		}

		public Builder comDescricao(String descricao) {
			this.descricao = descricao;
			return this;
		}

		public Builder comTipoProduto(TipoProduto tipoProduto) {
			this.tipoProduto = tipoProduto;
			return this;
		}

		public ProdutoResource build() {
			return new ProdutoResource(this);
		}
	}
}
