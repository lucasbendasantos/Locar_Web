package br.com.acpn.locar_web.Dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.acpn.locar_web.domain.Estado;

public class EstadoDaoTest {

	@Test
	@Ignore
	public void salvar() {

		Estado estado = new Estado();
		estado.setNome("Rio de Janeio");
		estado.setSigla("RJ");

		EstadoDao estadoDao = new EstadoDao();
		estadoDao.salvar(estado);
	}

	@Test
	@Ignore
	public void listar() {
		EstadoDao estadoDao = new EstadoDao();
		List<Estado> resultado = estadoDao.listar();

		for (Estado estado : resultado) {
			System.out.println(estado.getSigla() + " " + estado.getNome());
		}
	}

	@Test
	@Ignore
	public void buscar() {
		long codigo = 2L;

		EstadoDao estadoDao = new EstadoDao();
		Estado estado = estadoDao.buscar(codigo);

		System.out.println(estado.getSigla() + " " + estado.getNome());

	}

	@Test
	@Ignore
	public void excluir() {
		long codigo = 2L;

		EstadoDao estadoDao = new EstadoDao();
		Estado estado = estadoDao.buscar(codigo);
		estadoDao.excluir(estado);
	}
	
	@Test
	@Ignore
	public void editar(){
		long codigo = 2L;

		EstadoDao estadoDao = new EstadoDao();
		//criei um Objeto Estado e populo ele com o que veio do banco
		Estado estado = estadoDao.buscar(codigo);
		
		
		// Aqui eu altero o estado que veio do banco e faco um update
		estado.setSigla("RJ");
		estadoDao.editar(estado);
	}
	

	
	

}
