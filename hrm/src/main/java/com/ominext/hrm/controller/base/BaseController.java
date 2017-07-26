package com.ominext.hrm.controller.base;

import java.io.Serializable;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ominext.hrm.dto.DTO;
import com.ominext.hrm.dto.Envelope;
import com.ominext.hrm.dto.IdDto;
import com.ominext.hrm.dto.ListJson;
import com.ominext.hrm.dto.Meta;
import com.ominext.hrm.service.BaseService;

public abstract class BaseController<BaseDto extends DTO<? extends Serializable>> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected abstract BaseService<BaseDto> getService();

	// CREATE
	@RequestMapping(value = "", method = RequestMethod.POST)
	public final ResponseEntity<?> create(@RequestBody @Valid BaseDto baseDto, BindingResult result,
			HttpServletRequest request) {
		return _create(baseDto, request);
	}

	// UPDATE
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public final ResponseEntity<?> update(@PathVariable Long id, @RequestBody @Valid BaseDto baseDto,
			BindingResult result, HttpServletRequest request) {
		return _update(id, baseDto, request);
	}

	// FINDONE
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public final ResponseEntity<?> findOne(@PathVariable Long id, HttpServletRequest request) {
		return _findOnel(id, request);
	}

	// DELETE
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public final ResponseEntity<?> delete(@PathVariable Long id, HttpServletRequest request) {
		return _delete(id, request);
	}

	// FINDALL
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public final ResponseEntity<?> findAll(HttpServletRequest request) {
		return _findAll(request);
	}

	// CREATE
	protected ResponseEntity<?> _create(BaseDto baseDto, HttpServletRequest request) {
		String entityId;
		HashMap<String, Object> value = new HashMap<String, Object>();
		try {
			entityId = getService().create(baseDto);
		} catch (RuntimeException e) {
			return new ResponseEntity<Object>(value, HttpStatus.EXPECTATION_FAILED);
		}
		if (entityId == null) {
			throw new UnsupportedOperationException("error when create");
		}

		return new Envelope(new IdDto(entityId)).toResponseEntity(HttpStatus.OK);
	}

	// UPDATE
	protected ResponseEntity<?> _update(Long id, BaseDto baseDto, HttpServletRequest request) {
		String entityId;
		HashMap<String, Object> value = new HashMap<String, Object>();
		try {
			entityId = getService().update(id, baseDto);
		} catch (RuntimeException e) {
			return new ResponseEntity<Object>(value, HttpStatus.EXPECTATION_FAILED);
		}
		if (entityId == null) {
			return new ResponseEntity<Object>(value, HttpStatus.EXPECTATION_FAILED);
		}

		return new Envelope(new IdDto(entityId)).toResponseEntity(HttpStatus.OK);
	}

	// FINDONE
	protected ResponseEntity<?> _findOnel(Long id, HttpServletRequest request) {
		BaseDto baseDto;
		HashMap<String, Object> value = new HashMap<String, Object>();
		try {
			baseDto = getService().findOne(id);
		} catch (RuntimeException e) {
			return new ResponseEntity<Object>(value, HttpStatus.EXPECTATION_FAILED);
		}

		if (baseDto == null) {
			return new ResponseEntity<Object>(value, HttpStatus.EXPECTATION_FAILED);
		}
		return new Envelope(baseDto).toResponseEntity(HttpStatus.OK);
	}

	// DELETE
	protected ResponseEntity<?> _delete(Long id, HttpServletRequest request) {
		HashMap<String, Object> value = new HashMap<String, Object>();
		try {
			getService().delete(id);
		} catch (RuntimeException e) {
			return new ResponseEntity<Object>(value, HttpStatus.EXPECTATION_FAILED);
		}

		return new Envelope(Meta.OK).toResponseEntity(HttpStatus.OK);
	}

	// FINDALL
	protected ResponseEntity<?> _findAll(HttpServletRequest request) {
		ListJson<BaseDto> baseDtos;
		HashMap<String, Object> value = new HashMap<String, Object>();
		try {
			baseDtos = getService().findAll();
		} catch (RuntimeException e) {
			return new ResponseEntity<Object>(value, HttpStatus.EXPECTATION_FAILED);
		}
		return new Envelope(baseDtos).toResponseEntity(HttpStatus.OK);
	}

}
