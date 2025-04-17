package com.pets.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pets.entities.Pet;
import com.pets.service.PetService;

@RestController
@RequestMapping("/pet")
public class PetController {
	private final PetService petService;

	public PetController(PetService petService) {
		this.petService = petService;
	}

	@GetMapping("/")
	public ResponseEntity<List<Pet>>getAllPet(){
		List<Pet> pet = petService.getAllPet();
		return ResponseEntity.ok(pet);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Pet>getPetById(@PathVariable Long id){
		Pet pet = petService.getPetById(id);
		if(pet != null) {
			return ResponseEntity.ok(pet);
		}else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping("/")
	public ResponseEntity<Pet>criarPet(@RequestBody Pet pet){
		Pet criarPet = petService.savePet(pet);
		return ResponseEntity.status(HttpStatus.CREATED).body(criarPet);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Pet>alteraPet(@PathVariable Long id, @RequestBody Pet pet){
		Pet alteraPet = petService.alteraPet(id, pet);
		if(alteraPet != null) {
			return ResponseEntity.ok(alteraPet);
		}else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
		public ResponseEntity<String>deletePet(@PathVariable Long id){
			boolean delete = petService.deletePet(id);
			if(delete) {
				return ResponseEntity.ok().body("Pet excluído com sucesso");
			}else {
				return ResponseEntity.notFound().build();
			}
		}
	}
