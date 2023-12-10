package com.chedi.docteur.services;

import java.util.Date;
import java.sql.Time;
import java.util.List;

import org.springframework.stereotype.Service;

import com.chedi.docteur.entities.DateDeTravail;
import com.chedi.docteur.entities.Medecin;
import com.chedi.docteur.repository.DateDeTravailRepository;

@Service
public class DatedeTravailService {
	private DateDeTravailRepository repo;

	public DatedeTravailService(DateDeTravailRepository repo) {
		super();
		this.repo = repo;
	}
	
	public List<DateDeTravail> getDateDeTravail(int id) {
		Medecin medecin=new Medecin();
		medecin.setId(id);
		return this.repo.findByMedecin(medecin);
	}
	public DateDeTravail ajouter(DateDeTravail dtv) {
		return this.repo.save(dtv);
	}
	public List<DateDeTravail> getAll(){
		return this.repo.findAll();
	}
	public void deleteDateDeTravailByDatesAndTimes(Date jourDebut, Date jourFin, Time heureDebut, Time heureFin, int medecinId) {
	    this.repo.deleteByDatesAndTimesAndMedecinId(jourDebut, jourFin, heureDebut, heureFin, medecinId);
	}


}
