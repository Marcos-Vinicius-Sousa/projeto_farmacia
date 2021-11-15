package com.projeto_p2.farmacia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.projeto_p2.farmacia.exception.AuthorizationException;
import com.projeto_p2.farmacia.model.entities.Usuario;
import com.projeto_p2.farmacia.model.repositories.UsuarioRepository;
import com.projeto_p2.farmacia.security.JWTUtil;

@Service
public class UsuariosService implements ServiceInterface<Usuario>{

	
	@Autowired
	private UsuarioRepository repository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder; 
	
	@Autowired
	private JWTUtil jwtUtil;
	
	
	@Override
	public Usuario create(Usuario obj) {
		obj.setSenha(passwordEncoder.encode(obj.getSenha()));
		repository.save(obj);
		return obj;
	}

	@Override
	public Usuario findById(Long id) {
		if (!jwtUtil.authorized(id)) {
			throw new AuthorizationException("Acesso negado!");
		}
		Optional<Usuario> usuario = repository.findById(id);
		return usuario.orElse(null);
	}

	@Override
	public List<Usuario> findAll() {
		return repository.findAll();
	}

	@Override
	public boolean update(Usuario obj) {
		if(repository.existsById(obj.getId())) {
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
