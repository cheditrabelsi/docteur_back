package com.chedi.docteur.repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.chedi.docteur.entities.Patient;
import com.chedi.docteur.entities.Rendezvous;

public interface RendezvousRepository extends JpaRepository<Rendezvous, Integer> {
	List<Rendezvous> findAllByMedecinId(Integer medecinId);
	List<Rendezvous> findByDateRendezVousAndValidationAndMedecinId(LocalDate dateRendezVous, String validation,Integer id);
	List<Rendezvous> findAllByObservationIsNotNullAndMedecinId(int id);
	 @Query("SELECT COUNT(DISTINCT r.patient.id) FROM Rendezvous r WHERE r.medecin.id = :medecinId")
	    int countDistinctPatientsForMedecin(@Param("medecinId") Integer medecinId);
	 @Query("SELECT r FROM Rendezvous r WHERE r.medecin.id = :medecinId AND r.validation = 'en attente'")
	    List<Rendezvous> findRendezvousWithValidationAttenteForMedecin(@Param("medecinId") Integer medecinId);
	 @Query("SELECT DISTINCT r.patient FROM Rendezvous r WHERE r.medecin.id = :medecinId")
	    List<Patient> findAllPatientsForMedecin(@Param("medecinId") Integer medecinId);
	 List<Rendezvous> findAllByPatientId(Integer patientId);
	 @Query("SELECT r FROM Rendezvous r WHERE r.medecin.id = :medecinId AND r.validation = 'accepte'")
	    List<Rendezvous> findRendezvousWithValidationAccepteForMedecin(@Param("medecinId") Integer medecinId);
}
