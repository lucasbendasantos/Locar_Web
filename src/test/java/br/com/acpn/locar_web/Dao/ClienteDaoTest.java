package br.com.acpn.locar_web.Dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.acpn.locar_web.domain.Cliente;
import br.com.acpn.locar_web.domain.Estado;
import br.com.acpn.locar_web.domain.Pessoa;

public class ClienteDaoTest {
	
	@Test
	@Ignore
	public void salvar() throws ParseException{
		//Crio a pessoa porque todo cliente e uma pessoa,portanto existe relacao e o cliente precisa de uma cadastro de pessoa
		PessoaDao pessoaDao = new PessoaDao();
		Pessoa pessoa = pessoaDao.buscar(1L);
		
		//Criar o estado porque todo cliente precisa ser cadstrado com o estado emissor
		EstadoDao estadoDao = new EstadoDao();
		Estado estado = estadoDao.buscar(1L);
		
		//crio o cliente dao e o cliente para popular o cliente e inserir ele via cliente DAO
		ClienteDao clienteDao = new ClienteDao();
		Cliente cliente = new Cliente();
		
		//aqui populo o cliente com as informacoes para o teste
		cliente.setEstadoEmissor(estado);//aqui eu coloco o estado que foi incluso
		cliente.setLiberado(true);
		cliente.setNumeroRegistro(1234567890);
		cliente.setPessoa(pessoa);// aqui estou referenciando a pessoa que pesquisei acima para amarrar ela com o cliente
		cliente.setValidadeCnh(new SimpleDateFormat("dd/MM/yyyy").parse("16/02/1995"));//crio a data que sera informada com a mascara
		
		//salvo o cliente
		clienteDao.salvar(cliente);
	}
	
	@Test
	@Ignore
	public void listar(){
		ClienteDao clienteDao = new ClienteDao();
		List<Cliente> resultado = clienteDao.listar();
		
		for(Cliente cliente : resultado){
			System.out.println(cliente.getPessoa().getNome());// assimo consigo pegar o nome do cliente que esta em pessoa
			System.out.println(cliente.getNumeroRegistro());
			System.out.println(cliente.getEstadoEmissor().getNome());// pego a sigla do estado emissor
			System.out.println(cliente.getLiberado());
			System.out.println(cliente.getValidadeCnh());
			System.out.println("------------------------------");
		}
	}
	
	@Test
	@Ignore
	public void buscar(){
		
		long codigo = 1L;
		ClienteDao clienteDao = new ClienteDao();
		Cliente cliente = clienteDao.buscar(codigo);
		
		System.out.println("Registro: " + cliente.getNumeroRegistro());
		
	}
	
	@Test
	@Ignore
	public void excluir(){
		long codigo = 1L;
		ClienteDao clienteDao = new ClienteDao();
		Cliente cliente = clienteDao.buscar(codigo);
		
		clienteDao.excluir(cliente);
	}
	@Test
	@Ignore
	public void editar(){
		long codigo = 2L;
		ClienteDao clienteDao = new ClienteDao();
		Cliente cliente = clienteDao.buscar(codigo);
		
		cliente.setLiberado(false);
		clienteDao.editar(cliente);
	}
	
}
