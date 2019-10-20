/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.argus.business;

import br.com.argus.exceptions.ValidacaoException;
import br.com.argus.model.Resp_Financeiro;
import br.com.argus.dao.IResp_FinDAO;
import br.com.argus.dao.Resp_FinDAO;

/**
 *
 * @author santo
 */
public class Res_FinBusiness extends Business<Resp_Financeiro> implements IRes_FinBusiness{
    private IResp_FinDAO iResp_FinDAO;

    public Res_FinBusiness() {
    iResp_FinDAO = new Resp_FinDAO();
        init(iResp_FinDAO);
    }
    
    
            
      public void isValid(Resp_Financeiro t) throws ValidacaoException {
       
    }
    
}
