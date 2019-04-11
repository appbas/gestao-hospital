package dev.codenation.gestaohospital.padrao;


import java.util.List;
import java.util.Optional;

public interface GestaoHospitalService<E extends BaseDocument<I>, T extends GestaoHospitalResource, I extends java.io.Serializable> {
	
	List<T> listar();
	
	Paginacao<T> pesquisar(Paginacao<T> paginacao);
	
	T cadastrar(E objeto);
	
	T alterar(E objeto);
	
	Optional<T> obterPorId(I id);
	
	void excluir(I id);

}
