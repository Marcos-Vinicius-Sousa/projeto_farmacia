package com.projeto_p2.farmacia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto_p2.farmacia.exception.AuthorizationException;
import com.projeto_p2.farmacia.model.entities.Pedido;
import com.projeto_p2.farmacia.model.repositories.PedidoRepository;
import com.projeto_p2.farmacia.security.JWTUtil;

@Service
public class PedidoService implements ServiceInterface<Pedido>{

	@Autowired
	private PedidoRepository repository;
	
	@Autowired
	private JWTUtil jwtUtil;
	
	@Override
	public Pedido create(Pedido obj) {
		repository.save(obj);
		return obj;
	}

	@Override
	public Pedido findById(Long id) throws AuthorizationException {
		if(!jwtUtil.authorized(id)) {
			throw new AuthorizationException("Acesso negado!");
		}
		Optional<Pedido> _aluno = repository.findById(id);
		return _aluno.orElse(null);
	}

	@Override
	public List<Pedido> findAll() {
		return repository.findAll();
	}

	@Override
	public boolean update(Pedido obj) {
		if(repository.existsById(obj.getCd_Pedido())) {
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
