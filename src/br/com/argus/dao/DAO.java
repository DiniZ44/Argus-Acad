 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.argus.dao;

/**
 *
 * @author santo
 */


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

import br.com.argus.exceptions.DAOException;
import br.com.argus.model.Entidade;
import javax.persistence.Query;

public abstract class DAO <T extends Entidade>{

	private EntityManagerFactory entityManagerFactory;
	
	public DAO() {
		this.entityManagerFactory = Persistence.createEntityManagerFactory("postgresql");
	}
	public EntityManager createEntityManager(){
		return entityManagerFactory.createEntityManager();
	}
	
public T inserir(T t) throws DAOException {
		EntityManager entityManager = createEntityManager();

		try {
			entityManager.getTransaction().begin();
			entityManager.persist(t);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
			throw new DAOException("Erro de inserção no banco de dados");
		} finally {
			entityManager.close();
		}
		return t;
	}

	public T remover(T t) throws DAOException {
		EntityManager entityManager = createEntityManager();

		try {

			entityManager.getTransaction().begin();
			entityManager.merge(t);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
			throw new DAOException("Erro de inserção no banco de dados");
		} finally {
			entityManager.close();
		}
		return t;
	}

	public T deletar(T t) throws DAOException {
		EntityManager entityManager = createEntityManager();

		try {
			t.setAtivade(false);
			entityManager.getTransaction().begin();
			entityManager.remove(t);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
			throw new DAOException("Erro de inserção no banco de dados");
		} finally {
			entityManager.close();
		}
		return t;
	}

	public T atualizar(T t) throws DAOException {
		EntityManager entityManager = createEntityManager();

		try {
			entityManager.getTransaction().begin();
			entityManager.merge(t);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
			throw new DAOException("Erro de inserção no banco de dados");
		} finally {
			entityManager.close();
		}
		return t;
	}

	public T buscar (int id, Class<T> classe) throws DAOException{
		EntityManager entityManager = createEntityManager();
		T t = null;
		try {
			t = entityManager.find(classe, id);
			
		}catch (NoResultException e) {
				e.printStackTrace();
				t = null;
			}
		 catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
			throw new DAOException("Erro de inserção no banco de dados");
		} finally {
			entityManager.close();
		}
		return t;
		}
	
	public T getConsultaSQLGenerica(String sql, Class<T> classe) {
		EntityManager entityManager = createEntityManager();
		T t = null;
		Query query = entityManager.createQuery(sql, classe);
		t = (T) query.getSingleResult();
		return null;
	}
}