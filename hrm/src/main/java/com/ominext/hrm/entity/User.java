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

import com.ominext.hrm.dto.DTO;

/**
 *
 * @author Duong Van Dinh
 */
@Entity
@Table(name = "users")
public class User extends DTO<Long> implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id")
	private Long id;
	@Size(max = 50)
	@Column(name = "user_name")
	private String userName;
	@Size(max = 255)
	@Column(name = "full_name")
	private String fullName;
	@Size(max = 255)
	@Column(name = "password")
	private String password;
	@Column(name = "last_password_change")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastPasswordChange;
	@Column(name = "login_token_id")
	private BigInteger loginTokenId;
	@Column(name = "department_id")
	private BigInteger departmentId;
	@Column(name = "role_id")
	private BigInteger roleId;
	@Basic(optional = false)
	
	@Column(name = "locked_time")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lockedTime;
	@Column(name = "locked_reason")
	private Integer lockedReason;
	@Basic(optional = false)
	@NotNull
	@Column(name = "status")
	private int status;
	@Column(name = "create_user_id")
	private BigInteger createUserId;
	@Basic(optional = false)

	@Column(name = "create_time")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createTime;
	@Column(name = "update_user_id")
	private BigInteger updateUserId;
	@Basic(optional = false)

	@Column(name = "update_time")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updateTime;

	public User() {
	}

	public User(Long id) {
		this.id = id;
	}
	
	public User(String userName) {
		this.userName = userName;
	}

	public User(Long id, Date lockedTime, int status, Date createTime, Date updateTime) {
		this.id = id;
		this.lockedTime = lockedTime;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getLastPasswordChange() {
		return lastPasswordChange;
	}

	public void setLastPasswordChange(Date lastPasswordChange) {
		this.lastPasswordChange = lastPasswordChange;
	}

	public BigInteger getLoginTokenId() {
		return loginTokenId;
	}

	public void setLoginTokenId(BigInteger loginTokenId) {
		this.loginTokenId = loginTokenId;
	}

	public BigInteger getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(BigInteger departmentId) {
		this.departmentId = departmentId;
	}

	public BigInteger getRoleId() {
		return roleId;
	}

	public void setRoleId(BigInteger roleId) {
		this.roleId = roleId;
	}

	public Date getLockedTime() {
		return lockedTime;
	}

	public void setLockedTime(Date lockedTime) {
		this.lockedTime = lockedTime;
	}

	public Integer getLockedReason() {
		return lockedReason;
	}

	public void setLockedReason(Integer lockedReason) {
		this.lockedReason = lockedReason;
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
		if (!(object instanceof User)) {
			return false;
		}
		User other = (User) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.ominext.entities.Users[ id=" + id + " ]";
	}

}
