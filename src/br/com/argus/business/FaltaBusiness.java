/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.argus.business;

import br.com.argus.exceptions.ValidacaoException;
import br.com.argus.model.Falta;

/**
 *
 * @author santo
 */
public class FaltaBusiness extends Business<Falta> implements IFaltaBusiness{

    @Override
    public void isValid(Falta t) throws ValidacaoException {
        
    }
    
}
