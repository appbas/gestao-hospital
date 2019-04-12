package dev.codenation.gestaohospital.paciente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import dev.codenation.gestaohospital.padrao.Paginacao;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/v1/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService service;

    @GetMapping
    public ResponseEntity<Paginacao<PacienteResource>> pesquisar(@RequestBody Paginacao<PacienteResource> paginacao) {
    	return ResponseEntity.ok(service.pesquisar(paginacao));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PacienteResource> obterPorId(@PathVariable(name = "id") String Id){
        return ResponseEntity.ok(service.obterPorId(Id).orElse(null));
    }

    @GetMapping("/porCPF/{cpf}")
    public ResponseEntity<List<PacienteResource>> obterPorCpf(@PathVariable(name = "cpf") String cpf){
        return ResponseEntity.ok(service.obterPorCpf(cpf));
    }

    @GetMapping("/porNome/{nome}")
    public ResponseEntity<List<PacienteResource>> obterPorNome(@PathVariable(name = "nome") String nome){
        return ResponseEntity.ok(service.obterPorNome(nome));
    }

    @PostMapping()
    public ResponseEntity<PacienteResource> cadastrar(@RequestBody Paciente paciente){
            return new ResponseEntity<>(service.cadastrar(paciente), HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<PacienteResource> atualizar(@RequestBody Paciente paciente){
        return new ResponseEntity<>(service.alterar(paciente), HttpStatus.OK);
    }
}
