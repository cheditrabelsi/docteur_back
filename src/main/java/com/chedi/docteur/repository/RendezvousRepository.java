package com.chedi.docteur.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chedi.docteur.entities.Rendezvous;

public interface RendezvousRepository extends JpaRepository<Rendezvous, Integer> {

}
