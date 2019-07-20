package com.clinicmanagementsystem.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clinicmanagementsystem.api.models.entities.Clinic;
import com.clinicmanagementsystem.api.models.services.IClinicService;

@RestController
@RequestMapping({ "/api/clinic", "/api/clinics" })
public class ClinicController {

	@Autowired
	private IClinicService clinicService;
	
	@GetMapping(name = "/", produces = "application/json")
	public List<Clinic> getClinicsList() {
		return clinicService.findAll();
	}
	
	@PostMapping(name = "/save")
	public void saveClinic(Clinic clinic) {
		clinicService.save(clinic);
	}
        
//        @GetMapping(name = "/test", produces = "application/json")
//        public String testRoute(){
//            return "This is a test route, if you see this is because is working";
//        }
	
	
}
