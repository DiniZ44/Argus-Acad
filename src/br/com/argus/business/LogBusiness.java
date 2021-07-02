/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.argus.business;

import br.com.argus.dao.ILogDAO;
import br.com.argus.dao.LodDAO;
import br.com.argus.exceptions.BussinesException;
import br.com.argus.exceptions.DAOException;
import br.com.argus.exceptions.ValidacaoException;
import br.com.argus.model.Log;
import java.util.List;

/**
 *
 * @author Hakkinen
 */
public class LogBusiness extends Business<Log> implements ILogBusiness{
    
    private ILogDAO logDAO;

    public LogBusiness() {
        
        logDAO = new LodDAO();
        init(logDAO);
    }
    
    

    @Override
    public void isValid(Log t) throws ValidacaoException {
        
    }

    @Override
    public List<Log> buscarTudo() throws BussinesException {
        try {
            List<Log> usuarios = logDAO.buscarTudo();
            return usuarios;
        } catch (DAOException e) {
            e.printStackTrace();
            throw new BussinesException(e.getMessage());
        }
    }
    
}
