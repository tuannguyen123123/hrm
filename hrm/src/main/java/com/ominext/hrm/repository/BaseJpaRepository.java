/*
 * Copyright 2008-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ominext.hrm.repository;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.transaction.annotation.Transactional;

public abstract class BaseJpaRepository<T, ID extends Serializable> {

	@PersistenceContext
	protected EntityManager entityManager;

	private JpaEntityInformation<T, ?> entityInformation;

	private Class<T> entityClass;

	protected SimpleJpaRepository<T, ID> repository;

	public void setEntityClass(Class<T> entityClass) {

		this.entityClass = entityClass;

	}

	@SuppressWarnings("unchecked")
	public Class<T> getEntityClass() {

		if (this.entityClass == null) {
			Class<?> superClazz = getClass();
			Type superType = superClazz.getGenericSuperclass();
			while (!(superType instanceof ParameterizedType)) {
				superClazz = superClazz.getSuperclass();
				superType = superClazz.getGenericSuperclass();
			}

			int paraIndex = 0;
			ParameterizedType genericSuperclass = (ParameterizedType) superType;
			this.entityClass = (Class<T>) genericSuperclass.getActualTypeArguments()[paraIndex++];
		}
		return this.entityClass;
	}

	@PostConstruct
	public void init() throws Exception {

		this.getEntityName();
		this.repository = new SimpleJpaRepository<>(this.getEntityClass(), entityManager);

	}

	public String getEntityName() {

		return this.getEntityClass().getSimpleName();

	}

	public EntityManager getEntityManager() {

		return entityManager;

	}

	public void setEntityManager(EntityManager em) {

		this.entityManager = em;

	}

	@Transactional
	public T create(T domain) throws RuntimeException {
		try {
			if (entityInformation.isNew(domain)) {
				entityManager.persist(domain);
			} else {
				domain = entityManager.merge(domain);
			}
			entityManager.flush();
		} catch (RuntimeException ex) {
			domain = null;
		}
		return domain;
	}

	public List<T> findAll() {

		return this.repository.findAll();
	}

	public List<T> findAll(Sort sort) {

		return this.repository.findAll(sort);
	}

	public List<T> findAll(Iterable<ID> ids) {

		return this.repository.findAll(ids);
	}

	public <S extends T> List<S> save(Iterable<S> entities) {

		return this.repository.save(entities);
	}

	public void flush() {

		this.repository.flush();
	}

	public <S extends T> S saveAndFlush(S entity) {

		return this.repository.saveAndFlush(entity);
	}

	public void deleteInBatch(Iterable<T> entities) {

		this.repository.deleteInBatch(entities);
	}

	public void deleteAllInBatch() {

		this.repository.deleteAllInBatch();
	}

	public T getOne(ID id) {

		return this.repository.getOne(id);
	}

	public <S extends T> List<S> findAll(Example<S> example) {

		return this.repository.findAll(example);
	}

	public <S extends T> List<S> findAll(Example<S> example, Sort sort) {

		return this.repository.findAll(example, sort);
	}

	public Page<T> findAll(Pageable pageable) {

		return this.repository.findAll(pageable);
	}

	public <S extends T> S save(S entity) {

		return this.repository.save(entity);
	}

	public T findOne(ID id) {

		return this.repository.findOne(id);
	}

	public boolean exists(ID id) {

		return this.repository.exists(id);
	}

	public long count() {

		return this.repository.count();
	}

	public void delete(ID id) {

		this.repository.delete(id);
	}

	public void delete(T entity) {

		this.repository.delete(entity);
	}

	public void delete(Iterable<? extends T> entities) {

		this.repository.delete(entities);
	}

	public void deleteAll() {

		this.repository.deleteAll();
	}

	public <S extends T> S findOne(Example<S> example) {

		return this.repository.findOne(example);
	}

	public <S extends T> Page<S> findAll(Example<S> example, Pageable pageable) {

		return this.repository.findAll(example, pageable);
	}

	public <S extends T> long count(Example<S> example) {

		return this.repository.count(example);
	}

	public <S extends T> boolean exists(Example<S> example) {

		return this.repository.exists(example);
	}

}
