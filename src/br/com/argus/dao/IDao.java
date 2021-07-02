/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.argus.dao;

import br.com.argus.exceptions.DAOException;
import br.com.argus.model.Entidade;
import java.util.List;

/**
 *
 * @author santo
 * @param <T>
 */
public interface IDao <T extends Entidade>{
    
    public T buscar (Class<T> classe, int id) throws DAOException;
    
     public T desabilitar(T t) throws DAOException;
     
     public T deletar(T t) throws DAOException;
     
     public T atualizar(T t) throws DAOException;
     
     public T inserir(T t) throws DAOException;
     
     public List<T> buscarTodos() throws DAOException;
    
}
