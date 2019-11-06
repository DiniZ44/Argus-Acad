/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.argus.business;

import br.com.argus.exceptions.ValidacaoException;
import br.com.argus.model.Carne_Pagamento;

/**
 *
 * @author santo
 */
public class CarnePagamentoBusiness extends Business<Carne_Pagamento> implements ICarnePagamentoBusiness{

    @Override
    public void isValid(Carne_Pagamento t) throws ValidacaoException {
       
    }
    
}
