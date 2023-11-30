package com.chedi.docteur.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chedi.docteur.entities.Patient;
import com.chedi.docteur.entities.Rendezvous;
import com.chedi.docteur.entities.Utilisateur;
import com.chedi.docteur.services.PatientService;
import com.chedi.docteur.services.RendezvousService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("rendezvous")
public class RendezvousController {
	@Autowired
	private RendezvousService rendezvousserv;
	
	@GetMapping("/getRendezvous/{id}")
	public Rendezvous getRendezvous(@PathVariable Integer id) {
		return this.rendezvousserv.getRendezvous(id);
	}
	@PostMapping("/add")
	public void save(@RequestBody Rendezvous rdv) {
		this.rendezvousserv.save(rdv);
	}
}
