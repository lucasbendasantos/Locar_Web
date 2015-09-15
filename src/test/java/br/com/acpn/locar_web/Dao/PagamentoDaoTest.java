package br.com.acpn.locar_web.Dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.acpn.locar_web.domain.Devolucao;
import br.com.acpn.locar_web.domain.Pagamento;

public class PagamentoDaoTest {
	
	@Test
	@Ignore
	public void salvar(){
		PagamentoDao pagamentoDao = new PagamentoDao();
		Pagamento pagamento = new Pagamento();
		
		DevolucaoDao devolucaoDao = new DevolucaoDao();
		Devolucao devolucao = devolucaoDao.buscar(1L);
		
		pagamento.setDevolucao(devolucao);
		pagamento.setValorTotal(33.33);
		pagamento.setTaxaExtra(0.0);
		
		pagamentoDao.salvar(pagamento);
	}
	
	@Test
	//@Ignore
	public void listar(){
		PagamentoDao pagamentoDao = new PagamentoDao();
		
		List<Pagamento> resultado = pagamentoDao.listar();
		
		for(Pagamento pagamento : resultado){
			System.out.println(pagamento.getDevolucao().getLocacao().getCliente().getPessoa().getNome());
			System.out.println(pagamento.getDevolucao().getLocacao().getAutomovel().getModelo());
			System.out.println(pagamento.getValorTotal());
			System.out.println(pagamento.getCodigo());
			System.out.println(pagamento.getDevolucao().getCodigo());
			System.out.println(pagamento.getDevolucao().getLocacao().getCodigo());
			
		}
		
	}
	
	@Test
	@Ignore
	public void buscar(){
		PagamentoDao  pagamentoDao = new PagamentoDao();
		Pagamento pagamento = pagamentoDao.buscar(1L);
		
		System.out.println(pagamento.getDevolucao().getLocacao().getCliente().getPessoa().getNome());
		System.out.println(pagamento.getDevolucao().getLocacao().getAutomovel().getModelo());
		System.out.println(pagamento.getValorTotal());
		System.out.println(pagamento.getCodigo());
		
	}
	
	@Test
	@Ignore
	public void excluir(){
		PagamentoDao  pagamentoDao = new PagamentoDao();
		Pagamento pagamento = pagamentoDao.buscar(1L);
		
		pagamentoDao.excluir(pagamento);
	}
	
	@Test
	@Ignore
	public void editar(){
		PagamentoDao  pagamentoDao = new PagamentoDao();
		Pagamento pagamento = pagamentoDao.buscar(1L);
		
		pagamento.setTaxaExtra(1.1);
		
		pagamentoDao.editar(pagamento);
	}
	
	

}
