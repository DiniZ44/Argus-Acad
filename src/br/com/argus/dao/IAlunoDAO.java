/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.argus.dao;

import br.com.argus.exceptions.DAOException;
import br.com.argus.model.Aluno;
import java.util.List;

/**
 *
 * @author santo
 */
public interface IAlunoDAO extends IDao<Aluno>{
    
    public List<Aluno> buscarALL() throws DAOException;
}
