package com.projeto_p2.farmacia.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Estoque {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cd_Estoque;
	
	@ManyToOne
	@Column(name="id_materia")
	private MateriaPrima materia;
	
	private Integer qtd_materia;

	public Long getCd_Estoque() {
		return cd_Estoque;
	}

	public void setCd_Estoque(Long cd_Estoque) {
		this.cd_Estoque = cd_Estoque;
	}

	public MateriaPrima getMateria() {
		return materia;
	}

	public void setMateria(MateriaPrima materia) {
		this.materia = materia;
	}

	public Integer getQtd_materia() {
		return qtd_materia;
	}

	public void setQtd_materia(Integer qtd_materia) {
		this.qtd_materia = qtd_materia;
	}
	
	
	

}
