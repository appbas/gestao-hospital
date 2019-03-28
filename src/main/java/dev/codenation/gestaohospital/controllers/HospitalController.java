package dev.codenation.gestaohospital.controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.geo.GeoResults;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import dev.codenation.gestaohospital.documents.Hospital;
import dev.codenation.gestaohospital.resources.HospitalResource;
import dev.codenation.gestaohospital.services.HospitalService;

@RestController
@RequestMapping(value = "/v1/hospitais")
public class HospitalController {

	@Autowired
	private HospitalService service;

	@GetMapping(produces = "application/hal+json")
	public ResponseEntity<Resources<HospitalResource>> pesquisar(Pageable pageable,
			PagedResourcesAssembler<Hospital> assembler) {

		List<HospitalResource> collection = service.pesquisar(pageable).stream().map(HospitalResource::new)
				.collect(Collectors.toList());
		final Resources<HospitalResource> resources = new Resources<>(collection);
		final String uriString = ServletUriComponentsBuilder.fromCurrentRequest().build().toUriString();
		resources.add(new Link(uriString, "self"));
		return ResponseEntity.ok(resources);
	}

	@GetMapping(value = "/localizar")
	public ResponseEntity<GeoResults<Hospital>> obterHospitaisProximo(@RequestParam("lon") double longitude,
			@RequestParam("lat") double latitude, @RequestParam("distancia") double distancia) {

		Optional.of(longitude).filter(d -> d > 0)
				.orElseThrow(() -> new IllegalArgumentException("Distância não pode ser negativa"));
		
		return ResponseEntity.ok(service.localizar(longitude, latitude, distancia));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Hospital> obterPorId(@PathVariable(name = "id") String id) {
		return ResponseEntity.ok(service.obterPorId(id).orElse(null));
	}
	
	@PostMapping
	public ResponseEntity<Hospital> cadastrar(@RequestBody Hospital hospital) {
		service.cadastrar(hospital);
		return new ResponseEntity<>(hospital, HttpStatus.OK);
	}
	
	
	
}
