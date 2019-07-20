package com.clinicmanagementsystem.api.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.clinicmanagementsystem.api.models.dao.IClinicDao;
import com.clinicmanagementsystem.api.models.entities.Clinic;
import org.springframework.stereotype.Service;

@Service
public class ClinicService implements IClinicService {
	
	@Autowired
	private IClinicDao clinicDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Clinic> findAll() {
		return (List<Clinic>) clinicDao.findAll();
	}

	@Override
	public void save(Clinic clinic) {
		clinicDao.save(clinic);
	}

	@Override
	@Transactional(readOnly = true)
	public Clinic findById(Long id) {
		return clinicDao.findById(id).orElse(null);
	}

	@Override
	public void deleteById(Long id) {
		clinicDao.deleteById(id);
	}

}
