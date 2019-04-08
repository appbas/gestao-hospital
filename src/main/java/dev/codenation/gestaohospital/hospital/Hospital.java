package dev.codenation.gestaohospital.hospital;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Indexed;

import dev.codenation.gestaohospital.documents.BaseDocument;
import dev.codenation.gestaohospital.estoque.Estoque;

@Document(collection = "hospitais")
public class Hospital extends BaseDocument<String> {

	@Id
	private String id;
	private String nome;
	private Integer leitos;
	private Integer leitosDisponiveis;
	@GeoSpatialIndexed
	private Point location;
	private List<Estoque> estoque;

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

	public Point getLocation() {
		return location;
	}

	public void setLocation(Point location) {
		this.location = location;
	}

	public List<Estoque> getEstoque() {
		return estoque;
	}

	public void setEstoque(List<Estoque> estoque) {
		this.estoque = estoque;
	}

}
