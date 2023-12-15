package com.chedi.docteur.contoller;
import java.util.HashMap;
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

	@PostMapping("/add")
	public ResponseEntity<Object> register(@RequestBody Patient p) {
		 try {
		        if (!userserv.exist(p.getEmail())) {
		            String hashedPassword = this.BCryptPasswordEncoder.encode(p.getMdp());
		            p.setMdp(hashedPassword);
		            
		            if (patientserv.save(p) !="null") {
		            	Map<String, String> successResponse = new HashMap<>();
		                successResponse.put("message", "patient add with succes");
		                return new ResponseEntity<>(successResponse, HttpStatus.OK);
		            } else {
		            	System.out.print(patientserv.save(p));
		            	Map<String, String> successResponse = new HashMap<>();
		                successResponse.put("message", "patient not added");
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
