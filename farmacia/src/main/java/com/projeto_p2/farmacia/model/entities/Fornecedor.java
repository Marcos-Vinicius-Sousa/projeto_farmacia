package com.projeto_p2.farmacia.model.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Fornecedor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cd_Fornecedor;
	
	private String nm_Fornecedor;
	private Long cd_Cnpj;
	private String cd_tel;
	private String email;
	private String nm_logradouro;
	private String cd_casa;
	private String nm_cidade;
	
	
	

	public String getNm_logradouro() {
		return nm_logradouro;
	}

	public void setNm_logradouro(String nm_logradouro) {
		this.nm_logradouro = nm_logradouro;
	}

	public String getCd_casa() {
		return cd_casa;
	}

	public void setCd_casa(String cd_casa) {
		this.cd_casa = cd_casa;
	}

	public String getNm_cidade() {
		return nm_cidade;
	}

	public void setNm_cidade(String nm_cidade) {
		this.nm_cidade = nm_cidade;
	}

	public void setCd_Fornecedor(Long cd_Fornecedor) {
		this.cd_Fornecedor = cd_Fornecedor;
	}

	public Long getCd_Fornecedor() {
		return cd_Fornecedor;
	}

	public void setId_Fornecedor(Long cd_Fornecedor) {
		this.cd_Fornecedor = cd_Fornecedor;
	}

	public String getNm_Fornecedor() {
		return nm_Fornecedor;
	}

	public void setNm_Fornecedor(String nm_Fornecedor) {
		this.nm_Fornecedor = nm_Fornecedor;
	}

	public Long getCd_Cnpj() {
		return cd_Cnpj;
	}

	public void setCd_Cnpj(Long cd_Cnpj) {
		this.cd_Cnpj = cd_Cnpj;
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
