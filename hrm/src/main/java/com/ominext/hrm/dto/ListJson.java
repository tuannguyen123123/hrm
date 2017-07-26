package com.ominext.hrm.dto;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

public class ListJson<T> implements Serializable {

	private static final long serialVersionUID = -2951368320989890231L;

	@SuppressWarnings({ "rawtypes" })
	public static final ListJson EMPTY_LIST = new ListJson<>(
			Collections.emptyList(), 0l);

	@SuppressWarnings("unchecked")
	public static final <T> ListJson<T> emptyList() {
		return EMPTY_LIST;
	}

	private List<T> list;
	private Long count;
	private Long unreadCount;

	public ListJson() {
		this(null, null);
	}
	public ListJson(List<T> list, Long count) {
		this.list = list;
		this.count = count;
	}
	public ListJson(List<T> list, Long count, Long unreadCount) {
		this.list = list;
		this.count = count;
		this.unreadCount = unreadCount;
	}
	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}
	public Long getUnreadCount() {
		return unreadCount;
	}
	public void setUnreadCount(Long unreadCount) {
		this.unreadCount = unreadCount;
	}
	
}
