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
import com.chedi.docteur.entities.Patient_rendezvous;
import com.chedi.docteur.entities.Utilisateur;
import com.chedi.docteur.services.PatientRendezvousService;
import com.chedi.docteur.services.PatientService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("patientrendezvous")
public class Patient_rendezvoudController {
	@Autowired
	private PatientRendezvousService patientrendezvousserv;
	
	@GetMapping("/getPatient/{patientid}/{rendezvousid}")
	public Patient_rendezvous getPatientRendezvous(@PathVariable Integer patientid,@PathVariable Integer rendezvousid) {
		return this.patientrendezvousserv.getPatient_rendezvous(patientid,rendezvousid);
	}
	@PostMapping("/add")
	public void save(@RequestBody Patient_rendezvous u) {
		this.patientrendezvousserv.save(u);
	}
}
