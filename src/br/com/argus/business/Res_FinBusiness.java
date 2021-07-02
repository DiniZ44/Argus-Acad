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
import br.com.argus.exceptions.BussinesException;
import br.com.argus.exceptions.DAOException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    
    @Override
    public Resp_Financeiro buscarRep (String pesquisa) throws BussinesException {
        Resp_Financeiro prof;
        try {
            prof = iResp_FinDAO.buscarRep(pesquisa);
            return prof;
        } catch (DAOException ex) {
            ex.printStackTrace();
            throw new BussinesException(ex.getMessage());
        }
        }

    
    
            
      public void isValid(Resp_Financeiro t) throws ValidacaoException {
       
    }

    @Override
    public Resp_Financeiro buscarCPF(String cpf) throws BussinesException {

        try {
               Resp_Financeiro responsavel = iResp_FinDAO.buscarCPF(cpf);
            return responsavel;
        } catch (DAOException ex) {
            ex.printStackTrace();
            throw new BussinesException(ex.getMessage());
        }
    }
    
}
