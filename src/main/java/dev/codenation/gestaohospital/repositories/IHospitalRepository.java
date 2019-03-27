package dev.codenation.gestaohospital.repositories;

import org.springframework.data.geo.Distance;
import org.springframework.data.geo.GeoResults;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import dev.codenation.gestaohospital.documents.Hospital;

@Repository
public interface IHospitalRepository extends MongoRepository<Hospital, String> {
	
	// No metric: {'geoNear' : 'person', 'near' : [x, y], maxDistance : distance }
	// Metric: {'geoNear' : 'person', 'near' : [x, y], 'maxDistance' : distance,
	//          'distanceMultiplier' : metric.multiplier, 'spherical' : true }
	GeoResults<Hospital> findByLocationNear(Point location, Distance distance);
	
}
