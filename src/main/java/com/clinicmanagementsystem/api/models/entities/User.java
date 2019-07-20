package com.clinicmanagementsystem.api.models.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "users")
public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "first_name", nullable = false)
	private String firstName;
	@Column(name = "last_name", nullable = false)
	private String lastName;
	@Column(name = "middle_name")
	private String middleName;
	@Column(name = "last_name2")
	private String lastName2;
	@Column(name = "user_name")
	private String userName;
	@Column(unique = true, nullable = false)
	private String email;
	@Column(name = "pwd", nullable = false)
	private String password;
	
	@Column(name = "is_active", columnDefinition = "DEFAULT true")
	private boolean isActive;
	@Column(name = "pwd_recovery_token")
	private String pwdRecoveryToken;
	@Column(name = "pwd_recovery_token_exp")
	private String pwdRecoveryTokenExp;
	
	private List<String> roles;
	
	@Column(name = "created_at", insertable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;
	@Column(name = "updated_at", columnDefinition = "ON UPDATE CURRENT_TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedAt;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Clinic clinic;

	/***************** Constructors ******************/

	public User() {
		this.roles = new ArrayList<String>();
	}

	/***************** Getters and Setters ******************/
	public Long getUserId() {
		return id;
	}

	public void setUserId(Long userId) {
		this.id = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName2() {
		return lastName2;
	}

	public void setLastName2(String lastName2) {
		this.lastName2 = lastName2;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getPwdRecoveryToken() {
		return pwdRecoveryToken;
	}

	public void setPwdRecoveryToken(String pwdRecoveryToken) {
		this.pwdRecoveryToken = pwdRecoveryToken;
	}

	public String getPwdRecoveryTokenExp() {
		return pwdRecoveryTokenExp;
	}

	public void setPwdRecoveryTokenExp(String pwdRecoveryTokenExp) {
		this.pwdRecoveryTokenExp = pwdRecoveryTokenExp;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Clinic getClinic() {
		return clinic;
	}

	public void setClinic(Clinic clinic) {
		this.clinic = clinic;
	}
	
	
	
}
