package dev.codenation.gestaohospital.hospital;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import org.springframework.hateoas.ResourceSupport;

public class HospitalResource extends ResourceSupport {

	private Hospital hospital;

	public HospitalResource(Hospital hospital) {
		this.hospital = hospital;
		add(linkTo(HospitalController.class).slash(hospital.getId()).withRel("Hospital"));
	}

	public Hospital getHospital() {
		return hospital;
	}

}
