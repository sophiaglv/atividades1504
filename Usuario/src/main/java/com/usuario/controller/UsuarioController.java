package com.usuario.controller;

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

import com.usuario.entities.Usuario;
import com.usuario.service.UsuarioService;

@RequestMapping("/usuario")
@RestController
public class UsuarioController {
	private final UsuarioService usuarioService;
	
	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Usuario>>getAllUsuario(){
		List<Usuario> usuario = usuarioService.getAllUsuario();
		return ResponseEntity.ok(usuario);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuario>getUsuarioById(@PathVariable Long id){
		Usuario usuario = usuarioService.getUsuarioById(id);
		if(usuario != null) {
			return ResponseEntity.ok(usuario);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping("/")
	public ResponseEntity<Usuario>createUsuario(@RequestBody Usuario usuario){
		Usuario createUsuario = usuarioService.saveUsuario(usuario);
		return ResponseEntity.status(HttpStatus.CREATED).body(createUsuario);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Usuario>alteraUsuario(@PathVariable Long id, @RequestBody Usuario usuario){
		Usuario alteraUsuario = usuarioService.alteraUsuario(id, usuario);
		if(alteraUsuario != null) {
			return ResponseEntity.ok(alteraUsuario);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String>deleteUsuario(@PathVariable Long id){
		boolean delete = usuarioService.deleteUsuario(id);
		if(delete) {
			return ResponseEntity.ok().body("Usuario deletado com sucesso!");
			}else {
				return ResponseEntity.notFound().build();
		}
	}
}
