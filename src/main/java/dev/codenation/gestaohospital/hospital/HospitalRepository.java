package dev.codenation.gestaohospital.hospital;

import org.springframework.data.geo.Distance;
import org.springframework.data.geo.GeoResults;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalRepository extends MongoRepository<Hospital, String> {
	
	// No metric: {'geoNear' : 'person', 'near' : [x, y], maxDistance : distance }
	// Metric: {'geoNear' : 'person', 'near' : [x, y], 'maxDistance' : distance,
	//          'distanceMultiplier' : metric.multiplier, 'spherical' : true }
	GeoResults<Hospital> findByLocationNear(Point endereco, Distance distance);
	
}
