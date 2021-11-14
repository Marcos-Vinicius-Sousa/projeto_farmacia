package com.projeto_p2.farmacia.model.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Estoque {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cd_Estoque;
	
	@OneToMany
	@Column(name="id_materia")
	private List<MateriaPrima> materias;
	
	public List<MateriaPrima> getMaterias() {
		return materias;
	}

	public void setMaterias(List<MateriaPrima> materias) {
		this.materias = materias;
	}

	private Integer qtd_materia;

	public Long getCd_Estoque() {
		return cd_Estoque;
	}

	public void setCd_Estoque(Long cd_Estoque) {
		this.cd_Estoque = cd_Estoque;
	}

	
	public Integer getQtd_materia() {
		return qtd_materia;
	}

	public void setQtd_materia(Integer qtd_materia) {
		this.qtd_materia = qtd_materia;
	}
	
	
	

}
