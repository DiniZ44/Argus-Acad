/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.argus.business;


import br.com.argus.exceptions.ValidacaoException;
import br.com.argus.model.DisciplinaTurma;
import br.com.argus.dao.IDisciplinaTurmaDAO;
import br.com.argus.dao.DisciplinaTurmaDAO;
/**
 *
 * @author Hakkinen
 */
public class DisciplinaTurmaBussiness extends Business<DisciplinaTurma> implements IDisciplinaTurmaBussiness{

    private IDisciplinaTurmaDAO idisciplinaTurmaDAO;
    
    public DisciplinaTurmaBussiness() {
        idisciplinaTurmaDAO = new DisciplinaTurmaDAO();
            init(idisciplinaTurmaDAO);
    }
    @Override
    public void isValid(DisciplinaTurma t) throws ValidacaoException {
        
    }
    
}
