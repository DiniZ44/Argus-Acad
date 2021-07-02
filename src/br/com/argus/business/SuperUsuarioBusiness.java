/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.argus.business;

import br.com.argus.dao.ISuperUsuarioDAO;
import br.com.argus.dao.SuperUsuarioDAO;
import br.com.argus.exceptions.ValidacaoException;
import br.com.argus.model.SuperUsuario;

/**
 *
 * @author santo
 */
public class SuperUsuarioBusiness extends Business<SuperUsuario> implements ISuperUsuarioBusiness{
    private ISuperUsuarioDAO iSuperUsuarioDAO;

    public SuperUsuarioBusiness() {
    
    iSuperUsuarioDAO = new SuperUsuarioDAO();
        init(iSuperUsuarioDAO);
    }
    
    

    @Override
    public void isValid(SuperUsuario t) throws ValidacaoException {
        
    }
    
}
