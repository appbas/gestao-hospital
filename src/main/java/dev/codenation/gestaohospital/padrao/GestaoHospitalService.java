package dev.codenation.gestaohospital.padrao;


import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GestaoHospitalService<T extends BaseDocument<I>, I extends java.io.Serializable> {
	
	Page<T> listar(Pageable pageable);
	
	T cadastrar(T objeto);
	
	T alterar(T objeto);
	
	Optional<T> obterPorId(I id);
	
	void excluir(I id);

}
