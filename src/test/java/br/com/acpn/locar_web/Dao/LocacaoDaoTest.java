package br.com.acpn.locar_web.Dao;

import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.acpn.locar_web.domain.Automovel;
import br.com.acpn.locar_web.domain.Cidades;
import br.com.acpn.locar_web.domain.Cliente;
import br.com.acpn.locar_web.domain.Locacao;
 
public class LocacaoDaoTest {
	
	@Test
	@Ignore
    public void salvar() {
        AutomovelDao automovelDao = new AutomovelDao();
        Automovel automovel = automovelDao.buscar(1L);
         
        ClienteDao clienteDao = new ClienteDao();
        Cliente cliente = clienteDao.buscar(2L);
         
        CidadeDao cidadeDao = new CidadeDao();
        Cidades cidades = cidadeDao.buscar(1L);
         
        Locacao locacao = new Locacao();
        locacao.setAutomovel(automovel);
        locacao.setCliente(cliente);
        locacao.setKmcontrolado(2.4);
        locacao.setKmlivre(1.5);
        locacao.setFormaPagamento("Cartão");
        locacao.setDataLocacao(new Date());
        locacao.setCidadeLocacao(cidades);
         
        LocacaoDao locacaoDao = new LocacaoDao();
        locacaoDao.salvar(locacao);
    }
     
	@Test
	@Ignore
    public void listar(){
        LocacaoDao locacaoDao = new LocacaoDao();
        List<Locacao> resultado = locacaoDao.listar();
 
        for (Locacao locacao : resultado) {
            System.out.println("Codigo Locacao: " + locacao.getCodigo());
             
            System.out.println("Codigo do Automovel: " + locacao.getAutomovel().getCodigo());
            System.out.println("Placa do Automovel: " + locacao.getAutomovel().getPlaca());
             
            System.out.println("Codigo do Cliente: " + locacao.getCliente().getCodigo());
            System.out.println("Nome do Cliente: " + locacao.getCliente().getPessoa().getNome());
             
            System.out.println("Codigo da Cidade da Locacao: " + locacao.getCidadeLocacao().getCodigo());
            System.out.println("Nome da Cidade da Locacao: " + locacao.getCidadeLocacao().getNome());
             
            System.out.println("Km controlado: " + locacao.getKmcontrolado());
            System.out.println("Km livre: " + locacao.getKmlivre());
            System.out.println("Forma de pagamento: " + locacao.getFormaPagamento());
            System.out.println("Data da locacao: " + locacao.getDataLocacao());
        }
    }
     
	@Test
	@Ignore
    public void buscar(){
        long codigo = 1L;
 
        LocacaoDao locacaoDao = new LocacaoDao();
        Locacao locacao = locacaoDao.buscar(codigo);
 
        System.out.println("Codigo da Locacao: " + locacao.getCodigo());
         
        System.out.println("Codigo do Automovel: " + locacao.getAutomovel().getCodigo());
        System.out.println("Placa do Automovel: " + locacao.getAutomovel().getPlaca());
         
        System.out.println("Codigo do Cliente: " + locacao.getCliente().getCodigo());
        System.out.println("Nome do Cliente: " + locacao.getCliente().getPessoa().getNome());
         
        System.out.println("Codigo da Cidade da Locacao: " + locacao.getCidadeLocacao().getCodigo());
        System.out.println("Nome da Cidade da Locacao: " + locacao.getCidadeLocacao().getNome());
         
        System.out.println("Km controlado: " + locacao.getKmcontrolado());
        System.out.println("Km livre: " + locacao.getKmlivre());
        System.out.println("Forma de pagamento: " + locacao.getFormaPagamento());
        System.out.println("Data da locacao: " + locacao.getDataLocacao());
    }
     
	@Test
	@Ignore
    public void excluir(){
        long codigo = 1L;
 
        LocacaoDao locacaoDao = new LocacaoDao();
        Locacao locacao = locacaoDao.buscar(codigo);
         
        locacaoDao.excluir(locacao);
    }
     
	@Test
	@Ignore
    public void editar(){
        long codigoLocacao = 1L;
        long codigoAutomovel = 1L;
        long codigoCliente = 2L;
        long codigoCidadeLocacao = 2L;
         
        AutomovelDao automovelDao = new AutomovelDao();
        ClienteDao clienteDao = new ClienteDao();
        CidadeDao cidadeDao = new CidadeDao();
 
        Automovel automovel = automovelDao.buscar(codigoAutomovel);
        Cliente cliente = clienteDao.buscar(codigoCliente);
        Cidades cidade = cidadeDao.buscar(codigoCidadeLocacao);
 
        LocacaoDao locacaoDao = new LocacaoDao();
          
        Locacao locacao = locacaoDao.buscar(codigoLocacao);
         
        locacao.setKmcontrolado(4.5);
        locacao.setKmlivre(7.4);
        locacao.setFormaPagamento("VT");
        locacao.setDataLocacao(new Date());
 
        locacao.setAutomovel(automovel);
        locacao.setCliente(cliente);
        locacao.setCidadeLocacao(cidade);       
         
        locacaoDao.editar(locacao);
    }
}