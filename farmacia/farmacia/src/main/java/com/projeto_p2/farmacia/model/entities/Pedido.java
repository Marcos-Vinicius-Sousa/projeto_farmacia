package com.projeto_p2.farmacia.model.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cd_Pedido;
	
	private Funcionario funcionario;
	
	private Cliente cliente;
	
	private Date dt_pedido;

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
