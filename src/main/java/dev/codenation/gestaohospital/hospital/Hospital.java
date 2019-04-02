package dev.codenation.gestaohospital.hospital;

import org.springframework.data.annotation.Id;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

import dev.codenation.gestaohospital.documents.BaseDocument;

@Document(collection = "hospitais")
public class Hospital extends BaseDocument<String> {

	@Id
	private String id;
	private String nome;
	private Integer leitos;
	private Integer leitosDisponiveis;
	@GeoSpatialIndexed
	private Point location;

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
	
}
