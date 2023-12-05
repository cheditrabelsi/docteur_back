package com.chedi.docteur.contoller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chedi.docteur.entities.Medecin;
import com.chedi.docteur.entities.Patient;
import com.chedi.docteur.entities.Utilisateur;
import com.chedi.docteur.services.MedecinService;
import com.chedi.docteur.services.PatientService;
import com.chedi.docteur.services.UtilisateurService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("patient")
public class PatientController {
	@Autowired
	private PatientService patientserv;
	@Autowired
	private UtilisateurService userserv;
	@Autowired
	private BCryptPasswordEncoder BCryptPasswordEncoder;
	@GetMapping("/getPatient/{email}")
	public ResponseEntity<Object> getPatient(@PathVariable String email) {
	    try {
	        Patient patient = this.patientserv.getPatient(email);
	        if (patient != null) {
	            return new ResponseEntity<>(patient, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>("Patient not found", HttpStatus.NOT_FOUND);
	        }
	    } catch (Exception e) {
	        return new ResponseEntity<>("An error occurred: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}

	@PostMapping("/add")
	public ResponseEntity<Object> register(@RequestBody Patient p) {
	    try {
	        if (!userserv.exist(p.getEmail())) {
	            String hashedPassword = this.BCryptPasswordEncoder.encode(p.getMdp());
	            p.setMdp(hashedPassword);

	            if (patientserv.save(p) > 0) {
	                return ResponseEntity.ok("Patient was saved");
	            } else {
	                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error while registration");
	            }
	        } else {
	            return new ResponseEntity<>("Patient with this email already exists", HttpStatus.CONFLICT);
	        }
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
	    }
	}

}
