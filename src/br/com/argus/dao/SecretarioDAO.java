/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.argus.dao;

import br.com.argus.model.Secretario;

/**
 *
 * @author santo
 */
public class SecretarioDAO extends Dao<Secretario> implements ISecretarioDAO{
    
    public SecretarioDAO() {
        super(Secretario.class);
    }
    
}
