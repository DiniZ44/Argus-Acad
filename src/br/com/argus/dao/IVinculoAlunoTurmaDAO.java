/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.argus.dao;

import br.com.argus.exceptions.DAOException;
import br.com.argus.model.VinculoAlunoTurma;
import br.com.argus.model.Turma;
import java.util.List;

/**
 *
 * @author santo
 */
public interface IVinculoAlunoTurmaDAO extends IDao<VinculoAlunoTurma>{
    
    public List<VinculoAlunoTurma> buscarTurma(Turma turma) throws DAOException;
    
}
