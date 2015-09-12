package br.com.acpn.locar_web.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity
public class Locacao extends GenericDomain {
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Automovel automovel;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Cliente cliente;
	
	@Column(nullable = false, precision = 8, scale = 2)
	private double kmcontrolado;
	
	@Column(nullable = false, precision = 8, scale = 2)
	private double kmlivre;
	
	@Column(length = 20,nullable = false)
	private String formaPagamento;
	
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dataLocacao;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Cidades cidadeLocacao;

	public Automovel getAutomovel() {
		return automovel;
	}

	public void setAutomovel(Automovel automovel) {
		this.automovel = automovel;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public double getKmcontrolado() {
		return kmcontrolado;
	}

	public void setKmcontrolado(double kmcontrolado) {
		this.kmcontrolado = kmcontrolado;
	}

	public double getKmlivre() {
		return kmlivre;
	}

	public void setKmlivre(double kmlivre) {
		this.kmlivre = kmlivre;
	}

	public String getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public Date getDataLocacao() {
		return dataLocacao;
	}

	public void setDataLocacao(Date dataLocacao) {
		this.dataLocacao = dataLocacao;
	}

	public Cidades getCidadeLocacao() {
		return cidadeLocacao;
	}

	public void setCidadeLocacao(Cidades cidadeLocacao) {
		this.cidadeLocacao = cidadeLocacao;
	}
	
	
	
	

}
