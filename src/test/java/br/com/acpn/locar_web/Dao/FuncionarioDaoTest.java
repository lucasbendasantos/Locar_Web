package br.com.acpn.locar_web.Dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.acpn.locar_web.domain.Funcionario;
import br.com.acpn.locar_web.domain.Pessoa;

public class FuncionarioDaoTest {
	
	@Test
	@Ignore
	public void salvar(){
		FuncionarioDao funcionarioDao = new FuncionarioDao();
		Funcionario funcionario = new Funcionario();
		
		PessoaDao pessoaDao = new PessoaDao();
		Pessoa pessoa = pessoaDao.buscar(3L);
		
		funcionario.setPessoa(pessoa);
		funcionarioDao.salvar(funcionario);
	}
	
	@Test
	@Ignore
	public void listar(){
		FuncionarioDao funcionarioDao = new FuncionarioDao();
		List<Funcionario>resultado = funcionarioDao.listar();
		
		for(Funcionario funcionario : resultado){
			System.out.println("Nome Funcionario: "+funcionario.getPessoa().getNome());
			System.out.println("Codigo Funcionario: "+funcionario.getCodigo());
		}
	}
	
	@Test
	@Ignore
	public void buscar(){
		FuncionarioDao funcionarioDao = new FuncionarioDao();
		Funcionario funcionario = funcionarioDao.buscar(1L);
		
		System.out.println("Nome Funcionario: "+funcionario.getPessoa().getNome());
		System.out.println("Codigo Funcionario: "+funcionario.getCodigo());
	}
	
	@Test
	@Ignore
	public void excluir(){
		FuncionarioDao funcionarioDao = new FuncionarioDao();
		Funcionario funcionario = funcionarioDao.buscar(1L);
		
		funcionarioDao.excluir(funcionario);
		
	}
	
	@Test
	@Ignore
	public void editar(){
		PessoaDao pessoaDao = new PessoaDao();
		Pessoa pessoa = pessoaDao.buscar(3L);
		
		FuncionarioDao funcionarioDao = new FuncionarioDao();
		Funcionario funcionario = funcionarioDao.buscar(1L);
		
		pessoa.setNome("Luan AAAA");
		pessoaDao.editar(pessoa);
		funcionario.setPessoa(pessoa);
		funcionarioDao.editar(funcionario);
		
	}
	
	
	
	
	

}
