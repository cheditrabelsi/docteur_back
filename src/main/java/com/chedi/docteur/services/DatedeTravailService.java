package com.chedi.docteur.services;

import org.springframework.stereotype.Service;

import com.chedi.docteur.entities.DateDeTravail;
import com.chedi.docteur.repository.DateDeTravailRepository;

@Service
public class DatedeTravailService {
	private DateDeTravailRepository repo;

	public DatedeTravailService(DateDeTravailRepository repo) {
		super();
		this.repo = repo;
	}
	
	public DateDeTravail getDateDeTravail(int id) {
		return this.repo.getById(id);
	}
	public DateDeTravail ajouter(DateDeTravail dtv) {
		return this.repo.save(dtv);
	}

}
