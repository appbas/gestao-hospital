package dev.codenation.gestaohospital.padrao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public abstract class GestaoHospitalServiceImpl<T extends BaseDocument<I>, I extends java.io.Serializable> implements GestaoHospitalService<T, I> {

	
	@Override
	public List<T> listar() {
		return getRepository().findAll();
	}
	
	@Override
	public Page<T> pesquisar(Pageable pageable) {
		return getRepository().findAll(pageable);
	}

	@Override
	public T cadastrar(T objeto) {
		return getRepository().insert(objeto);
	}

	@Override
	public T alterar(T objeto) {
		return getRepository().save(objeto);
	}

	@Override
	public Optional<T> obterPorId(I id) {
		return getRepository().findById(id);
	}

	@Override
	public void excluir(I id) {
		getRepository().deleteById(id);
	}

	protected abstract GestaoHospitalRepository<T, I> getRepository();
	
}
