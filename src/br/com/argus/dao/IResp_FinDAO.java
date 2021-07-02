/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.argus.dao;

import br.com.argus.exceptions.DAOException;
import br.com.argus.model.Resp_Financeiro;

/**
 *
 * @author santo
 */
public interface IResp_FinDAO extends IDao<Resp_Financeiro>{
    
    public Resp_Financeiro buscarRep (String pesquisa) throws DAOException;
    
    public Resp_Financeiro buscarCPF (String cpf) throws DAOException;
    
}
