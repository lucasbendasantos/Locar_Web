package br.com.acpn.locar_web.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity
public class Devolucao extends GenericDomain {
	
	@OneToOne
	@JoinColumn(nullable = false)
	private Locacao locacao;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Cidades cidadeDevolucao;
	
	@ManyToOne
	private Funcionario funcionario;
	
	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date data;
	
	@Column(nullable = false, precision = 8, scale = 2)
	private double kmFinal;

	public Locacao getLocacao() {
		return locacao;
	}

	public void setLocacao(Locacao locacao) {
		this.locacao = locacao;
	}

	public Cidades getCidadeDevolucao() {
		return cidadeDevolucao;
	}

	public void setCidadeDevolucao(Cidades cidadeDevolucao) {
		this.cidadeDevolucao = cidadeDevolucao;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public double getKmFinal() {
		return kmFinal;
	}

	public void setKmFinal(double kmFinal) {
		this.kmFinal = kmFinal;
	}
	
	
	

}
