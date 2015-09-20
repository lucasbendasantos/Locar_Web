package br.com.acpn.locar_web.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
//import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.acpn.locar_web.Dao.EstadoDao;
import br.com.acpn.locar_web.domain.Estado;

//import javax.faces.context.FacesContext;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class EstadoBean implements Serializable {

	private Estado estado;
	private List<Estado> estados;

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	public List<Estado> getEstados() {
		return estados;
	}
	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}

	public void salvar() {
		try {
			EstadoDao estadoDao = new EstadoDao();
			estadoDao.merge(estado);
			estados = estadoDao.listar();

			Messages.addGlobalInfo("Novo Estado Adcionado com Sucesso !");

			novo();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao Incluir o Estado !");
			erro.printStackTrace();

		}

		/*
		 * String msg = "Programcao TESTE"; FacesMessage mensagem = new
		 * FacesMessage(FacesMessage.SEVERITY_INFO,msg,msg);
		 * 
		 * FacesContext contexto = FacesContext.getCurrentInstance();
		 * contexto.addMessage(null, mensagem);
		 */

	}
	
	@PostConstruct
	public void listar(){
		try {
			EstadoDao estadoDao = new EstadoDao();
			estados = estadoDao.listar();
			
		}catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao Listar os Estados !");
			erro.printStackTrace();

		}
	}

	public void novo() {
		estado = new Estado();
	}
	
	public void excluir(ActionEvent evento){
		try{
			EstadoDao estadoDao = new EstadoDao();
			estado = (Estado) evento.getComponent().getAttributes().get("estadoSelecionado");
			estadoDao.excluir(estado);
			Messages.addGlobalInfo("Estado Removido com Sucesso !");
			estados = estadoDao.listar();
			
		}catch(RuntimeException erro){
			Messages.addGlobalError("Erro ao Remover ");
			erro.printStackTrace();
		}

	}
	
	public void editar(ActionEvent evento){
		estado = (Estado) evento.getComponent().getAttributes().get("estadoSelecionado");
		
	}

}
