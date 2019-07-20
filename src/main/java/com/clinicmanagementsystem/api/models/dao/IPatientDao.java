package com.clinicmanagementsystem.api.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.clinicmanagementsystem.api.models.entities.Patient;

public interface IPatientDao extends CrudRepository<Patient, Long> {

}
