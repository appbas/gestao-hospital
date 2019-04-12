package dev.codenation.gestaohospital.hospital;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

import dev.codenation.gestaohospital.estoque.Estoque;
import dev.codenation.gestaohospital.leito.Leito;
import dev.codenation.gestaohospital.padrao.BaseDocument;

@Document(collection = "hospitais")
public class Hospital extends BaseDocument<String> {

	@Id
	private String id;
	private String nome;
	private Integer quantidadeLeitos;
	private Integer leitosDisponiveis;
	@GeoSpatialIndexed
	private double[] location;
	private List<Estoque> estoque;
	private List<Leito> leitos;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getQuantidadeLeitos() {
		return quantidadeLeitos;
	}

	public void setQuantidadeLeitos(Integer quantidadeLeitos) {
		this.quantidadeLeitos = quantidadeLeitos;
	}

	public Integer getLeitosDisponiveis() {
		return leitosDisponiveis;
	}

	public void setLeitosDisponiveis(Integer leitosDisponiveis) {
		this.leitosDisponiveis = leitosDisponiveis;
	}

	public double[] getLocation() {
		return location;
	}

	public void setLocation(double[] location) {
		this.location = location;
	}

	public List<Estoque> getEstoque() {
		return estoque;
	}

	public void setEstoque(List<Estoque> estoque) {
		this.estoque = estoque;
	}

	public List<Leito> getLeitos() {
		return Optional.ofNullable(leitos).orElse(new ArrayList<>());
	}

	public void setLeitos(List<Leito> leitos) {
		this.leitos = leitos;
	}

	public String getId() {
		return id;
	}

}
