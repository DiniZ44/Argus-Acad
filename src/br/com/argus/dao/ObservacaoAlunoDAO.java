/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.argus.dao;

import br.com.argus.model.ObservacaoAluno;

/**
 *
 * @author santo
 */
public class ObservacaoAlunoDAO extends Dao<ObservacaoAluno> implements IObservacaoAlunoDAO{
    
    public ObservacaoAlunoDAO() {
        super(ObservacaoAluno.class);
    }
    
}
