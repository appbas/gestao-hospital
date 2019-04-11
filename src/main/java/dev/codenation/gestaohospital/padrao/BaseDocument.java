package dev.codenation.gestaohospital.padrao;

import java.io.Serializable;

public abstract class BaseDocument<E extends Serializable> {

	public abstract E getId();
}
