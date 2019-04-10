package dev.codenation.gestaohospital.leito;

import dev.codenation.gestaohospital.hospital.Hospital;
import dev.codenation.gestaohospital.hospital.HospitalResource;
import dev.codenation.gestaohospital.paciente.Paciente;
import dev.codenation.gestaohospital.paciente.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.text.DateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/v1/leitos")
public class LeitoController {

    @Autowired
    private LeitoService service;

    @GetMapping(produces = "application/hal+json")
    public ResponseEntity<Resources<LeitoResource>> pesquisar(Pageable pageable,
                                                                 PagedResourcesAssembler<Hospital> assembler) {

        List<LeitoResource> collection = service.pesquisar(pageable).stream().map(LeitoResource::new).collect(Collectors.toList());
        final Resources<LeitoResource> resources = new Resources<>(collection);
        final String uriString = ServletUriComponentsBuilder.fromCurrentRequest().build().toUriString();
        resources.add(new Link(uriString, "self"));
        return ResponseEntity.ok(resources);
    }

    /**
     * Obter por id.
     * 
     * GET = Retorno um recurso ou uma lista do mestmo
     *
     * @param Id the id
     * @return the response entity
     */
    @GetMapping
    public ResponseEntity<Leito> obterPorId(String Id){
        return ResponseEntity.ok(service.obterPorId(Id).orElse(null));
    }

    /**
     * Cadastrar.
     * 
     * POST = Utlizado,principalmente para inserir um novo recurso
     *
     * @param leito the leito
     * @return the response entity
     */
    @PostMapping
    public ResponseEntity<Leito> cadastrar(Leito leito){
        return new ResponseEntity<>(service.cadastrar(leito), HttpStatus.OK);
    }

    /**
     * Atualizar.
     * 
     * PUT - Atualiza um recurso por completo.
     *
     * @param leito the leito
     * @return the response entity
     */
    @PutMapping
    public ResponseEntity<Leito> atualizar(Leito leito){
        return new ResponseEntity<>(service.atualizar(leito), HttpStatus.OK);
    }

    @PatchMapping("/{idPaciente}/check-in")
    public ResponseEntity<Leito> checkIn(@PathVariable("idPaciente") String id, @RequestBody Leito leito){
        leito.getPaciente().setId(id);
        leito.setDataEntrada(Date.from(Instant.now()));
        return new ResponseEntity<>(service.atualizar(leito), HttpStatus.OK);
    }

    @PatchMapping("/{idPaciente}/check-out")
    public ResponseEntity<Leito> checkOut(@PathVariable("idPaciente") String id, @RequestBody Leito leito){
        if(leito.getDataEntrada()!=null) {
            leito.setDataSaida(Date.from(Instant.now()));

            return new ResponseEntity<>(service.atualizar(leito), HttpStatus.OK);
        }

        return new ResponseEntity<>(leito, HttpStatus.NOT_MODIFIED);
    }

}
