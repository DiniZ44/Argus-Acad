/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.argus.business;

import br.com.argus.dao.IVinculoAlunoTurmaDAO;
import br.com.argus.dao.VinculoAlunoTurmaDAO;
import br.com.argus.exceptions.ValidacaoException;
import br.com.argus.model.VinculoAlunoTurma;

/**
 *
 * @author santo
 */
public class VinculoAlunoTurmaBusiness  extends Business<VinculoAlunoTurma> implements IVinculoAlunoTurmaBusiness{
    
    private IVinculoAlunoTurmaDAO iVinculoAlunoTurmaDAO;

    public VinculoAlunoTurmaBusiness() {
    iVinculoAlunoTurmaDAO = new VinculoAlunoTurmaDAO();
        init(iVinculoAlunoTurmaDAO);
    
    }
    
    
    
    @Override
    public void isValid(VinculoAlunoTurma t) throws ValidacaoException {
        
    }
    
}
