package com.projeto_p2.farmacia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto_p2.farmacia.exception.AuthorizationException;
import com.projeto_p2.farmacia.model.entities.Estoque;
import com.projeto_p2.farmacia.model.repositories.EstoqueRepository;
import com.projeto_p2.farmacia.security.JWTUtil;

@Service
public class EstoqueService implements ServiceInterface<Estoque>{

	@Autowired
	private EstoqueRepository repository;
	
	@Autowired
	private JWTUtil jwtUtil;
	
	@Override
	public Estoque create(Estoque obj) {
		repository.save(obj);
		return obj;
	}

	@Override
	public Estoque findById(Long id) throws AuthorizationException {
		if(!jwtUtil.authorized(id)) {
			throw new AuthorizationException("Acesso negado!");
		}
		Optional<Estoque> _estoque = repository.findById(id);
		return _estoque.orElse(null);
	}

	@Override
	public List<Estoque> findAll() {
		return repository.findAll();
	}

	@Override
	public boolean update(Estoque obj) {
		if(repository.existsById(obj.getCd_Estoque())) {
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
