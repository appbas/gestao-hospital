package dev.codenation.gestaohospital.documents;

import java.io.Serializable;

public abstract class BaseDocument<E extends Serializable> {

	public abstract E getId();
}
