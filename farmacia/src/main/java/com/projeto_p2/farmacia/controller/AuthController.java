package com.projeto_p2.farmacia.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto_p2.farmacia.service.UsuarioService;
import com.projeto_p2.farmacia.security.UserDetailsImpl;
import com.projeto_p2.farmacia.security.JWTUtil;

@RestController
@CrossOrigin()
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
	private JWTUtil jwtUtil;
	
	@PostMapping(value = "/refresh_token")
	public ResponseEntity<Void> refreshToken(HttpServletResponse response) {
		UserDetailsImpl user = UsuarioService.authenticated();
		if (user != null) {
			String token = jwtUtil.generateToken(user.getUsername());
			response.addHeader("Authorization", "Bearer " + token);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
	}

}
