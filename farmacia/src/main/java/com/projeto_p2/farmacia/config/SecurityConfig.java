package com.projeto_p2.farmacia.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.projeto_p2.farmacia.model.repositories.UsuarioRepository;
import com.projeto_p2.farmacia.security.JWTAuthenticationFilter;
import com.projeto_p2.farmacia.security.JWTAuthorizationFilter;
import com.projeto_p2.farmacia.security.JWTUtil;



@EnableWebSecurity
@Configuration	
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private JWTUtil jwtUtil;
	
	@Autowired
	private UsuarioRepository user;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	private static final String[] PUBLIC_MATCHERS = {
			
			"/cliente/**",
			"/funcionacio/**",
			"/fornecedor/**",
			"/estoque/**",
			"/materiaprima/**",
			"/pedido/**",
			"/usuario/**"
			
			
	};
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable();
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.authorizeRequests()
		.antMatchers(HttpMethod.GET, PUBLIC_MATCHERS).permitAll()
		.antMatchers(HttpMethod.POST, PUBLIC_MATCHERS).permitAll()
		.antMatchers("/v3/api-docs/**", "/swagger-ui/**",
				"/swagger-ui.html").permitAll()
		.anyRequest().authenticated();
		http.addFilter(new JWTAuthenticationFilter(authenticationManager(), jwtUtil , user	));
		http.addFilter(new JWTAuthorizationFilter(authenticationManager(), jwtUtil,
				userDetailsService));
		} 
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {	
		auth.userDetailsService(userDetailsService)
		    .passwordEncoder(bCryptPasswordEncoder());
	} 
	
	
	
	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		/*final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
		return source;*/
		
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration();
		config.addAllowedOrigin("https://curso-java-hsvg9u.stackblitz.io");
		config.addAllowedMethod("GET");
		config.addAllowedMethod("PUT");
		config.addAllowedMethod("POST");
		config.addAllowedMethod("OPTIONS");
		config.addAllowedMethod("DELETE");
		config.addAllowedHeader("Authorization");
		config.addAllowedHeader("Content-Type");
		source.registerCorsConfiguration("/**", config);
		return source; 
	}
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
}
