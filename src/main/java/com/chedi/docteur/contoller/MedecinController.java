package com.chedi.docteur.contoller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.chedi.docteur.services.UtilisateurService;

import jakarta.persistence.EntityNotFoundException;

@CrossOrigin(origins = "http://localhost:4200",allowCredentials = "true")
@RestController
@RequestMapping("medecin")
public class MedecinController {
	@Autowired
	private MedecinService medecinserv;
	@Autowired
	private UtilisateurService userserv;
	@Autowired
	private BCryptPasswordEncoder BCryptPasswordEncoder;
	@GetMapping("/getMedecin/{email}")
	public ResponseEntity<Object> getMedecin(@PathVariable String email) {
	    try {
	        Medecin medecin = this.medecinserv.getMedecin(email);
	        if (medecin != null) {
	        	Map<String, String> successResponse = new HashMap<>();
                successResponse.put("message", "user exist");

                return new ResponseEntity<>(successResponse, HttpStatus.OK);
	        } else {
	        	Map<String, String> errorResponse = new HashMap<>();
                errorResponse.put("message", "User not found");

                return new ResponseEntity<>(errorResponse, HttpStatus.UNAUTHORIZED);
	        }
	    } catch (Exception e) {
	    	Map<String, String> errorResponse = new HashMap<String, String>();
	        errorResponse.put("error", "An error occurred");
	        errorResponse.put("message", e.getMessage());
	        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	    }

	}
	@GetMapping("/getAll")
	public ResponseEntity<Object> getAll() {
	    try {
	        List<Medecin> medecin = this.medecinserv.getAll();
	        if (medecin != null) {
	            return new ResponseEntity<>(medecin, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>("List not found", HttpStatus.NOT_FOUND);
	        }
	    } catch (Exception e) {
	        return new ResponseEntity<>("An error occurred: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	@PostMapping("/add")
	public ResponseEntity<Object> register(@RequestBody Medecin m) {
		   try {
		        if (!userserv.exist(m.getEmail())) {
		            String hashedPassword = this.BCryptPasswordEncoder.encode(m.getMdp());
		            m.setMdp(hashedPassword);
		            
		            if (medecinserv.save(m) !="null") {
		            	Map<String, String> successResponse = new HashMap<>();
		                successResponse.put("message", "medecin add with succes");
		                return new ResponseEntity<>(successResponse, HttpStatus.OK);
		            } else {
		            	System.out.print(medecinserv.save(m));
		            	Map<String, String> successResponse = new HashMap<>();
		                successResponse.put("message", "medecin not added");
		                return new ResponseEntity<>(successResponse, HttpStatus.BAD_REQUEST);
		            }
		        } else {
		        	Map<String, String> successResponse = new HashMap<>();
	                successResponse.put("message", "email already exist");
	                return new ResponseEntity<>(successResponse, HttpStatus.CONFLICT);
		        }
		    } catch (Exception e) {
		        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
		    }
		}
}
