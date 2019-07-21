package com.clinicmanagementsystem.api.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.clinicmanagementsystem.api.models.entities.Clinic;

public interface IClinicDao extends CrudRepository<Clinic, Long> {

	public Clinic findByDomainIgnoreCase(String domain);
}
