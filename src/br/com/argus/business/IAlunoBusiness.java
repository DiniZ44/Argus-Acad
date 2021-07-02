/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.argus.business;

import br.com.argus.exceptions.BussinesException;
import br.com.argus.model.Aluno;
import java.util.List;

/**
 *
 * @author santo
 */
public interface IAlunoBusiness extends IBusiness<Aluno>{
    
       // public List<Aluno> buscarAlunosTabela(String string) throws BussinesException; 
        public List<Aluno> buscarALL() throws Exception;
}
