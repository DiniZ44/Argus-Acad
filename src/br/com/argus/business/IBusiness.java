/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.argus.business;

import br.com.argus.exceptions.BussinesException;
import br.com.argus.exceptions.ValidacaoException;
import br.com.argus.model.Entidade;
import java.util.List;
import br.com.argus.dao.IDao;

/**
 *
 * @author santo
 * @param <T>
 */
public interface IBusiness <T extends Entidade>{
    
    public void init (IDao<T> dao);
    
    public T buscar(Class<T> t, int id) throws BussinesException;
    
    public T criarOuAtualizar (T t) throws BussinesException;
    
    public T deletar (T t) throws BussinesException;
    
    public T desabilitar (T t) throws BussinesException;
    
    public List<T> buscarTodos() throws BussinesException;
    
    public void isValid(T t) throws ValidacaoException;
}
