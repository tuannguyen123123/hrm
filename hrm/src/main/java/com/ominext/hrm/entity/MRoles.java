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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Duong Van Dinh
 */
@Entity
@Table(name = "m_roles")
public class MRoles implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id")
	private Long id;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 255)
	@Column(name = "role_name")
	private String roleName;
	@Column(name = "base_permission_group_id")
	private BigInteger basePermissionGroupId;
	@Basic(optional = false)
	@NotNull
	@Column(name = "status")
	private int status;
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

	public MRoles() {
	}

	public MRoles(Long id) {
		this.id = id;
	}

	public MRoles(Long id, String roleName, int status, Date createTime, Date updateTime) {
		this.id = id;
		this.roleName = roleName;
		this.status = status;
		this.createTime = createTime;
		this.updateTime = updateTime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public BigInteger getBasePermissionGroupId() {
		return basePermissionGroupId;
	}

	public void setBasePermissionGroupId(BigInteger basePermissionGroupId) {
		this.basePermissionGroupId = basePermissionGroupId;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
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
		if (!(object instanceof MRoles)) {
			return false;
		}
		MRoles other = (MRoles) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.ominext.entities.MRoles[ id=" + id + " ]";
	}

}
