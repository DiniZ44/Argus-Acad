/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.argus.dao;

import br.com.argus.model.Disciplina;

/**
 *
 * @author santo
 */
public class DisciplinaDAO extends Dao<Disciplina> implements IDisciplinaDAO{
    
    public DisciplinaDAO() {
        super(Disciplina.class);
    }
    
}
