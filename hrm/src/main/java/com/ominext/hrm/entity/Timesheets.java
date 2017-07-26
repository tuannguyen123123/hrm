/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ominext.hrm.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.ominext.hrm.dto.PO;

/**
 *
 * @author Quyettv
 */
@Entity
@Table(name = "timesheets")
public class Timesheets extends PO<Long> implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id")
	private Long id;
	@Basic(optional = false)
	@NotNull
	@Column(name = "user_id")
	private long userId;
	@Basic(optional = false)
	@NotNull
	@Column(name = "type")
	private int type;
	@Basic(optional = false)
	@NotNull
	@Lob
	@Size(min = 1, max = 2147483647)
	@Column(name = "content")
	private String content;
	@Basic(optional = false)
	@NotNull
	@Column(name = "start_time")
	@Temporal(TemporalType.TIMESTAMP)
	private Date startTime;
	@Basic(optional = false)
	@NotNull
	@Column(name = "end_time")
	@Temporal(TemporalType.TIMESTAMP)
	private Date endTime;
	@Basic(optional = false)
	@NotNull
	@Column(name = "duration")
	private int duration;
	@Column(name = "project_id")
	private BigInteger projectId;
	@Basic(optional = false)
	@NotNull
	@Column(name = "department_id")
	private int departmentId;
	@Column(name = "create_user_id")
	private BigInteger createUserId;
	@Basic(optional = false)
	@NotNull
	@Column(name = "create_time")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createTime;
	@Column(name = "update_user_id")
	private BigInteger updateUserId;
	@Basic(optional = false)
	@NotNull
	@Column(name = "update_time")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updateTime;

	public Timesheets() {
	}

	public Timesheets(Long id) {
		this.id = id;
	}

	public Timesheets(Long id, long userId, int type, String content, Date startTime, Date endTime, int duration,
			int departmentId, Date createTime, Date updateTime) {
		this.id = id;
		this.userId = userId;
		this.type = type;
		this.content = content;
		this.startTime = startTime;
		this.endTime = endTime;
		this.duration = duration;
		this.departmentId = departmentId;
		this.createTime = createTime;
		this.updateTime = updateTime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public BigInteger getProjectId() {
		return projectId;
	}

	public void setProjectId(BigInteger projectId) {
		this.projectId = projectId;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public BigInteger getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(BigInteger createUserId) {
		this.createUserId = createUserId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public BigInteger getUpdateUserId() {
		return updateUserId;
	}

	public void setUpdateUserId(BigInteger updateUserId) {
		this.updateUserId = updateUserId;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof Timesheets)) {
			return false;
		}
		Timesheets other = (Timesheets) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.ominext.hrm.entity.Timesheets[ id=" + id + " ]";
	}

}
