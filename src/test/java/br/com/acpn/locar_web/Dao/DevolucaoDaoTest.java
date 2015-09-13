package br.com.acpn.locar_web.Dao;

import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.acpn.locar_web.domain.Cidades;
import br.com.acpn.locar_web.domain.Devolucao;
import br.com.acpn.locar_web.domain.Funcionario;
import br.com.acpn.locar_web.domain.Locacao;

public class DevolucaoDaoTest {
	
	@Test
	@Ignore
	public void salvar(){
		DevolucaoDao devolucaoDao = new DevolucaoDao();
		Devolucao devolucao = new Devolucao();
		
		CidadeDao cidadeDao = new CidadeDao();
		Cidades cidade = cidadeDao.buscar(1L);
		
		LocacaoDao locacaoDao = new LocacaoDao();
		Locacao locacao = locacaoDao.buscar(1L);
		
		FuncionarioDao funcionarioDao = new FuncionarioDao();
		Funcionario funcionario = funcionarioDao.buscar(1L);
		
		devolucao.setCidadeDevolucao(cidade);
		devolucao.setData(new Date());
		devolucao.setFuncionario(funcionario);
		devolucao.setKmFinal(4.44);
		devolucao.setLocacao(locacao);

		devolucaoDao.salvar(devolucao);
				
	}
	
	@Test
	@Ignore
	public void listar(){
		DevolucaoDao devolucaoDao = new DevolucaoDao();
		List<Devolucao> resultado = devolucaoDao.listar();
		
		for(Devolucao devolucao : resultado){
			System.out.println(devolucao.getLocacao().getAutomovel().getModelo());
			System.out.println(devolucao.getLocacao().getCliente().getPessoa().getNome());
			System.out.println(devolucao.getCodigo());
			System.out.println(devolucao.getData());
		}
	}
	
	@Test
	@Ignore
	public void buscar(){
		DevolucaoDao devolucaoDao = new DevolucaoDao();
		Devolucao devolucao = devolucaoDao.buscar(1L);
		
		System.out.println(devolucao.getLocacao().getAutomovel().getModelo());
		System.out.println(devolucao.getLocacao().getCliente().getPessoa().getNome());
		System.out.println(devolucao.getCodigo());
		System.out.println(devolucao.getData());
		
	}
	
	@Test
	@Ignore
	public void excluir(){
		DevolucaoDao devolucaoDao = new DevolucaoDao();
		Devolucao devolucao = devolucaoDao.buscar(1L);
		
		devolucaoDao.excluir(devolucao);
	}
	
	@Test
	@Ignore
	public void editar(){
		DevolucaoDao devolucaoDao = new DevolucaoDao();
		Devolucao devolucao = devolucaoDao.buscar(1L);
		
		devolucao.setKmFinal(123.1);
		
		devolucaoDao.editar(devolucao);
	}

}
