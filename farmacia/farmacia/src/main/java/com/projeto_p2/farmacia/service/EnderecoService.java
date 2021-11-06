package com.projeto_p2.farmacia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto_p2.farmacia.exception.AuthorizationException;
import com.projeto_p2.farmacia.model.entities.Endereco;
import com.projeto_p2.farmacia.model.repositories.EnderecoRepository;
import com.projeto_p2.farmacia.security.JWTUtil;

@Service
public class EnderecoService implements ServiceInterface<Endereco>{

	@Autowired
	private EnderecoRepository repository;
	
	@Autowired
	private JWTUtil jwtUtil;
	
	@Override
	public Endereco create(Endereco obj) {
		repository.save(obj);
		return obj;
	}

	@Override
	public Endereco findById(Long id) throws AuthorizationException {
		if(!jwtUtil.authorized(id)) {
			throw new AuthorizationException("Acesso negado!");
		}
		Optional<Endereco> _endereco = repository.findById(id);
		return _endereco.orElse(null);
	}

	@Override
	public List<Endereco> findAll() {
		return repository.findAll();
	}

	@Override
	public boolean update(Endereco obj) {
		if(repository.existsById(obj.getCd_Endereco())) {
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
