/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.argus.business;

import br.com.argus.dao.ISecretarioDAO;
import br.com.argus.dao.SecretarioDAO;
import br.com.argus.exceptions.ValidacaoException;
import br.com.argus.model.Secretario;

/**
 *
 * @author santo
 */
public class SecretarioBusiness extends Business<Secretario> implements ISecretarioBusiness{
    
    private ISecretarioDAO secretarioDAO;

    public SecretarioBusiness() {
    secretarioDAO = new SecretarioDAO();
        init(secretarioDAO);
    }
    
    

    @Override
    public void isValid(Secretario t) throws ValidacaoException {
        
    }
    
}
