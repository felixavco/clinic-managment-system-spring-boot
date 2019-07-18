package com.clinicmanagementsystem.api.models.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "medical_visits")
public class MedicalVisit implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private double temperature;
	@Column(name = "blood_presure")
	private String bloodPresure;
	private double height;
	private double weight;
	private String diagnose;
	private String notes;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Patient patient;
	private Prescription prescription;

	/***************** Getters and Setters ******************/
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public double getTemperature() {
		return temperature;
	}


	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}


	public String getBloodPresure() {
		return bloodPresure;
	}


	public void setBloodPresure(String bloodPresure) {
		this.bloodPresure = bloodPresure;
	}


	public double getHeight() {
		return height;
	}


	public void setHeight(double height) {
		this.height = height;
	}


	public double getWeight() {
		return weight;
	}


	public void setWeight(double weight) {
		this.weight = weight;
	}


	public String getDiagnose() {
		return diagnose;
	}


	public void setDiagnose(String diagnose) {
		this.diagnose = diagnose;
	}


	public String getNotes() {
		return notes;
	}


	public void setNotes(String notes) {
		this.notes = notes;
	}


	public Patient getPatient() {
		return patient;
	}


	public void setPatient(Patient patient) {
		this.patient = patient;
	}


	public Prescription getPrescription() {
		return prescription;
	}


	public void setPrescription(Prescription prescription) {
		this.prescription = prescription;
	}
	
}
