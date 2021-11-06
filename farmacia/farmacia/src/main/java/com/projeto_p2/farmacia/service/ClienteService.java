package com.projeto_p2.farmacia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto_p2.farmacia.security.JWTUtil;
import com.projeto_p2.farmacia.exception.AuthorizationException;
import com.projeto_p2.farmacia.model.entities.Cliente;
import com.projeto_p2.farmacia.model.repositories.ClienteRepository;

@Service
public class ClienteService implements ServiceInterface<Cliente>{

	@Autowired
	private ClienteRepository repository;
	
	@Autowired
	private JWTUtil jwtUtil;
	
	
	@Override
	public Cliente create(Cliente obj) {
		repository.save(obj);
		return obj;
	}

	@Override
	public Cliente findById(Long id) throws AuthorizationException {
		if(!jwtUtil.authorized(id)) {
			throw new AuthorizationException("Acesso negado!");
		}
		Optional<Cliente> _aluno = repository.findById(id);
		return _aluno.orElse(null);
	}

	@Override
	public List<Cliente> findAll() {
		return repository.findAll();
	}

	@Override
	public boolean update(Cliente obj) {
		if(repository.existsById(obj.getCd_cliente())) {
			repository.save(obj);
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(Long id) {
		if(repository.existsById(id)) {
			repository.deleteById(id);
			return true;
		}
			return false;
	}

}
