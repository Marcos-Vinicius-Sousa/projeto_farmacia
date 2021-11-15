package com.projeto_p2.farmacia.model.entities;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_Usuario")
	private Long id;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name="tb_perfil")
	private Set<Integer> perfis = new HashSet<>();
	
	public Set<TipoPerfil> getPerfis(){
		return perfis.stream()
				.map(x -> TipoPerfil.toEnum(x)).collect(Collectors.toSet());
	}
	
	public void addPerfil(TipoPerfil perfil) {
		this.perfis.add(perfil.getCod());
	}
	
	@Column(name="nm_login", length = 80, unique = true)
	private String login;
	
	@Column(name="nm_senha")
	private String senha;
	
	public String getLogin() { return login;}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	@JsonIgnore
	public String getSenha() {
		return senha;
	}
	
	@JsonProperty
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
