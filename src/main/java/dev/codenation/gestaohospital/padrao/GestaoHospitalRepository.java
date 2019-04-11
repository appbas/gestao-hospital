package dev.codenation.gestaohospital.padrao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.rest.core.annotation.RestResource;

@NoRepositoryBean
@RestResource(exported = false)
public interface GestaoHospitalRepository<T extends BaseDocument<?>, I extends java.io.Serializable> extends MongoRepository<T, I> {

}
