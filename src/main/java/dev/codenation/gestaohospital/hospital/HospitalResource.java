package dev.codenation.gestaohospital.hospital;

import java.util.List;

import dev.codenation.gestaohospital.estoque.Estoque;
import dev.codenation.gestaohospital.leito.Leito;
import dev.codenation.gestaohospital.padrao.GestaoHospitalResource;

public class HospitalResource implements GestaoHospitalResource {

	private String id;
	private String nome;
	private Integer quantidadeLeitos;
	private Integer leitosDisponiveis;
	private double [] location;
	private List<Estoque> estoque;
	private List<Leito> leitos;

	public HospitalResource() {
		super();
	}

	public HospitalResource(String id, String nome, Integer quantidadeLeitos, Integer leitosDisponiveis, double [] location, List<Estoque> estoque, List<Leito> leitos) {
		super();
		this.id = id;
		this.nome = nome;
		this.quantidadeLeitos = quantidadeLeitos;
		this.leitosDisponiveis = leitosDisponiveis;
		this.location = location;
		this.estoque = estoque;
		this.leitos = leitos;
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
	
	public List<Estoque> getEstoque() {
		return estoque;
	}

	public List<Leito> getLeitos() {
		return leitos;
	}

	public static class Builder {
		private String id;
		private String nome;
		private Integer quantidadeLeitos;
		private Integer leitosDisponiveis;
		private double [] location;
		private List<Estoque> estoque;
		private List<Leito> leitos;
		
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
		
		public Builder comEstoque(List<Estoque> estoque) {
			this.estoque = estoque;
			return this;
		}
		
		public Builder comLeitos(List<Leito> leitos) {
			this.leitos = leitos;
			return this;
		}
		
		
		
		public HospitalResource build() {
			return new HospitalResource(id, nome, quantidadeLeitos, leitosDisponiveis, location, estoque, leitos);
		}
	}

}
