package com.ominext.hrm.dto;

import java.io.Serializable;

public abstract class DTO<K extends Serializable> implements Serializable {

	private static final long serialVersionUID = -862151765440311950L;

	protected K id;

	private Long count;

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	public DTO() {
		super();

		this.id = null;
	}

	public K getId() {
		return id;
	}

	public void setId(K id) {
		this.id = id;
	}

}
