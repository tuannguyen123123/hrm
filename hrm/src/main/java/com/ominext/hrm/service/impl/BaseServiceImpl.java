package com.ominext.hrm.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;

import com.ominext.hrm.dto.DTO;
import com.ominext.hrm.dto.ListJson;
import com.ominext.hrm.dto.PO;
import com.ominext.hrm.repository.BaseRepository;
import com.ominext.hrm.service.BaseService;

public abstract class BaseServiceImpl<Entity extends PO<Long>, BaseDto extends DTO<? extends Serializable>>
		implements BaseService<BaseDto> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public abstract BaseRepository<Entity, Long> getRepository();

	public abstract BaseDto createBaseDto(Entity entity, Long size);

	public abstract Entity createEntity(BaseDto baseDtos);

	public abstract void updateEntity(Entity entity, BaseDto baseDtos) throws RuntimeException;

	public static final Sort DEFAULT_SORT = new Sort(new Order(Direction.ASC, PO.COLUMNNAME_ID));

	// FINDALL
	@Override
	public ListJson<BaseDto> findAll() {

		List<BaseDto> baseDtos = new ArrayList<BaseDto>();

		List<Entity> entitys = this.getRepository().findAll(DEFAULT_SORT);
		Long size = Long.valueOf(entitys.size());
		for (Entity entity : entitys) {
			baseDtos.add(createBaseDto(entity, size));
		}
		return new ListJson<BaseDto>(baseDtos, Long.valueOf(baseDtos.size()));
	}

	// FINDONE
	@Override
	public BaseDto findOne(Long id) {

		if (id == null) {
			throw new RuntimeException();
		}
		Entity entity = this.getRepository().findOne(id);
		if (entity == null) {
			throw new RuntimeException();
		}
		return createBaseDto(entity, 1L);
	}

	// CREATE
	@Override
	public String create(BaseDto baseDto) {

		Entity entity = createEntity(baseDto);
		if (entity == null) {
			throw new RuntimeException();
		}
		try {
			entity = this.getRepository().save(entity);
		} catch (RuntimeException e) {
			throw e;
		}
		return entity.getId().toString();
	}

	// UPDATE
	@Override
	public String update(Long id, BaseDto baseDto) throws RuntimeException {

		if (id == null) {
			throw new RuntimeException();
		}

		Entity entity = getRepository().findOne(id);
		if (entity == null) {
			throw new RuntimeException();
		}
		updateEntity(entity, baseDto);
		entity = getRepository().save(entity);
		return entity.getId().toString();
	}

	// DELETE
	@Override
	public void delete(Long id) {

		if (id == null) {
			throw new RuntimeException();
		}
		try {
			this.getRepository().delete(id);
		} catch (RuntimeException e) {
			throw e;
		}
	}

	protected ListJson<BaseDto> paging(Integer page, Integer size, List<BaseDto> list) {
		long resultSize = list.size();

		List<BaseDto> listAfterPagingDto = new ArrayList<BaseDto>();

		if (page != null && size != null && size > 0) {
			int begin = page * size;
			int end = page * size + size;

			if (begin > resultSize)
				return new ListJson<BaseDto>(listAfterPagingDto, resultSize);
			else if (end > resultSize) {
				end = (int) resultSize;
			}
			listAfterPagingDto = list.subList(begin, end);
		} else
			return new ListJson<BaseDto>(list, resultSize);
		return new ListJson<BaseDto>(listAfterPagingDto, resultSize);
	}

}
