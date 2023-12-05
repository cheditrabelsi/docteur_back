package com.chedi.docteur.contoller;

import java.util.Optional;

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
@RequestMapping("utilisateur")
public class UtilisateurController {
	
	@Autowired
	private UtilisateurService userserv; 
	@Autowired
	private BCryptPasswordEncoder BCryptPasswordEncoder;
	@GetMapping("/login/{email}/{mdp}")
	public ResponseEntity<Object> login(@PathVariable String email, @PathVariable String mdp) {
	    try {
	        Optional<Utilisateur> user = this.userserv.getUtilisateur(email);
	        if (user.isPresent()) {
	            if (BCryptPasswordEncoder.matches(mdp, user.get().getMdp())) {
	                return new ResponseEntity<>(user.get(), HttpStatus.OK);
	            } else {
	                return new ResponseEntity<>("Password not correct", HttpStatus.UNAUTHORIZED);
	            }
	        } else {
	            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
	        }
	    } catch (Exception e) {
	        return new ResponseEntity<>("An error occurred: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}

}
