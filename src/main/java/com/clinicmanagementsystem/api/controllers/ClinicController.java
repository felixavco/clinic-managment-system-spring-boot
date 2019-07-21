package com.clinicmanagementsystem.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clinicmanagementsystem.api.models.entities.Clinic;
import com.clinicmanagementsystem.api.models.services.IClinicService;

@RestController
@RequestMapping({"/api/clinic"})
public class ClinicController {

	@Autowired
	private IClinicService clinicService;
	
	@GetMapping(name = "/all", produces = "application/json")
	public List<Clinic> getList() {
		return clinicService.findAll();
	}
	
	@GetMapping(name = "/{id}", produces = "application/json")
	public Clinic getId(@PathVariable Long id) {
		return clinicService.findById(id);
	}
	
	@GetMapping(name = "/{domain}", produces = "application/json")
	public Clinic getByDomain(@PathVariable String domain) {
		return clinicService.findByDomain(domain);
	}
	
	@PostMapping(name = "/save")
	public void saveOne(Clinic clinic) {
		clinicService.save(clinic);
	}
	
}
