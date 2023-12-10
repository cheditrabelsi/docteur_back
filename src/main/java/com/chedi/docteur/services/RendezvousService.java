package com.chedi.docteur.services;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.apache.el.stream.Optional;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.chedi.docteur.entities.Patient;
import com.chedi.docteur.entities.Rendezvous;
import com.chedi.docteur.entities.Utilisateur;
import com.chedi.docteur.repository.RendezvousRepository;

@Service
public class RendezvousService {
private RendezvousRepository repo;

public RendezvousService(RendezvousRepository repo) {
	super();
	this.repo = repo;
}
public Rendezvous getRendezvous(Integer id) {
	return this.repo.getById(id);
}
public void save(Rendezvous rdv) {
	this.repo.save(rdv);
}
public List<Rendezvous> getAll(){
	return this.repo.findAll();
	}
public List<Rendezvous> getBymededin(int id_medecin){
	return this.repo.findAllByMedecinId(id_medecin);
}
public boolean exist(int id) {
	return this.repo.existsById(id);
}
public List<Rendezvous> getByDateAndValidation(@PathVariable int id) {
	LocalDate currentDate = LocalDate.now();
    return repo.findByDateRendezVousAndValidationAndMedecinId(currentDate, "accepte",id);
}
public List<Rendezvous> getPatientsWithObservationNotNull(int id) {
    return repo.findAllByObservationIsNotNullAndMedecinId( id);
}
public int countDistinctPatientsForMedecin(Integer medecinId) {
    return repo.countDistinctPatientsForMedecin(medecinId);
}
public List<Rendezvous> findRendezvousWithValidationAttenteForMedecin(Integer medecinId) {
    return repo.findRendezvousWithValidationAttenteForMedecin(medecinId);
}
public List<Rendezvous> findRendezvousWithValidationAccepteForMedecin(Integer medecinId) {
    return repo.findRendezvousWithValidationAccepteForMedecin(medecinId);
}
public List<Patient> findAllPatientsForMedecin(Integer medecinId) {
    return repo.findAllPatientsForMedecin(medecinId);
}
public List<Rendezvous> findAllRendezvousForPatient(Integer patientId) {
    return repo.findAllByPatientId(patientId);
}
}
