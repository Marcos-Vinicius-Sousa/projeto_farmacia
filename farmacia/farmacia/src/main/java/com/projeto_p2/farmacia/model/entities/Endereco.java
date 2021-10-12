package com.projeto_p2.farmacia.model.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Endereco {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cd_Endereco;
	
	private String nm_logradouro;
	
	private String nm_cidade;

	public Long getCd_Endereco() {
		return cd_Endereco;
	}

	public void setId_Endereco(Long cd_Endereco) {
		this.cd_Endereco = cd_Endereco;
	}

	public String getNm_logradouro() {
		return nm_logradouro;
	}

	public void setNm_logradouro(String nm_logradouro) {
		this.nm_logradouro = nm_logradouro;
	}

	public String getNm_cidade() {
		return nm_cidade;
	}

	public void setNm_cidade(String nm_cidade) {
		this.nm_cidade = nm_cidade;
	}
	
	

}
