package com.ominext.hrm.dto;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

import org.springframework.data.domain.Persistable;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class PO<K extends Serializable> implements Persistable<K> {

	private static final long serialVersionUID = 3498632065144170387L;

	public static final String COLUMNNAME_ID = "id";

	protected PO() {
		super();
	}

	public abstract void setId(K id);

	@Override
	public boolean isNew() {
		return (this.getId() == null);
	}

	@Override
	@SuppressWarnings("unchecked")
	public boolean equals(Object obj) {
		if (obj != null && obj.getClass().equals(this.getClass())) {
			PO<K> po = (PO<K>) obj;
			if (po.getId() != null && this.getId() != null) {
				return po.getId().equals(this.getId());
			}

			return super.equals(obj);
		}

		return false;
	}

	@Override
	public int hashCode() {
		return getId() == null ? 0 : getId().hashCode();
	}

	@Override
	public String toString() {
		return new StringBuilder(this.getClass().getSimpleName()).append("=").append(getId()).toString();
	}

	public static <K extends Serializable> void copy(PO<K> source, PO<K> destination) {
		if (source == null || destination == null) {
			throw new IllegalArgumentException("param is null");
		}

		destination.setId(source.getId());
	}

	public static <D extends PO<? extends Serializable>> Map<String, Field> getAllFields(Class<D> clazz) {
		HashMap<String, Field> allFields = new HashMap<String, Field>();

		Class<?> currentClazz = clazz;
		do {
			Field[] fields = currentClazz.getDeclaredFields();
			if (fields != null && fields.length > 0) {
				for (Field field : fields) {
					field.setAccessible(true);
					allFields.put(field.getName(), field);
				}
			}

			currentClazz = currentClazz.getSuperclass();
		} while (!currentClazz.equals(PO.class));

		return allFields;
	}
}
