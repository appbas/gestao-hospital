package dev.codenation.gestaohospital.hospital;

import java.util.List;

import javax.websocket.server.ServerEndpoint;

import org.springframework.data.geo.GeoResults;
import org.springframework.stereotype.Service;

import dev.codenation.gestaohospital.estoque.Estoque;
import dev.codenation.gestaohospital.padrao.GestaoHospitalService;

@Service
public interface HospitalService extends GestaoHospitalService<Hospital, String> {
	
	GeoResults<Hospital> localizar(double longitude, double latitude, double distancia);
	
	List<Estoque> listarEstoque(String id);

}
