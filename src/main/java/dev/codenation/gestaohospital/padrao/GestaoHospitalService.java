package dev.codenation.gestaohospital.padrao;


import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GestaoHospitalService<T extends BaseDocument<I>, I extends java.io.Serializable> {
	
	List<T> listar();
	
	Page<T> pesquisar(Pageable pageable);
	
	T cadastrar(T objeto);
	
	T alterar(T objeto);
	
	Optional<T> obterPorId(I id);
	
	void excluir(I id);

}
