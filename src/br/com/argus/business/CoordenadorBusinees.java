/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.argus.business;

import br.com.argus.dao.CoordenadorDao;
import br.com.argus.dao.ICoordenadorDAO;
import br.com.argus.exceptions.ValidacaoException;
import br.com.argus.model.Coordenador;

/**
 *
 * @author santo
 */
public class CoordenadorBusinees extends Business<Coordenador> implements ICoordenadorBusiness{
    
    
    private ICoordenadorDAO coordenadorDAO;
            
    public CoordenadorBusinees() {
        coordenadorDAO = new CoordenadorDao();
        init(coordenadorDAO);
    }
    
    

    @Override
    public void isValid(Coordenador t) throws ValidacaoException {
    }
    
}
