package com.chedi.docteur.contoller;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chedi.docteur.entities.Medecin;
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
	
	@GetMapping("/getAllRendezvous/{id}")
	public ResponseEntity<Object> allrendezvousBymedecin(@PathVariable int id) {
	    try {
	        List<Rendezvous> allRendezvous = this.rendezvousserv.getBymededin(id);
	        if (allRendezvous != null && !allRendezvous.isEmpty()) {
	            Map<String, Object> response = new HashMap<>();
	            response.put("message", "Rendezvous found for the medecin");
	            response.put("rendezvousList", allRendezvous);
	            return new ResponseEntity<>(response, HttpStatus.OK);
	        } else {
	            Map<String, String> response = new HashMap<>();
	            response.put("message", "Aucun rendezvous pour ce medecin");
	            return new ResponseEntity<>(response, HttpStatus.OK);
	        }
	    } catch (Exception e) {
	        return new ResponseEntity<>("An error occurred: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}

	@GetMapping("/getAll")
	public List<Rendezvous> getAll() {
		return this.rendezvousserv.getAll();
	}
	@GetMapping("/getAllPatientExamine/{id}")
	public List<Rendezvous> getAllPatient(@PathVariable int id) {
		return this.rendezvousserv.getPatientsWithObservationNotNull(id);
	}
	@PostMapping("/add")
	public ResponseEntity<Object> save(@RequestBody Rendezvous rdv) {
		   try {  
			   System.out.print("date="+rdv.getDateRendezVous());
		         this.rendezvousserv.save(rdv);
		         Map<String, String> successResponse = new HashMap<>();
	                successResponse.put("message", "rendezvous saved");

	                return new ResponseEntity<>(successResponse, HttpStatus.OK);
		    } catch (Exception e) {
		        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
		    }
		}
	@PutMapping("/accepte")
	 public ResponseEntity<Object> accepte(@RequestBody Rendezvous rdv) {
		try {
	        if (this.rendezvousserv.exist(rdv.getId_rendezvous())) {
	        	rdv.setValidation("accepte");
	            this.rendezvousserv.save(rdv);
	            return new ResponseEntity<>("rendezvous updated",HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
	        }
	    } catch (Exception e) {
	        return new ResponseEntity<>("An error occurred: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	    }
		} 
	@PutMapping("/refuse")
	 public ResponseEntity<Object> refuse(@RequestBody Rendezvous rdv) {
		try {
	        if (this.rendezvousserv.exist(rdv.getId_rendezvous())) {
	        	rdv.setValidation("annuler");
	            this.rendezvousserv.save(rdv);
	            return new ResponseEntity<>("rendezvous updated",HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
	        }
	    } catch (Exception e) {
	        return new ResponseEntity<>("An error occurred: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	    }
		} 
	@PutMapping("/observation/{id}")
	 public ResponseEntity<Object> creerObservation(@PathVariable int id, @RequestBody String observation) {
		try {
			Rendezvous rdv=new Rendezvous();
	        if (this.rendezvousserv.exist(id)) {
	        	rdv=this.rendezvousserv.getRendezvous(id);
	        	rdv.setObservation(observation);
	            this.rendezvousserv.save(rdv);
	            return new ResponseEntity<>("rendezvous updated",HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>("rendezvous not found", HttpStatus.NOT_FOUND);
	        }
	    } catch (Exception e) {
	        return new ResponseEntity<>("An error occurred: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	    }
		} 
	@GetMapping("/currentDateAndValidation/{id}")
    public List<Rendezvous> getByDateAndValidation(@PathVariable int id) {
        LocalDate currentDate = LocalDate.now();
       
        return this.rendezvousserv.getByDateAndValidation(id);
    }
	@GetMapping("/nbrePatient/{id}")
    public int getNbrePatientBymedecin(@PathVariable int id) {
        return this.rendezvousserv.countDistinctPatientsForMedecin(id);
    }
	@GetMapping("/demande/{id}")
    public List<Rendezvous> getLesDemande(@PathVariable int id) {
        return this.rendezvousserv.findRendezvousWithValidationAttenteForMedecin(id);
    }
	@GetMapping("/lesAcceptes/{id}")
    public List<Rendezvous> getLesAcceptes(@PathVariable int id) {
        return this.rendezvousserv.findRendezvousWithValidationAccepteForMedecin(id);
    }
	@GetMapping("/allPatientForMedecin/{id}")
	public List<Patient> findAllPatientsForMedecin(@PathVariable int id){
		return this.rendezvousserv.findAllPatientsForMedecin(id);
	}
	@GetMapping("/allRendezVousByPatient/{id}")
	public List<Rendezvous> findallRendezVousByPatient(@PathVariable int id){
		return this.rendezvousserv.findAllRendezvousForPatient(id);
	}
}
