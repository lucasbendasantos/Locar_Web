package br.com.acpn.locar_web.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.com.acpn.locar_web.Dao.CidadeDao;
import br.com.acpn.locar_web.Dao.EstadoDao;
import br.com.acpn.locar_web.domain.Cidades;
import br.com.acpn.locar_web.domain.Estado;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class CidadeBean implements Serializable {
	private List<Cidades> cidades;
	private Cidades cidade;
	private List<Estado> estados;

	public List<Cidades> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidades> cidades) {
		this.cidades = cidades;
	}

	public Cidades getCidade() {
		return cidade;
	}

	public void setCidade(Cidades cidade) {
		this.cidade = cidade;
	}

	public List<Estado> getEstados() {
		return estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}

	@PostConstruct
	public void listar() {
		try {
			CidadeDao cidadeDao = new CidadeDao();

			cidades = cidadeDao.listar();

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar listar as Cidades");
			erro.printStackTrace();
		}

	}

	public void novo() {
		cidade = new Cidades();
		EstadoDao estadoDao = new EstadoDao();
		try {
			estados = estadoDao.listar();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um Erro ao Listar os Estados");
			erro.printStackTrace();

		}
	}
}
