package br.com.acpn.locar_web.Dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.acpn.locar_web.util.HibernateUtil;

public class GenericDao<Entidade> {

	
	private Class<Entidade> classe;

	@SuppressWarnings("unchecked")
	public GenericDao() {
		this.classe = (Class<Entidade>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}

	public void salvar(Entidade entidade) {
		//Abre a Sessao
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction transacao = null;
		try {
			transacao = sessao.beginTransaction();
			sessao.save(entidade);
			transacao.commit();
		} catch (RuntimeException erro) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw erro;
		} finally {
			sessao.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Entidade> listar(){
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		try{
			Criteria consulta = sessao.createCriteria(classe);
			List<Entidade> resultado = consulta.list();
			return resultado;
		}catch (RuntimeException erro) {
			throw erro;
		}finally {
			sessao.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Entidade> listarAsc(String campoOrdenacaoAsc){
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		try{
			Criteria consulta = sessao.createCriteria(classe);
			consulta.addOrder(Order.asc(campoOrdenacaoAsc));
			List<Entidade> resultado = consulta.list();
			return resultado;
		}catch (RuntimeException erro) {
			throw erro;
		}finally {
			sessao.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Entidade> listarDesc(String campoOrdenacaoDesc){
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		try{
			Criteria consulta = sessao.createCriteria(classe);
			consulta.addOrder(Order.desc(campoOrdenacaoDesc));
			List<Entidade> resultado = consulta.list();
			
			return resultado;
		}catch (RuntimeException erro) {
			throw erro;
		}finally {
			sessao.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public Entidade buscar(long codigo){
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		try{
			// Aqui e aonde e feita a Query 
			Criteria consulta = sessao.createCriteria(classe);
			// e aqui e feito a parte do "Where" e uma restricao
			consulta.add(Restrictions.idEq(codigo));
			
			Entidade resultado = (Entidade)consulta.uniqueResult();
			return resultado;
		}catch (RuntimeException erro) {
			throw erro;
		}finally {
			sessao.close();
		}
	}
	
	public void excluir(Entidade entidade) {
		//Abre a Sessao
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction transacao = null;
		try {
			transacao = sessao.beginTransaction();
			sessao.delete(entidade);
			transacao.commit();
		} catch (RuntimeException erro) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw erro;
		} finally {
			sessao.close();
		}
	}
	
	public void editar(Entidade entidade) {
		//Abre a Sessao
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction transacao = null;
		try {
			transacao = sessao.beginTransaction();
			sessao.update(entidade);
			transacao.commit();
		} catch (RuntimeException erro) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw erro;
		} finally {
			sessao.close();
		}
	}
	
	public void merge(Entidade entidade) {
		//Abre a Sessao
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction transacao = null;
		try {
			transacao = sessao.beginTransaction();
			sessao.merge(entidade);
			transacao.commit();
		} catch (RuntimeException erro) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw erro;
		} finally {
			sessao.close();
		}
	}

}
