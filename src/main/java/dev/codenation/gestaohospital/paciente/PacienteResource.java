package dev.codenation.gestaohospital.paciente;


import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import dev.codenation.gestaohospital.padrao.GestaoHospitalResource;

public class PacienteResource implements GestaoHospitalResource {

	private String id;
	private String cpf;
	private String nomeCompleto;
	private Genero genero;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date dataNascimento;

	public PacienteResource() {
		super();
	}

	public PacienteResource(String id, String cpf, String nomeCompleto, Genero genero, Date dataNascimento) {
		super();
		this.id = id;
		this.cpf = cpf;
		this.nomeCompleto = nomeCompleto;
		this.genero = genero;
		this.dataNascimento = dataNascimento;
	}

	public String getId() {
		return id;
	}

	public String getCpf() {
		return cpf;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public Genero getGenero() {
		return genero;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static class Builder {
		
		private String id;
		private String cpf;
		private String nomeCompleto;
		private Genero genero;
		private Date dataNascimento;
		
		public Builder comId(String id) {
			this.id = id;
			return this;
		}
		
		public Builder comCpf(String cpf) {
			this.cpf = cpf;
			return this;
		}
		
		
		public Builder comNomeCompleto(String nomeCompleto) {
			this.nomeCompleto = nomeCompleto;
			return this;
		}
		
		public Builder comGenero(Genero genero) {
			this.genero = genero;
			return this;
		}
		
		public Builder comDataNascimento(Date dataNascimento) {
			this.dataNascimento = dataNascimento;
			return this;
		}
		
		public PacienteResource build() {
			return new PacienteResource(id, cpf, nomeCompleto, genero, dataNascimento);
		}
	}
}
