package com.chedi.docteur.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chedi.docteur.entities.Patient;
import com.chedi.docteur.entities.Rendezvous;
import com.chedi.docteur.entities.Specialite;
import com.chedi.docteur.services.RendezvousService;
import com.chedi.docteur.services.SpecialiteService;

@CrossOrigin(origins = "http://localhost:4200",allowCredentials = "true")
@RestController
@RequestMapping("specialite")
public class SpecialiteController {
	@Autowired
	private SpecialiteService specialiteserv;
	@GetMapping("/getAll")
	public ResponseEntity<Object> getSpeciality() {
		try {
	        List<Specialite> list=this.specialiteserv.getAll();
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
	public void save(@RequestBody Specialite sp) {
		this.specialiteserv.save(sp);
	}
}
