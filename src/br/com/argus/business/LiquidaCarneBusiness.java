/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.argus.business;

import br.com.argus.dao.ILiquidaCarneDAO;
import br.com.argus.dao.LiquidaCarneDAO;
import br.com.argus.exceptions.ValidacaoException;
import br.com.argus.model.LiquidaCarne;

/**
 *
 * @author santo
 */
public class LiquidaCarneBusiness extends Business<LiquidaCarne> implements ILiquidaCarneBusiness{
    
    private ILiquidaCarneDAO iLiquidaCarneDAO;

    public LiquidaCarneBusiness() {
    iLiquidaCarneDAO = new LiquidaCarneDAO();
        init(iLiquidaCarneDAO);
        
    }
    
    
    @Override
    public void isValid(LiquidaCarne t) throws ValidacaoException {
        
    }
    
}
