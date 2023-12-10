package com.chedi.docteur.contoller;

import java.util.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.chedi.docteur.entities.DateDeTravail;
import com.chedi.docteur.entities.Medecin;
import com.chedi.docteur.entities.Specialite;
import com.chedi.docteur.services.DatedeTravailService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("datedetravail")
public class DateDeTravailController {
	@Autowired
private DatedeTravailService service;

	public DateDeTravailController(DatedeTravailService service) {
		super();
		this.service = service;
	}
	@GetMapping("/getTravail/{id_medecin}")
	public ResponseEntity<?> getDateDetravail(@PathVariable Integer id_medecin) {
		try {
	        List<DateDeTravail> list=this.service.getDateDeTravail(id_medecin);
	        if (list != null) {
	            return new ResponseEntity<>(list, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>("list not found", HttpStatus.NOT_FOUND);
	        }
	    } catch (Exception e) {
	        return new ResponseEntity<>("An error occurred: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	@GetMapping("/getAll")
	public ResponseEntity<?> getAll(){
		try {
	        List<DateDeTravail> list=this.service.getAll();
	        if (list != null) {
	            return new ResponseEntity<>(list, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>("list not found", HttpStatus.NOT_FOUND);
	        }
	    } catch (Exception e) {
	        return new ResponseEntity<>("An error occurred: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	@GetMapping("/getReserve/")
	public ResponseEntity<?> getReserve(){
		try {
	        List<DateDeTravail> list=this.service.getAll();
	        if (list != null) {
	            return new ResponseEntity<>(list, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>("list not found", HttpStatus.NOT_FOUND);
	        }
	    } catch (Exception e) {
	        return new ResponseEntity<>("An error occurred: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
	@PostMapping("/add")
	public void save(@RequestBody DateDeTravail dtv) {

	    this.service.ajouter(dtv);
	}
	@DeleteMapping("delete/{jourDebut}/{jourFin}/{heureDebut}/{heureFin}/id")
	public String deleteDateDeTravailByDatesAndTimes(@PathVariable String jourDebut,
            @PathVariable String jourFin,
            @PathVariable String heureDebut,
            @PathVariable String heureFin,
            @PathVariable int id) {

SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");

try {
Date dateJourDebut = dateFormat.parse(jourDebut);
Date dateJourFin = dateFormat.parse(jourFin);
Time timeHeureDebut = new Time(timeFormat.parse(heureDebut).getTime());
Time timeHeureFin = new Time(timeFormat.parse(heureFin).getTime());
int id_medecin=id;
this.service.deleteDateDeTravailByDatesAndTimes(dateJourDebut, dateJourFin, timeHeureDebut, timeHeureFin,id_medecin);
return "Deletion successful";
} catch (ParseException e) {
e.printStackTrace();
return "Invalid date or time format";
}
}
	}

