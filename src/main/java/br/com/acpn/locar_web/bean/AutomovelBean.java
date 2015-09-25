package br.com.acpn.locar_web.bean;
 
import java.io.Serializable;
import java.util.List;
 
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
 
import org.omnifaces.util.Messages;
 
import br.com.acpn.locar_web.Dao.AutomovelDao;
import br.com.acpn.locar_web.Dao.CidadeDao;
import br.com.acpn.locar_web.Dao.EstadoDao;
import br.com.acpn.locar_web.domain.Automovel;
import br.com.acpn.locar_web.domain.Cidades;
import br.com.acpn.locar_web.domain.Estado;
 
@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class AutomovelBean implements Serializable{
    private List<Automovel> automoveis;
    private Automovel automovel;
    private List<Cidades> cidades;
    private List<Estado> estados;
     
    public List<Automovel> getAutomoveis() {
        return automoveis;
    }
 
    public void setAutomoveis(List<Automovel> automoveis) {
        this.automoveis = automoveis;
    }
 
    public Automovel getAutomovel() {
        return automovel;
    }
 
    public void setAutomovel(Automovel automovel) {
        this.automovel = automovel;
    }
 
    public List<Cidades> getCidades() {
        return cidades;
    }
 
    public void setCidades(List<Cidades> cidades) {
        this.cidades = cidades;
    }
 
    public List<Estado> getEstados() {
        return estados;
    }
 
    public void setEstados(List<Estado> estados) {
        this.estados = estados;
    }
     
    @PostConstruct
    public void listar() {
        try {
            AutomovelDao automovelDao = new AutomovelDao();
 
            automoveis = automovelDao.listar();
            
 
        } catch (RuntimeException erro) {
            Messages.addGlobalError("Ocorreu um erro ao tentar listar os automoveis");
            erro.printStackTrace();
        }
 
    }
 
    public void novo() {
        automovel = new Automovel();
        CidadeDao cidadeDao = new CidadeDao();
        EstadoDao estadoDao = new EstadoDao();
        try {
            cidades = cidadeDao.listar();
            estados = estadoDao.listar();
        } catch (RuntimeException erro) {
            Messages.addGlobalError("Ocorreu um Erro ao Listar as cidades e estados");
            erro.printStackTrace();
 
        }
    }
     
    public void salvar(){
        try{
            AutomovelDao automovelDao = new AutomovelDao();
            automovelDao.merge(automovel);
             
            automovel = new Automovel();
             
            CidadeDao cidadeDao = new CidadeDao();
            cidades = cidadeDao.listar();
            EstadoDao estadoDao = new EstadoDao();
            estados = estadoDao.listar();
             
            automoveis = automovelDao.listar();
             
            Messages.addGlobalInfo("Automovel salvo com sucesso !");
        }catch(RuntimeException erro){
            Messages.addGlobalError("Ocorreu um erro ao salvar o automovel!");
            erro.printStackTrace();
        }
    }
     
    public void excluir(ActionEvent evento){
        try{
            automovel = (Automovel) evento.getComponent().getAttributes().get("automovelSelecionado");
             
            AutomovelDao automovelDao = new AutomovelDao();
            automovelDao.excluir(automovel);
             
            Messages.addGlobalInfo("Automóvel removido com sucesso!");
            automoveis = automovelDao.listar();
             
        }catch(RuntimeException erro){
            Messages.addGlobalError("Erro ao remover");
            erro.printStackTrace();
        }
 
    }
     
    public void editar(ActionEvent evento){
        try {
            automovel = (Automovel) evento.getComponent().getAttributes().get("automovelSelecionado");
             
            CidadeDao cidadeDao = new CidadeDao();
            cidades = cidadeDao.listar();
            EstadoDao estadoDao = new EstadoDao();
            estados = estadoDao.listar();
             
        } catch (RuntimeException erro) {
            Messages.addGlobalError("Ocorreu um erro ao selecionar o automovel");
            erro.printStackTrace();
 
        }
    }
}