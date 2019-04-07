package dev.codenation.gestaohospital.paciente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.xml.transform.Result;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/v1/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService service;

    @GetMapping(produces = "application/hal+json")
    public ResponseEntity<Resources<PacienteResource>> pesquisar(Pageable pageable,
                                                                 PagedResourcesAssembler<Paciente> assembler) {
        List<PacienteResource> collection = service.pesquisar(pageable).stream().map(PacienteResource::new)
                .collect(Collectors.toList());
        final Resources<PacienteResource> resources = new Resources<>(collection);
        final String uriString = ServletUriComponentsBuilder.fromCurrentRequest().build().toUriString();
        resources.add(new Link(uriString, "self"));
        return ResponseEntity.ok(resources);
    }

    @GetMapping()
    public ResponseEntity<Paciente> obterPorId(String Id){
        return ResponseEntity.ok(service.obterPorId(Id).orElse(null));
    }

    @GetMapping()
    public ResponseEntity<Paciente> obterPorCpf(String Cpf){
        return ResponseEntity.ok(service.obterPorCpf(Cpf).orElse(null));
    }

    @GetMapping()
    public ResponseEntity<List<Paciente>> obterPorNome(String nome){
        return ResponseEntity.ok(service.obterPorNome(nome));
    }

    @GetMapping()
    public ResponseEntity<Paciente> cadastrar(Paciente paciente){
        return new ResponseEntity<>(service.cadastrar(paciente),HttpStatus.OK);
    }
}
