package com.pets.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pets.entities.Pet;

public interface PetRepository extends JpaRepository<Pet, Long>{

}
