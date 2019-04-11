package dev.codenation.gestaohospital.hospital;

import dev.codenation.gestaohospital.padrao.GestaoHospitalResource;

public class HospitalResource implements GestaoHospitalResource {

	private String id;
	private String nome;
	private Integer quantidadeLeitos;
	private Integer leitosDisponiveis;
	private double [] location;
//	private List<Estoque> estoque;

	public HospitalResource() {
		super();
	}

	public HospitalResource(String id, String nome, Integer quantidadeLeitos, Integer leitosDisponiveis, double [] location) {
		super();
		this.id = id;
		this.nome = nome;
		this.quantidadeLeitos = quantidadeLeitos;
		this.leitosDisponiveis = leitosDisponiveis;
		this.location = location;
	}

	public String getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public Integer getQuantidadeLeitos() {
		return quantidadeLeitos;
	}

	public Integer getLeitosDisponiveis() {
		return leitosDisponiveis;
	}

	public double [] getLocation() {
		return location;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static class Builder {
		private String id;
		private String nome;
		private Integer quantidadeLeitos;
		private Integer leitosDisponiveis;
		private double [] location;
		
		public Builder comId(String id) {
			this.id = id;
			return this;
		}
		
		public Builder comNome(String nome) {
			this.nome = nome;
			return this;
		}
		
		public Builder comQuantidadeLeitos(Integer quantidadeLeitos) {
			this.quantidadeLeitos = quantidadeLeitos;
			return this;
		}
		
		public Builder comLeitosDisponiveis(Integer leitosDisponiveis) {
			this.leitosDisponiveis = leitosDisponiveis;
			return this;
		}
		
		public Builder comLocation(double [] location) {
			this.location = location;
			return this;
		}
		
		public HospitalResource build() {
			return new HospitalResource(id, nome, quantidadeLeitos, leitosDisponiveis, location);
		}
	}

}
