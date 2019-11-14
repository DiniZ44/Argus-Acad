/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.argus.business;

import br.com.argus.dao.IProfessorDAO;
import br.com.argus.dao.ProfessorDAO;
import br.com.argus.exceptions.BussinesException;
import br.com.argus.exceptions.DAOException;
import br.com.argus.exceptions.ValidacaoException;
import br.com.argus.model.Professor;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author santo
 */
public class ProfessorBusiness extends Business<Professor> implements IProfessorBusiness{
    private IProfessorDAO iProfessorDAO;

    public ProfessorBusiness() {
    iProfessorDAO = new ProfessorDAO();
        init(iProfessorDAO);
    }
    
    
    @Override
    public void isValid(Professor t) throws ValidacaoException {
        
    }

    @Override
    public Professor buscarProf(String pesquisa) throws BussinesException {
        try {
            Professor prof = iProfessorDAO.buscarProf(pesquisa);
            return prof;
        } catch (DAOException ex) {
            ex.printStackTrace();
            throw new BussinesException(ex.getMessage());
        }

    }
    
}
