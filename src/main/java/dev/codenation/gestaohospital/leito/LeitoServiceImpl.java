package dev.codenation.gestaohospital.leito;

import org.springframework.beans.factory.annotation.Autowired;

import dev.codenation.gestaohospital.padrao.GestaoHospitalServiceImpl;

public class LeitoServiceImpl extends GestaoHospitalServiceImpl<Leito, String> implements LeitoService {

    @Autowired
    private LeitoRepository repository;

	@Override
	protected LeitoRepository getRepository() {
		return repository;
	}

}
