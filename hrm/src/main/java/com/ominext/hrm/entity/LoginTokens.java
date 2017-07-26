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
@Table(name = "login_tokens")
public class LoginTokens implements Serializable {

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
	@Size(min = 1, max = 255)
	@Column(name = "token_value")
	private String tokenValue;
	@Basic(optional = false)
	@NotNull
	@Column(name = "status")
	private int status;
	@Basic(optional = false)
	@NotNull
	@Column(name = "first_login_time")
	@Temporal(TemporalType.TIMESTAMP)
	private Date firstLoginTime;
	@Basic(optional = false)
	@NotNull
	@Column(name = "last_login_time")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastLoginTime;
	@Basic(optional = false)
	@NotNull
	@Column(name = "force_delete_time")
	@Temporal(TemporalType.TIMESTAMP)
	private Date forceDeleteTime;
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

	public LoginTokens() {
	}

	public LoginTokens(Long id) {
		this.id = id;
	}

	public LoginTokens(Long id, long userId, String tokenValue, int status, Date firstLoginTime, Date lastLoginTime,
			Date forceDeleteTime, Date createTime, Date updateTime) {
		this.id = id;
		this.userId = userId;
		this.tokenValue = tokenValue;
		this.status = status;
		this.firstLoginTime = firstLoginTime;
		this.lastLoginTime = lastLoginTime;
		this.forceDeleteTime = forceDeleteTime;
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

	public String getTokenValue() {
		return tokenValue;
	}

	public void setTokenValue(String tokenValue) {
		this.tokenValue = tokenValue;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getFirstLoginTime() {
		return firstLoginTime;
	}

	public void setFirstLoginTime(Date firstLoginTime) {
		this.firstLoginTime = firstLoginTime;
	}

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public Date getForceDeleteTime() {
		return forceDeleteTime;
	}

	public void setForceDeleteTime(Date forceDeleteTime) {
		this.forceDeleteTime = forceDeleteTime;
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
		if (!(object instanceof LoginTokens)) {
			return false;
		}
		LoginTokens other = (LoginTokens) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.ominext.entities.LoginTokens[ id=" + id + " ]";
	}

}
