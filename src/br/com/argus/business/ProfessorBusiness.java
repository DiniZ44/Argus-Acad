/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.argus.business;

import br.com.argus.exceptions.ValidacaoException;
import br.com.argus.model.Professor;

/**
 *
 * @author santo
 */
public class ProfessorBusiness extends Business<Professor> implements IProfessorBusiness{

    @Override
    public void isValid(Professor t) throws ValidacaoException {
        
    }
    
}
