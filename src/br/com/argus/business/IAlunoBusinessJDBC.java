/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.argus.business;
import br.com.argus.model.Aluno;

/**
 *
 * @author santo
 */
public interface IAlunoBusinessJDBC {
    
    public void inserir (Aluno aluno) throws Exception;
    public Aluno buscar (Aluno aluno) throws Exception;
    
}
