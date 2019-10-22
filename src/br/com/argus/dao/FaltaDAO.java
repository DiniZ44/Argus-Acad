/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.argus.dao;

import br.com.argus.model.Falta;

/**
 *
 * @author santo
 */
public class FaltaDAO extends Dao<Falta> implements IFaltaDAO{
    
    public FaltaDAO() {
        super(Falta.class);
    }
    
}
