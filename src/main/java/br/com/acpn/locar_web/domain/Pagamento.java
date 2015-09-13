package br.com.acpn.locar_web.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@SuppressWarnings("serial")
@Entity
public class Pagamento extends GenericDomain {
	
	@OneToOne
	@JoinColumn(nullable = false)
	private Devolucao devolucao;
	
	@Column(nullable = false, precision = 8, scale = 2)
	private double valorTotal;
	
	@Column( precision = 8, scale = 2)
	private double taxaExtra;

	public Devolucao getDevolucao() {
		return devolucao;
	}

	public void setDevolucao(Devolucao devolucao) {
		this.devolucao = devolucao;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public double getTaxaExtra() {
		return taxaExtra;
	}

	public void setTaxaExtra(double taxaExtra) {
		this.taxaExtra = taxaExtra;
	}
	
	

}
