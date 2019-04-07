package dev.codenation.gestaohospital.leito;

import dev.codenation.gestaohospital.hospital.Hospital;
import dev.codenation.gestaohospital.hospital.HospitalController;
import org.springframework.hateoas.ResourceSupport;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

public class LeitoResource extends ResourceSupport{
    private Leito leito;

    public LeitoResource(Leito leito){
        this.leito = leito;
        add(linkTo(LeitoController.class).slash(leito.getId()).withRel("Leito"));
    }

    public Leito getLeito() {
        return leito;
    }
}
