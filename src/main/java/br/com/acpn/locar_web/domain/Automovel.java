package br.com.acpn.locar_web.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class Automovel extends GenericDomain{
	
	@Column(length = 17,nullable = false)
	private String chassi;
	
	@Column(length = 7,nullable = false)
	private String Placa;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Cidades cidade;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Estado estado;
	
	@Column(length = 50,nullable = false)
	private String modelo;
	@Column(length = 50,nullable = false)
	private String fabricante;
	@Column(length = 20,nullable = false)
	private String status;
	public String getChassi() {
		return chassi;
	}
	public void setChassi(String chassi) {
		this.chassi = chassi;
	}
	public String getPlaca() {
		return Placa;
	}
	public void setPlaca(String placa) {
		Placa = placa;
	}
	public Cidades getCidade() {
		return cidade;
	}
	public void setCidade(Cidades cidade) {
		this.cidade = cidade;
	}
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getFabricante() {
		return fabricante;
	}
	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
