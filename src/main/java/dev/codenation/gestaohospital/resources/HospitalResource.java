package dev.codenation.gestaohospital.resources;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import org.springframework.hateoas.ResourceSupport;

import dev.codenation.gestaohospital.controllers.HospitalController;
import dev.codenation.gestaohospital.documents.Hospital;

public class HospitalResource extends ResourceSupport {

	private Hospital hospital;

	public HospitalResource(Hospital hospital) {
		this.hospital = hospital;
		add(linkTo(HospitalController.class).withRel("Hospital"));
	}

	public Hospital getHospital() {
		return hospital;
	}

}
