package com.projeto_p2.farmacia.model.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Past;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cd_Pedido;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@Column(name="id_funcionario")
	private Funcionario funcionario;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@Column(name="id_cliente")
	private Cliente cliente;
	
	@ManyToMany
	@JoinTable(name = "tb_pedido_materia", 
    joinColumns = @JoinColumn(name = "fk_pedido_id"), 
    inverseJoinColumns = @JoinColumn(name = "fk_materia_id"))
	private List<MateriaPrima> materias;
	
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
	@Column(name = "dt_data")
	@Past
	private Date dt_pedido;
	
	private Float vl_Pedido;
	
	

	public List<MateriaPrima> getMaterias() {
		return materias;
	}

	public void setMaterias(List<MateriaPrima> materias) {
		this.materias = materias;
	}

	public Float getVl_Pedido() {
		return vl_Pedido;
	}

	public void setVl_Pedido(Float vl_Pedido) {
		this.vl_Pedido = vl_Pedido;
	}

	public Long getCd_Pedido() {
		return cd_Pedido;
	}

	public void setCd_Pedido(Long cd_Pedido) {
		this.cd_Pedido = cd_Pedido;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Date getDt_pedido() {
		return dt_pedido;
	}

	public void setDt_pedido(Date dt_pedido) {
		this.dt_pedido = dt_pedido;
	}
	
	
	
	
	

}
