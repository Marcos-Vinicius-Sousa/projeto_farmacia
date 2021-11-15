package com.projeto_p2.farmacia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto_p2.farmacia.exception.AuthorizationException;
import com.projeto_p2.farmacia.model.entities.Cliente;
import com.projeto_p2.farmacia.service.ClienteService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@CrossOrigin()
@RequestMapping("/cliente")
public class ClienteController implements ControllerInterfaces<Cliente>{

	@Autowired
	private ClienteService service;
	
	
	
	@Override
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200",
			description = "Retorna a lista de alunos"),
			@ApiResponse(responseCode = "403",
			description = "Você não tem permissão para acessar este recurso"),
			@ApiResponse(responseCode = "500",
			description = "Foi gerada uma exceção"),
			})
	@Operation(summary = "Devolve a lista de todos os clientes")
	@GetMapping(produces ="application/json")
	public ResponseEntity<List<Cliente>> getAll() {
		return ResponseEntity.ok(service.findAll());
	}

	@Override
	@Operation(summary = "Devolve o aluno dado seu id")
	@GetMapping(value="/{id}", produces ="application/json")
	public ResponseEntity<?> get(@PathVariable("id") Long id) {
		try {
		Cliente _cliente = service.findById(id);
		if(_cliente != null) {
			return ResponseEntity.ok(_cliente);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}catch (AuthorizationException e) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
	}

	@Override
	@PostMapping(produces ="application/json")
	@Operation(summary = "Grava um novo cliente")
	public ResponseEntity<Cliente> post(@RequestBody Cliente obj) {
		service.create(obj);
		return ResponseEntity.ok(obj);
	}


	@Override
	@PutMapping(produces ="application/json")
	@Operation(summary = "Atualiza os dados de um cliente")
	public ResponseEntity<?> put(@RequestBody Cliente obj) {
		if(service.update(obj)) {
			return ResponseEntity.ok(obj);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	@Override
	@PreAuthorize("hasAnyRole('ADMIN')")
	@DeleteMapping(value="/{id}")
	@Operation(summary = "Exclui um cliente")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		if(service.delete(id)) {
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

}
