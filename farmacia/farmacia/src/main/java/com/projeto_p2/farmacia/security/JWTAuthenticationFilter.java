package com.projeto_p2.farmacia.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.naming.AuthenticationException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.projeto_p2.farmacia.model.entities.Usuario;
import com.projeto_p2.farmacia.model.repositories.UsuarioRepository;
import com.projeto_p2.farmacia.dto.CredenciaisDTO;
//import com.projeto_p2.farmacia.security.JWTUtil;
//import com.projeto_p2.farmacia.security.UserDetailsImpl;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter{
	
	private AuthenticationManager authenticationManager;
	private JWTUtil jwtUtil;
	
	@Autowired
	private UsuarioRepository _users;
	
	
	public JWTAuthenticationFilter(AuthenticationManager authenticationManager, JWTUtil jwtUtil , UsuarioRepository _users) {
		this.authenticationManager = authenticationManager;
		this.jwtUtil = jwtUtil;	
		this._users = _users;
	}
	
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) {
		try {
			CredenciaisDTO creds = new ObjectMapper().readValue(request.getInputStream(), CredenciaisDTO.class);
			UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(creds.getLogin(),
					creds.getSenha(), new ArrayList<>());
			Authentication auth = authenticationManager.authenticate(authToken);
			return auth;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	@Override
	protected void successfulAuthentication( HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		String username = ((UserDetailsImpl) authResult.getPrincipal()).getUsername();
		String token = jwtUtil.generateToken(username);
		response.addHeader("Authentication", "Bearer " + token);
		response.addHeader("access-control-expose-headers", "Authorization");
		Usuario user = (Usuario) _users.findByLogin(username);
		user.setSenha(null);
		/*Gson gson = new Gson();
		String cliStr = gson.toJson(user);
		PrintWriter out = response.getWriter();
			
        	response.setContentType("application/json");
        	response.setCharacterEncoding("UTF-8");
        	out.print(cliStr);
        	out.print("Bearer " + token);
       		out.flush(); */


		String json = "{\"Auth\":\"Bearer " + token.toString() + "\","
						+ "\"userId\":\""+ user.getId() + "\","
						+"\"userPerfil\":\""+ user.getPerfis()+"\","
						+"\"userLogin\":\""+ user.getLogin() + "\""
						+ "}";
		response.getWriter().append(json); 
		
	}

	

	

	protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException failed) throws java.io.IOException, javax.servlet.ServletException {
		response.setStatus(401);
		response.setContentType("application/json");
		response.getWriter().append(json());
	}
	
	
	private String json() {
		return "{\"timestamp\": " + new Date().getTime() + ", " 
				+ "\"status\": 401, "
				+ "\"error\": \"Não autorizado\", " 
				+ "\"message\": \"Email ou senha inválidos\", "
				+ "\"path\": \"/login\"}";
	}
	


	

	
}
