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
public class Cliente extends GenericDomain {
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date ValidadeCnh;
	
	@Column(length = 11, nullable = false)
	private int numeroRegistro;
	
	@Column(nullable = false)
	private Boolean liberado;
	
	@OneToOne
	@JoinColumn(nullable = false)
	private Pessoa pessoa;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Estado EstadoEmissor;

	public Date getValidadeCnh() {
		return ValidadeCnh;
	}

	public void setValidadeCnh(Date validadeCnh) {
		ValidadeCnh = validadeCnh;
	}

	public int getNumeroRegistro() {
		return numeroRegistro;
	}

	public void setNumeroRegistro(int numeroRegistro) {
		this.numeroRegistro = numeroRegistro;
	}

	public Boolean getLiberado() {
		return liberado;
	}

	public void setLiberado(Boolean liberado) {
		this.liberado = liberado;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Estado getEstadoEmissor() {
		return EstadoEmissor;
	}

	public void setEstadoEmissor(Estado estadoEmissor) {
		EstadoEmissor = estadoEmissor;
	}

	
}
