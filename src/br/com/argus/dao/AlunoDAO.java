/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.argus.dao;

import br.com.argus.model.Aluno;

/**
 *
 * @author santo
 */
public class AlunoDAO extends Dao<Aluno> implements IAlunoDAO{
    
    public AlunoDAO() {
        super(Aluno.class);
    }
    
}
