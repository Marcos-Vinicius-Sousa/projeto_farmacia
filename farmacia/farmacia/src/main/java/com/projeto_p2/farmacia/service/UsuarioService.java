package com.projeto_p2.farmacia.service;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.projeto_p2.farmacia.security.UserDetailsImpl;

@Service
public class UsuarioService {

	public static UserDetailsImpl authenticated() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			return (UserDetailsImpl) auth.getPrincipal();
		}
		return null;
	}
}
