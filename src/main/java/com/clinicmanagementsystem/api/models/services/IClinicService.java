package com.clinicmanagementsystem.api.models.services;

import java.util.List;

import com.clinicmanagementsystem.api.models.entities.Clinic;

public interface IClinicService {

	public List<Clinic> findAll();
	
	public void save(Clinic clinic);
	
	public Clinic findById(Long id);
	
	public void deleteById(Long id); 
	
}
