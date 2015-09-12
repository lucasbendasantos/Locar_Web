package br.com.acpn.locar_web.Dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.acpn.locar_web.domain.Cidades;
import br.com.acpn.locar_web.domain.Estado;

public class CidadeDaoTest {

	@Test
	@Ignore
	public void salvar() {
		EstadoDao estadoDao = new EstadoDao();
		Estado estado = estadoDao.buscar(2L);

		Cidades cidades = new Cidades();
		cidades.setNome("Rio de Janeiro");
		cidades.setEstado(estado);

		CidadeDao cidadeDao = new CidadeDao();
		cidadeDao.salvar(cidades);

	}

	@Test
	@Ignore
	public void listar() {
		CidadeDao cidadeDao = new CidadeDao();
		List<Cidades> resultado = cidadeDao.listar();

		for (Cidades cidade : resultado) {
			System.out.println("Codigo Cidade: " + cidade.getCodigo());
			System.out.println("Nome da Cidade: " + cidade.getNome());
			System.out.println("Codigo do Estado: " + cidade.getEstado().getCodigo());
			System.out.println("Sigla do Estado: " + cidade.getEstado().getSigla());
			System.out.println("Nome do Estado: " + cidade.getEstado().getNome());
			System.out.println(" ");
		}
	}

	@Test
	public void buscar() {
		long codigo = 2L;

		CidadeDao cidadeDao = new CidadeDao();
		Cidades cidade = cidadeDao.buscar(codigo);

		System.out.println("Codigo Cidade: " + cidade.getCodigo());
		System.out.println("Nome da Cidade: " + cidade.getNome());
		System.out.println("Codigo do Estado: " + cidade.getEstado().getCodigo());
		System.out.println("Sigla do Estado: " + cidade.getEstado().getSigla());
		System.out.println("Nome do Estado: " + cidade.getEstado().getNome());
		System.out.println(" ");

	}

	@Test
	@Ignore
	public void excluir() {
		long codigo = 2L;

		CidadeDao cidadeDao = new CidadeDao();
		Cidades cidade = cidadeDao.buscar(codigo);
		
		cidadeDao.excluir(cidade);

	}
	
	@Test
	public void editar(){
		long codigoCidade = 2L;
		long codigoEstado = 1L;
		
		// Busco o estado que deve ser alterado
		EstadoDao estadoDao = new EstadoDao();
		//populo o estado com o resultado da busca
		Estado estado = estadoDao.buscar(codigoEstado);

		CidadeDao cidadeDao = new CidadeDao();
		
		//Popula o Objeto cidade com o resultado que pesquisei 
		Cidades cidade = cidadeDao.buscar(codigoCidade);
		
		
		//seta os novos valores nos atributos
		cidade.setNome("");
		//populo o estado da cidade com o novo estado procurado
		cidade.setEstado(estado);
		
		
		//Salvo o objeto com os novos valores que foram editados
		cidadeDao.editar(cidade);
		
		
		
		
	}

}
