package dev.codenation.gestaohospital.hospital;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import dev.codenation.gestaohospital.model.Endereco;

@Document(collection = "hospitais")
public class Hospital {

	@Id
	private String id;
	private String nome;
	private Integer leitos;
	private Integer leitosDisponiveis;
	@DBRef(db="enderecos")
	private Endereco endereco;

	public String getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getLeitos() {
		return leitos;
	}

	public void setLeitos(Integer leitos) {
		this.leitos = leitos;
	}

	public Integer getLeitosDisponiveis() {
		return leitosDisponiveis;
	}

	public void setLeitosDisponiveis(Integer leitosDisponiveis) {
		this.leitosDisponiveis = leitosDisponiveis;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
}
