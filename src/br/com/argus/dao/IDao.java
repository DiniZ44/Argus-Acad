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
 */
public interface IDao <T extends Entidade>{
    
    public T buscar (Class<T> classe, int id) throws DAOException;
    
     public void desabilitar(T t) throws DAOException;
     
     public void deletar(T t) throws DAOException;
     
     public void atualizar(T t) throws DAOException;
     
     public void inserir(T t) throws DAOException;
     
     public List<T> buscarTodos() throws DAOException;
    
}
