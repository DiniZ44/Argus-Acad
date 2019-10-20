/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.argus.business;

import br.com.argus.dao.AlunoDAO;
import br.com.argus.dao.IAlunoDAO;
import br.com.argus.exceptions.ValidacaoException;
import br.com.argus.model.Aluno;

/**
 *
 * @author santo
 */
public class AlunoBusiness extends Business<Aluno> implements IAlunoBusiness{

     private IAlunoDAO alunoDAO;

    public AlunoBusiness() {
        alunoDAO = new AlunoDAO();
        init(alunoDAO);
    }
     
     
    @Override
    public void isValid(Aluno t) throws ValidacaoException {
        if(t.getCpf().isEmpty()){
        throw new ValidacaoException("Campo cpf não pode está vazio");
        }
        if(t.getMae().isEmpty()){
        throw new ValidacaoException("Campo Mãe não pode está vazio");
        }
        if(t.getNaturalidade().isEmpty()){
        throw new ValidacaoException("Campo Naturalidade não pode está vazio");
        }
        if(t.getNome().isEmpty()){
        throw new ValidacaoException("Campo Nome não pode está vazio");
        }
        if(t.getPai().isEmpty()){
        throw new ValidacaoException("Campo Pai não pode está vazio");
        }
    }
    
}
