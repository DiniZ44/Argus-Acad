/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.argus.dao;

import br.com.argus.model.Contato;

/**
 *
 * @author santo
 */
public class ContatoDAO extends Dao<Contato> implements IContatoDAO{
    
    public ContatoDAO() {
        super(Contato.class);
    }
    
}
