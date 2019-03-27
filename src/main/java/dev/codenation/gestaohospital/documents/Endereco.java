package dev.codenation.gestaohospital.documents;

import java.beans.Transient;

import org.springframework.data.mongodb.core.mapping.Field;

public class Endereco extends BaseDocument<String> {

	@Field("lon")
	private Double longitude;
	@Field("lat")
	private Double latitude;

	@Override
	@Transient
	public String getId() {
		throw new IllegalAccessError("Document não possui ID");
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

}
