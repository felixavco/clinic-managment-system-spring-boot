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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="patients")
public class Patient implements Serializable {

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

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dob;
	
	// Contact Information
	@Column(name = "primary_phone")
	private String primaryPhone;
	@Column(name = "secondary_phone")
	private String secondaryPhone;
	private String whatsapp;
	private String email;
	
	// Address Information
	@Column(name = "address_line")
	private String addressLine;
	@Column(name = "address_line2")
	private String addressLine2;
	private String state;
	private String city;
	
	//Insurance Information
	@Column(name = "insurance_number")
	private String insuranceNumber;
	@Column(name = "insurance_provider")
	private String insuranceProvider;
	
	//Clinic Information
	@Column(name = "blood_type")
	private String bloodType;
	private String alergies;
	private String notes;
	@OneToMany(mappedBy = "patient", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<MedicalVisit> medicalVisits;
	
	@Column(name = "created_at", insertable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;
	@Column(name = "updated_at", columnDefinition = "ON UPDATE CURRENT_TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedAt;
    
    @ManyToOne(fetch = FetchType.LAZY)
	private Clinic clinic;

	/***************** Constructors ******************/
	public Patient() {
		this.medicalVisits =  new ArrayList<MedicalVisit>();
	}
	
	/***************** Getters and Setters ******************/
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
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

	public String getInsuranceNumber() {
		return insuranceNumber;
	}

	public void setInsuranceNumber(String insuranceNumber) {
		this.insuranceNumber = insuranceNumber;
	}

	public String getInsuranceProvider() {
		return insuranceProvider;
	}

	public void setInsuranceProvider(String insuranceProvider) {
		this.insuranceProvider = insuranceProvider;
	}

	public String getBloodType() {
		return bloodType;
	}

	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}

	public String getAlergies() {
		return alergies;
	}

	public void setAlergies(String alergies) {
		this.alergies = alergies;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public List<MedicalVisit> getMedicalVisits() {
		return medicalVisits;
	}

	public void setMedicalVisits(List<MedicalVisit> medicalVisits) {
		this.medicalVisits = medicalVisits;
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
	
	public void addMedicalVisit(MedicalVisit medicalVisit) {
		this.medicalVisits.add(medicalVisit);
	}
    
}
