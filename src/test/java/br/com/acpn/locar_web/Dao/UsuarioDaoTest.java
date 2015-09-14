package br.com.acpn.locar_web.Dao;
 
import java.util.List;
 
import org.junit.Ignore;
import org.junit.Test;
 
import br.com.acpn.locar_web.domain.Pessoa;
import br.com.acpn.locar_web.domain.Usuario;
 
public class UsuarioDaoTest {
 
    @Test
    @Ignore
    public void salvar(){
        PessoaDao pessoaDao = new PessoaDao();
        Pessoa pessoa = pessoaDao.buscar(2L);
         
        Usuario usuario = new Usuario();
        usuario.setSenha("abcdefghijklmnopqrstuvwxyz012345");
        usuario.setTipo('F');
        usuario.setAtivo(true);
        usuario.setPessoa(pessoa);
         
        UsuarioDao usuarioDao = new UsuarioDao();
        usuarioDao.salvar(usuario);
    }
     
    @Test
    @Ignore
    public void listar(){
        UsuarioDao usuarioDao = new UsuarioDao();
        List<Usuario> resultado = usuarioDao.listar();
         
        for (Usuario usuario : resultado) {
            System.out.println("Codigo Usuario: " + usuario.getCodigo());
              
            System.out.println("Nome do Usuario: " + usuario.getPessoa().getNome());
             
            System.out.println("Senha do Usuario: " + usuario.getSenha());
            System.out.println("Tipo de Usuario: " + usuario.getTipo());
            System.out.println("Status do Usuario: " + usuario.getAtivo());           
        }
    }
     
    @Test
    @Ignore
    public void buscar(){
        long codigo = 1L;
          
        UsuarioDao usuarioDao = new UsuarioDao();
        Usuario usuario = usuarioDao.buscar(codigo);
  
        System.out.println("Codigo Usuario: " + usuario.getCodigo());
         
        System.out.println("Nome do Usuario: " + usuario.getPessoa().getNome());
         
        System.out.println("Senha do Usuario: " + usuario.getSenha());
        System.out.println("Tipo de Usuario: " + usuario.getTipo());
        System.out.println("Status do Usuario: " + usuario.getAtivo());  
    }
     
    @Test
    @Ignore
    public void excluir(){
        long codigo = 1L;
          
        UsuarioDao usuarioDao = new UsuarioDao();
        Usuario usuario = usuarioDao.buscar(codigo);
          
        usuarioDao.excluir(usuario);
    }
     
    @Test
    @Ignore
    public void editar(){
        long codigoUsuario = 1L;
        long codigoPessoa = 1L;
          
        PessoaDao pessoaDao = new PessoaDao();
  
        Pessoa pessoa = pessoaDao.buscar(codigoPessoa);
  
        UsuarioDao usuarioDao = new UsuarioDao();
           
        Usuario usuario = usuarioDao.buscar(codigoUsuario);
         
        usuario.setSenha("abcdefghijklmnopqrstuvwxyz543210");
        usuario.setTipo('C');
        usuario.setAtivo(false);
        usuario.setPessoa(pessoa);
          
        usuarioDao.editar(usuario);
    }
}