/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.argus.business;

import br.com.argus.exceptions.ValidacaoException;
import br.com.argus.model.ObservacaoAluno;

/**
 *
 * @author santo
 */
public class ObservacaoAlunoBusiness extends Business<ObservacaoAluno> implements IObservacaoAlunoBusiness{

    @Override
    public void isValid(ObservacaoAluno t) throws ValidacaoException {
        
    }
    
}
