package dev.codenation.gestaohospital.produto;

public class Produto {

	private String nome;
	private String descricao;
	private TipoProdutoEnum tipoProduto;
	
	public Produto() {
		super();
	}
	
	public Produto(TipoProdutoEnum tipoProduto) {
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

	public TipoProdutoEnum getTipoProduto() {
		return tipoProduto;
	}

}
