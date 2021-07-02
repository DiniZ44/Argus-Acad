/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.argus.business;

import br.com.argus.dao.ITurmaDAO;
import br.com.argus.dao.TurmaDAO;
import br.com.argus.exceptions.ValidacaoException;
import br.com.argus.model.Turma;

/**
 *
 * @author santo
 */
public class TurmaBisiness extends Business<Turma> implements ITurmaBisiness{
    
    private ITurmaDAO iTurmaDAO;

    public TurmaBisiness() {
        iTurmaDAO = new TurmaDAO();
        init(iTurmaDAO);
    }
    
    

    @Override
    public void isValid(Turma t) throws ValidacaoException {
       
    }
    
}
