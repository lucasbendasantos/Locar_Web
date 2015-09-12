package br.com.acpn.locar_web.Dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.acpn.locar_web.domain.Pessoa;

public class PessoaDaoTest {

	@Test
	@Ignore
	public void salvar() {
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Lucas Bendassoli dos Santos");
		pessoa.setBairro("Vila Regente Feijó");
		pessoa.setCelular("95709-1602");
		pessoa.setCep("03342000");
		pessoa.setCpf("42950885870");
		pessoa.setTelefone("2337-3270");
		pessoa.setRg("42521049-2");
		pessoa.setRua("Av Regente Feijo");
		pessoa.setNumero(new Short("1900"));
		pessoa.setEmail("lucasbendasantos@hotmail.com");
		pessoa.setComplemento("Ap 153");

		PessoaDao pessoaDao = new PessoaDao();
		pessoaDao.salvar(pessoa);

		System.out.println("Pessoa Incluida com Sucesso");
	}

	@Test
	@Ignore
	public void listar() {
		PessoaDao pessoaDao = new PessoaDao();
		List<Pessoa> resultado = pessoaDao.listar();

		for (Pessoa pessoa : resultado) {
			System.out.println("Nome: " + pessoa.getNome());
			System.out.println("Celular: " + pessoa.getCelular());
			System.out.println("Rua: " + pessoa.getRua());
			System.out.println("Email: " + pessoa.getEmail());
			System.out.println(" _______________________________");
		}
	}

	@Test
	@Ignore
	public void buscar() {
		long codigo = 2L;

		PessoaDao pessoaDao = new PessoaDao();
		Pessoa pessoa = pessoaDao.buscar(codigo);

		System.out.println("Nome: " + pessoa.getNome() + " Complemento: " + pessoa.getComplemento());
	}

	@Test
	//@Ignore
	public void excluir() {
		long codigo = 1L;

		PessoaDao pessoaDao = new PessoaDao();
		Pessoa pessoa = pessoaDao.buscar(codigo);
		pessoaDao.excluir(pessoa);
	}
	
	@Test
	@Ignore
	public void editar(){
		long codigo = 1L;

		PessoaDao pessoaDao = new PessoaDao();
		Pessoa pessoa = pessoaDao.buscar(codigo);
		
		pessoa.setComplemento("TESTE 1");
		pessoa.setNome("Teste 1");
		pessoaDao.editar(pessoa);
	}
	
	

}
