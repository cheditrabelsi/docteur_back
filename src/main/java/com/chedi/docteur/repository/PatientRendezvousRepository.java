package com.chedi.docteur.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chedi.docteur.entities.PatientRendezvousId;
import com.chedi.docteur.entities.Patient_rendezvous;

public interface PatientRendezvousRepository extends JpaRepository<Patient_rendezvous, PatientRendezvousId> {

}
