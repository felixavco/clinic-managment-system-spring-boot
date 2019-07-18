package com.clinicmanagementsystem.api.models.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "clinics")
public class Clinic implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	// General Clinic Information
	@Column(nullable = false)
	private String name;
	@Column(unique = true)
	private String domain;
	@Column(unique = true)
	private String url;
	private String specialization;
	private String logo;

	// Address Information
	@Column(name = "address_line")
	private String addressLine;
	@Column(name = "address_line2")
	private String addressLine2;
	private String state;
	private String city;

	// Contact Information
	@Column(name = "primary_phone")
	private String primaryPhone;
	@Column(name = "secondary_phone")
	private String secondaryPhone;
	private String whatsapp;
	private String email;

	// Social Media
	private String facebook;
	private String instagram;
	private String twitter;
	private String youtube;
	private String linkedin;

	// Account information
	@Column(name = "is_verified")
	private boolean isVerified;
	@Column(name = "is_active")
	private boolean isActive;
	@Column(name = "is_trial")
	private boolean isTrial;
	@Column(name = "verification_token")
	private String verificationToken;
	@Column(name = "verification_token_exp")
	private Date verificationTokenExp;
	@Column(name = "created_at", insertable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;
	@Column(name = "updated_at", columnDefinition = "ON UPDATE CURRENT_TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedAt;
	
	@OneToMany(mappedBy = "clinic", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<User> users;
	@OneToMany(mappedBy = "clinic", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Patient> patients;
	
	/***************** Constructors ******************/

	public Clinic() {
		this.users = new ArrayList<User>();
		this.patients = new ArrayList<Patient>();
	}

	/***************** Getters and Setters ******************/
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getAddressLine() {
		return addressLine;
	}

	public void setAddressLine(String addressLine) {
		this.addressLine = addressLine;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPrimaryPhone() {
		return primaryPhone;
	}

	public void setPrimaryPhone(String primaryPhone) {
		this.primaryPhone = primaryPhone;
	}

	public String getSecondaryPhone() {
		return secondaryPhone;
	}

	public void setSecondaryPhone(String secondaryPhone) {
		this.secondaryPhone = secondaryPhone;
	}

	public String getWhatsapp() {
		return whatsapp;
	}

	public void setWhatsapp(String whatsapp) {
		this.whatsapp = whatsapp;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFacebook() {
		return facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	public String getInstagram() {
		return instagram;
	}

	public void setInstagram(String instagram) {
		this.instagram = instagram;
	}

	public String getTwitter() {
		return twitter;
	}

	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}

	public String getYoutube() {
		return youtube;
	}

	public void setYoutube(String youtube) {
		this.youtube = youtube;
	}

	public String getLinkedin() {
		return linkedin;
	}

	public void setLinkedin(String linkedin) {
		this.linkedin = linkedin;
	}

	public boolean isVerified() {
		return isVerified;
	}

	public void setVerified(boolean isVerified) {
		this.isVerified = isVerified;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public boolean isTrial() {
		return isTrial;
	}

	public void setTrial(boolean isTrial) {
		this.isTrial = isTrial;
	}

	public String getVerificationToken() {
		return verificationToken;
	}

	public void setVerificationToken(String verificationToken) {
		this.verificationToken = verificationToken;
	}

	public Date getVerificationTokenExp() {
		return verificationTokenExp;
	}

	public void setVerificationTokenExp(Date verificationTokenExp) {
		this.verificationTokenExp = verificationTokenExp;
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

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<Patient> getPatients() {
		return patients;
	}

	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}
	
	public void addPatient(Patient patient) {
		this.patients.add(patient);
	}
	
	public void addUser(User user) {
		this.users.add(user);
	}

}
