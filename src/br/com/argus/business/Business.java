/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.argus.business;

import br.com.argus.exceptions.BussinesException;
import br.com.argus.exceptions.DAOException;
import br.com.argus.exceptions.ValidacaoException;
import br.com.argus.model.Entidade;
import java.util.List;
import br.com.argus.dao.IDao;

/**
 *
 * @author santo
 * @param <T>
 */
public abstract class Business<T extends Entidade> implements IBusiness<T>{
    
    protected IDao<T> dao;

    @Override
    public void init(IDao<T> dao) {
        this.dao = dao;
    }

    @Override
    public void criarOuAtualizar(T t) throws BussinesException {
         
        
        try {
            if(t.getId() == null){
                dao.inserir(t);
            }else{
                dao.atualizar(t);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
            throw new BussinesException(e.getMessage());
        }
        }

    @Override
    public T buscar(Class<T> t, int id) throws BussinesException {
        
        T tt = null;
	try {	
            tt = dao.buscar(t, id);
        } catch (DAOException e) {
		e.printStackTrace();
		System.err.println(e.getMessage());
		throw new BussinesException(e.getMessage());
		}
		return tt;
    }

    @Override
    public void deletar(T t) throws BussinesException {
	try {	
           dao.deletar(t);
        } catch (DAOException e) {
		e.printStackTrace();
		System.err.println(e.getMessage());
		throw new BussinesException(e.getMessage());
		}
		
    }

    @Override
    public void remover(T t) throws BussinesException {
	try {	
             dao.desabilitar(t);
        } catch (DAOException e) {
		e.printStackTrace();
		System.err.println(e.getMessage());
		throw new BussinesException(e.getMessage());
		}
		
    }

    @Override
    public List<T> buscarTodos() throws DAOException {
                T tt = null;
	try {	
           return dao.buscarTodos();
        } catch (DAOException e) {
		e.printStackTrace();
		System.err.println(e.getMessage());
		throw new BussinesException(e.getMessage());
		}
    }

    
    
    }
