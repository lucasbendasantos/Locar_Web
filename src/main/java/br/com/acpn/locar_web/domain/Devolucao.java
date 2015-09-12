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
	private Devolucao devolucao;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Cidades cidadeDevolucao;
	
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date data;

}
