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
import com.chedi.docteur.services.MedecinService;

import jakarta.persistence.EntityNotFoundException;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("medecin")
public class MedecinController {
	@Autowired
	private MedecinService medecinserv;
	@Autowired
	private BCryptPasswordEncoder BCryptPasswordEncoder;
	@GetMapping("/getMedecin/{email}/{pwd}")
	public ResponseEntity<Object> getMedecin(@PathVariable String email,@PathVariable String pwd) {
	    try {
	        Medecin medecin = this.medecinserv.getMedecin(email,pwd);
	        if (medecin != null) {
	            return new ResponseEntity<>(medecin, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>("Medecin not found", HttpStatus.NOT_FOUND);
	        }
	    } catch (Exception e) {
	        return new ResponseEntity<>("An error occurred: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	@PostMapping("/add")
	public ResponseEntity<Object> register(@RequestBody Medecin m) {
	    try {
	        String hashedPassword = this.BCryptPasswordEncoder.encode(m.getMdp());
	        m.setMdp(hashedPassword);
	        
	        if (medecinserv.save(m) > 0) {
	            return ResponseEntity.ok("medecin was saved");
	        } else {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error while registration");
	        }
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
	    }
	}
}