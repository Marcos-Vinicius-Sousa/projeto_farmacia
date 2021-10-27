package com.projeto_p2.farmacia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.projeto_p2.farmacia.model.entities.Usuario;
import com.projeto_p2.farmacia.model.repositories.UsuarioRepository;
import com.projeto_p2.farmacia.security.UserDetailsImpl;


@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private UsuarioRepository repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = repo.findByLogin(username);
		if(usuario == null) {
			throw new UsernameNotFoundException("Usuário não encontrado");
		}
		return new UserDetailsImpl(usuario.getId(),usuario.getLogin(), usuario.getSenha(), usuario.getPerfis());
	}

}