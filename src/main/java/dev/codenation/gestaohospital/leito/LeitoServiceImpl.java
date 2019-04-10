package dev.codenation.gestaohospital.leito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.codenation.gestaohospital.padrao.GestaoHospitalServiceImpl;

@Service
public class LeitoServiceImpl extends GestaoHospitalServiceImpl<Leito, String> implements LeitoService {

    @Autowired
    private LeitoRepository repository;

	@Override
	protected LeitoRepository getRepository() {
		return repository;
	}

}
