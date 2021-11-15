package com.projeto_p2.farmacia.model.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;


@Entity
public class MateriaPrima {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cd_MateriaPrima;
	
	private String nm_Materia;
	private String ds_Tipo;
	
	@Min(1)
	@Max(100000)
	private Float vl_custo;
	
	@Min(1)
	@Max(100000)
	private Float vl_venda;
	
	@ManyToMany
	@JoinTable(name = "tb_materia_fornecedor", 
    joinColumns = @JoinColumn(name = "fk_materia_id"), 
    inverseJoinColumns = @JoinColumn(name = "fk_fornecedor_id"))
	private List<Fornecedor> fornecedores;
	
	
	
	public Float getVl_custo() {
		return vl_custo;
	}

	public void setVl_custo(Float vl_custo) {
		this.vl_custo = vl_custo;
	}

	public Float getVl_venda() {
		return vl_venda;
	}

	public void setVl_venda(Float vl_venda) {
		this.vl_venda = vl_venda;
	}

	public List<Fornecedor> getFornecedores() {
		return fornecedores;
	}

	public void setFornecedores(List<Fornecedor> fornecedores) {
		this.fornecedores = fornecedores;
	}

	

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
