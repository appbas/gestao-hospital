package dev.codenation.gestaohospital.hospital;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.GeoResults;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;

import dev.codenation.gestaohospital.estoque.Estoque;
import dev.codenation.gestaohospital.padrao.GestaoHospitalServiceImpl;


public class HospitalServiceImpl extends GestaoHospitalServiceImpl<Hospital, String> implements HospitalService {

	@Autowired
	private HospitalRepository repository;

	@Override
	public GeoResults<Hospital> localizar(double longitude, double latitude, double distancia) {
		return repository.findByLocationNear(new Point(longitude, latitude), new Distance(distancia, Metrics.KILOMETERS));
	}

	@Override
	public List<Estoque> listarEstoque(String id) {
		return repository.findById(id).map(Hospital::getEstoque).orElse(Collections.emptyList());
	}
	
	@Override
	protected HospitalRepository getRepository() {
		return repository;
	}
	
}
