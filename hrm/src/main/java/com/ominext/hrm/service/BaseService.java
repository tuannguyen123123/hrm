package com.ominext.hrm.service;

import java.io.Serializable;

import com.ominext.hrm.dto.DTO;
import com.ominext.hrm.dto.ListJson;

public interface BaseService<BaseDto extends DTO<? extends Serializable>> extends Serializable {

	public ListJson<BaseDto> findAll();

	public BaseDto findOne(Long id);

	public String create(BaseDto baseDto);

	public void delete(Long id);

	public String update(Long id, BaseDto dto);

}
