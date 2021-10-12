package com.projeto_p2.farmacia.model.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MateriaPrima {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cd_MateriaPrima;
	
	private String nm_Materia;
	
	private String ds_Tipo;

	public Long getCd_MateriaPrima() {
		return cd_MateriaPrima;
	}

	public void setCd_MateriaPrima(Long cd_MateriaPrima) {
		this.cd_MateriaPrima = cd_MateriaPrima;
	}

	public String getNm_Materia() {
		return nm_Materia;
	}

	public void setNm_Materia(String nm_Materia) {
		this.nm_Materia = nm_Materia;
	}

	public String getDs_Tipo() {
		return ds_Tipo;
	}

	public void setDs_Tipo(String ds_Tipo) {
		this.ds_Tipo = ds_Tipo;
	}
	
	
	
	

}
