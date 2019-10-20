/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.argus.dao;

import br.com.argus.model.Turma;

/**
 *
 * @author santo
 */
public class TurmaDAO extends Dao<Turma> implements ITurmaDAO{
    
    public TurmaDAO() {
        super(Turma.class);
    }
    
}
