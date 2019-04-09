package dev.codenation.gestaohospital.hospital;

import org.springframework.data.geo.Distance;
import org.springframework.data.geo.GeoResults;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Repository;

import dev.codenation.gestaohospital.padrao.GestaoHospitalRepository;

@Repository
public interface HospitalRepository extends GestaoHospitalRepository<Hospital, String> {
	
	// No metric: {'geoNear' : 'person', 'near' : [x, y], maxDistance : distance }
	// Metric: {'geoNear' : 'person', 'near' : [x, y], 'maxDistance' : distance,
	//          'distanceMultiplier' : metric.multiplier, 'spherical' : true }
	GeoResults<Hospital> findByLocationNear(Point endereco, Distance distance);

//	@Query(value = "{ 'id' : ?0 }", fields = "{ 'estoque' : 1, '_id' : 0 }")
//	List<Estoque> listarEstoque(String id);
	
//	@Query(value = "{ 'id' : ?0 }", fields = "{ 'estoque' : 1, '_id' : 0 }")
//	Estoque listarHEstoque(String id);
	
}
 