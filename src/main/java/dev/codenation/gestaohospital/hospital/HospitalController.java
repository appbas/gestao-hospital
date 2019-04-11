package dev.codenation.gestaohospital.hospital;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.GeoResults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.codenation.gestaohospital.estoque.Estoque;
import dev.codenation.gestaohospital.paciente.PacienteResource;
import dev.codenation.gestaohospital.padrao.Paginacao;

@RestController
@RequestMapping(value = "/v1/hospitais")
public class HospitalController {

	@Autowired
	private HospitalService service;

	@GetMapping
	public Paginacao<HospitalResource> pesquisar(@RequestBody Paginacao<HospitalResource> paginacao) {
		return service.pesquisar(paginacao);
	}

	@GetMapping(value = "/localizar")
	public ResponseEntity<GeoResults<Hospital>> obterHospitaisProximo(@RequestParam("lon") double longitude,
			@RequestParam("lat") double latitude, @RequestParam("distancia") double distancia) {
		return ResponseEntity.ok(service.localizar(longitude, latitude, distancia));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<HospitalResource> obterPorId(@PathVariable(name = "id") String id) {
		return ResponseEntity.ok(service.obterPorId(id).orElse(null));
	}
	
	@PostMapping
	public ResponseEntity<HospitalResource> cadastrar(@RequestBody Hospital hospital) {
		return ResponseEntity.ok(service.cadastrar(hospital));
	}
	
	@GetMapping("/{id}/estoque")
	public ResponseEntity<List<Estoque>> listarEstoques(@PathVariable("id") String id) {
		return ResponseEntity.ok(service.listarEstoque(id));
	}
	
	@GetMapping("/{id}/pacientes")
	public ResponseEntity<List<PacienteResource>> pacientes(@PathVariable("id") String id) {
		return ResponseEntity.ok(service.pacientes(id));
	}
	
	@PatchMapping("/{idHospital}/pacientes/{idPaciente}/check-in")
	public ResponseEntity<?> checkin(@PathVariable("idHospital") String idHospital, @PathVariable("idPaciente") String idPaciente) {
		service.checkin(idHospital, idPaciente);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PatchMapping("/{idHospital}/pacientes/{idPaciente}/check-out")
	public ResponseEntity<?> checkout(@PathVariable("idHospital") String idHospital, @PathVariable("idPaciente") String idPaciente) {
		service.checkout(idHospital, idPaciente);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
