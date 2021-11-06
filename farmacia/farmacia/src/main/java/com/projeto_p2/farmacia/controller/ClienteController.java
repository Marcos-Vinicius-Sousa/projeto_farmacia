package com.projeto_p2.farmacia.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto_p2.farmacia.model.entities.Cliente;

@RestController
@CrossOrigin()
@RequestMapping("/cliente")
public class ClienteController implements ControllerInterfaces<Cliente>{

	@Override
	public ResponseEntity<List<Cliente>> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> get(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Cliente> post(Cliente obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> put(Cliente obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> delete(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
