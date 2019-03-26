package dev.codenation.gestaohospital.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.codenation.gestaohospital.documents.Hospital;
import dev.codenation.gestaohospital.services.HospitalService;

@RestController
@RequestMapping(value = "/v1/hospitais", produces = "application/hal+json")
public class HospitalController {
	
	@Autowired
	private HospitalService service;
	
	/*@GetMapping
	public ResponseEntity<Resources<HospitalResource>> pesquisar(Pageable pageable, PagedResourcesAssembler<Hospital> assembler) {
		
		List<HospitalResource> collection = service.pesquisar(pageable).stream().map(HospitalResource::new).collect(Collectors.toList());
		final Resources<HospitalResource> resources = new Resources<>(collection);
		final String uriString = ServletUriComponentsBuilder.fromCurrentRequest().build().toUriString();
		resources.add(new Link(uriString, "self"));
		return ResponseEntity.ok(resources);
	}*/
	
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
