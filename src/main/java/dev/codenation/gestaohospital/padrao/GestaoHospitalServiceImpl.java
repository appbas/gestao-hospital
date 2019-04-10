package dev.codenation.gestaohospital.padrao;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public abstract class GestaoHospitalServiceImpl<T extends BaseDocument<I>, I extends java.io.Serializable> implements GestaoHospitalService<T, I> {

	
	@Override
	public Page<T> listar(Pageable pageable) {
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
