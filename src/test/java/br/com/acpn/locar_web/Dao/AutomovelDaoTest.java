package br.com.acpn.locar_web.Dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.acpn.locar_web.domain.Automovel;
import br.com.acpn.locar_web.domain.Cidades;
import br.com.acpn.locar_web.domain.Estado;

public class AutomovelDaoTest {
	
	@Test
	@Ignore
	public void salvar(){
		AutomovelDao automovelDao = new AutomovelDao();
		Automovel automovel = new Automovel();
		
		CidadeDao cidadeDao = new CidadeDao();
		Cidades cidade = cidadeDao.buscar(1L);
		
		EstadoDao estadoDao = new EstadoDao();
		Estado estado = estadoDao.buscar(1L);
		
		automovel.setChassi("11111111");
		automovel.setFabricante("GM");
		automovel.setCidade(cidade);
		automovel.setEstado(estado);
		automovel.setPlaca("ABC1234");
		automovel.setModelo("Celta");
		automovel.setStatus("Func");//Cuidado pois o maximo de caracteres está precisa mudar*
		
		automovelDao.salvar(automovel);
		
	}
	
	@Test
	@Ignore
	public void listar(){
		AutomovelDao automovelDao = new AutomovelDao();
		List<Automovel> resultado = automovelDao.listar();
		
		for(Automovel automovel : resultado){
			System.out.println(automovel.getModelo() + " "+ automovel.getFabricante());	
		}
	}
	
	@Test
	@Ignore
	public void buscar(){
		AutomovelDao automovelDao = new AutomovelDao();
		Automovel automovel = automovelDao.buscar(1L);
		
		System.out.println("Modelo: "+automovel.getModelo());
	}
	
	@Test
	@Ignore
	public void excluir(){
		AutomovelDao automovelDao = new AutomovelDao();
		Automovel automovel = automovelDao.buscar(1L);
		
		automovelDao.excluir(automovel);
	}
	
	@Test
	public void editar(){
		
		AutomovelDao automovelDao = new AutomovelDao();
		Automovel automovel = automovelDao.buscar(1L);
		
		CidadeDao cidadeDao = new CidadeDao();
		Cidades cidade = cidadeDao.buscar(1L);
		
		
		EstadoDao estadoDao = new EstadoDao();
		Estado estado = estadoDao.buscar(1L);
		
		automovel.setChassi("11111111");
		automovel.setFabricante("GM");
		automovel.setCidade(cidade);
		automovel.setEstado(estado);
		automovel.setPlaca("ABC1234");
		automovel.setModelo("Celta");
		automovel.setStatus("Ok");//Cuidado pois o maximo de caracteres está precisa mudar*
		
		automovelDao.editar(automovel);
		
		
		
	}

}
