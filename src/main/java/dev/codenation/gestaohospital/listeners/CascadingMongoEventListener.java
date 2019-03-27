package dev.codenation.gestaohospital.listeners;

import java.lang.reflect.Field;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.AfterLoadEvent;
import org.springframework.data.mongodb.core.mapping.event.AfterSaveEvent;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.util.ReflectionUtils;

import dev.codenation.gestaohospital.documents.BaseDocument;

public class CascadingMongoEventListener<D extends BaseDocument<?>> extends AbstractMongoEventListener<D> {
	@Autowired
	private MongoOperations mongoOperations;

	@Override
	public void onAfterSave(AfterSaveEvent<D> event) {
		super.onAfterSave(event);
	}

	@Override
	public void onBeforeConvert(BeforeConvertEvent<D> event) {

		ReflectionUtils.doWithFields(event.getSource().getClass(), new ReflectionUtils.FieldCallback() {

			public void doWith(Field field) throws IllegalArgumentException, IllegalAccessException {
				ReflectionUtils.makeAccessible(field);

				if (field.isAnnotationPresent(DBRef.class) /* && field.isAnnotationPresent(CascadeSave.class) */) {
					final Object fieldValue = field.get(event.getSource());

					DbRefFieldCallback callback = new DbRefFieldCallback();

					ReflectionUtils.doWithFields(fieldValue.getClass(), callback);

//					if (!callback.isIdFound()) {
//						throw new MappingException("Cannot perform cascade save on child object without id set");
//					}
//
//					mongoOperations.save(fieldValue);
				}
			}
		});

		super.onBeforeConvert(event);
	}
	
	@Override
	public void onAfterLoad(AfterLoadEvent<D> event) {
		event.getSource();
		super.onAfterLoad(event);
	}

	private static class DbRefFieldCallback implements ReflectionUtils.FieldCallback {
		private boolean idFound;

		public void doWith(Field field) throws IllegalArgumentException, IllegalAccessException {
			ReflectionUtils.makeAccessible(field);

			if (field.isAnnotationPresent(Id.class)) {
				idFound = true;
			}
		}

		public boolean isIdFound() {
			return idFound;
		}
	}
}