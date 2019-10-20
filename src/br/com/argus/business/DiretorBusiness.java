/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.argus.business;

import br.com.argus.dao.DiretorDAO;
import br.com.argus.dao.IDiretorDAO;
import br.com.argus.exceptions.ValidacaoException;
import br.com.argus.model.Diretor;

/**
 *
 * @author santo
 */
public class DiretorBusiness extends Business<Diretor> implements IDiretorBusiness{

    private IDiretorDAO iDiretorDAO;
    public DiretorBusiness() {
        iDiretorDAO = new DiretorDAO();
        init(iDiretorDAO);
    }
    
    
    @Override
    public void isValid(Diretor t) throws ValidacaoException {
       
    }
    
}
