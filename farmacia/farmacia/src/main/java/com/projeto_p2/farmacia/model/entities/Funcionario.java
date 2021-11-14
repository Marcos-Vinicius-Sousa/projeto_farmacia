package com.projeto_p2.farmacia.model.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Funcionario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cd_Funcionario;
	private String nm_Funcionario;
	private Long cd_cpf;
	private String cd_tel;
	
	public Long getCd_Funcionario() {
		return cd_Funcionario;
	}
	public void setCd_Funcionario(Long cd_Funcionario) {
		this.cd_Funcionario = cd_Funcionario;
	}
	public String getNm_Funcionario() {
		return nm_Funcionario;
	}
	public void setNm_Funcionario(String nm_Funcionario) {
		this.nm_Funcionario = nm_Funcionario;
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
	
	
	

}
