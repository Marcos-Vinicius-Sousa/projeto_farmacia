package com.projeto_p2.farmacia.model.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cd_cliente;
	private String nm_cliente;
	private Long cd_cpf;
	private String cd_tel;
	private String email;
	public Long getCd_cliente() {
		return cd_cliente;
	}
	public void setCd_cliente(Long cd_cliente) {
		this.cd_cliente = cd_cliente;
	}
	public String getNm_cliente() {
		return nm_cliente;
	}
	public void setNm_cliente(String nm_cliente) {
		this.nm_cliente = nm_cliente;
	}
	public Long getCd_cpf() {
		return cd_cpf;
	}
	public void setCd_cpf(Long cd_cpf) {
		this.cd_cpf = cd_cpf;
	}
	public String getCd_tel() {
		return cd_tel;
	}
	public void setCd_tel(String cd_tel) {
		this.cd_tel = cd_tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
