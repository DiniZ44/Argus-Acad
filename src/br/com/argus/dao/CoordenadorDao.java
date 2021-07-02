/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.argus.dao;

import br.com.argus.model.Coordenador;

/**
 *
 * @author santo
 */
public class CoordenadorDao extends Dao<Coordenador> implements ICoordenadorDAO{
    
    public CoordenadorDao() {
        super(Coordenador.class);
    }
    
}
