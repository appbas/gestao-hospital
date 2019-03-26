package dev.codenation.gestaohospital.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import dev.codenation.gestaohospital.documents.Hospital;
import dev.codenation.gestaohospital.repositories.IHospitalRepository;

@Service
public class HospitalService {
	
	@Autowired
	private IHospitalRepository repository;
	
	public Page<Hospital> pesquisar(Pageable pageable) {
		return repository.findAll(pageable);
	}
	
	public Optional<Hospital> obterPorId(String id) {
		return repository.findById(id);
	}
	
	public Hospital cadastrar(Hospital hospital) {
		return repository.insert(hospital);
	}

}