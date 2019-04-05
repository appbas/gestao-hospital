package dev.codenation.gestaohospital.estoque;

public enum TipoQuantidadeEnum {

	UNIDADE("Unidade"), LITROS("Listros"), METROS("Metros");

	private String descricao;

	private TipoQuantidadeEnum(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
