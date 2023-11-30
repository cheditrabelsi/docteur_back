package com.chedi.docteur.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chedi.docteur.entities.DateDeTravail;
import com.chedi.docteur.entities.Medecin;
import com.chedi.docteur.services.DatedeTravailService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("datedetravail")
public class DateDetravailController {
	@Autowired
private DatedeTravailService service;

	public DateDetravailController(DatedeTravailService service) {
		super();
		this.service = service;
	}
	@GetMapping("/getTravail/{id}")
	public DateDeTravail getDateDetravail(@PathVariable Integer id) {
		return this.service.getDateDeTravail(id);
	}
	@PostMapping("/add")
	public void save(@RequestBody DateDeTravail dtv) {
		this.service.ajouter(dtv);
	}
}
