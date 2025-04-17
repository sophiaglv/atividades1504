package com.show.controller;

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

import com.show.entities.Show;
import com.show.service.ShowService;

@RestController
@RequestMapping("/show")
public class ShowController {
	private final ShowService showService;

	public ShowController(ShowService showService) {
		this.showService = showService;
	}

	@GetMapping("/")
	public ResponseEntity<List<Show>>getAllShow(){
		List<Show> shows = showService.getAllShow();
		return ResponseEntity.ok(shows);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Show>getShowById(@PathVariable Long id){
		Show show = showService.getShowById(id);
		if(show != null) {
			return ResponseEntity.ok(show);
		}else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping("/")
	public ResponseEntity<Show>criarShow(@RequestBody Show show){
		Show criarShow = showService.saveShow(show);
		return ResponseEntity.status(HttpStatus.CREATED).body(criarShow);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Show>alteraShow(@PathVariable Long id, @RequestBody Show show){
		Show alteraShow = showService.alteraShow(id, show);
		if(alteraShow != null) {
			return ResponseEntity.ok(alteraShow);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String>deleteShow(@PathVariable Long id){
		boolean delete = showService.deleteShow(id);
		if(delete) {
			return ResponseEntity.ok().body("Show excluído com sucesso");
		}else {
			return ResponseEntity.notFound().build();
		}
	}
}
