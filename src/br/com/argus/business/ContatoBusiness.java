/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.argus.business;

import br.com.argus.dao.ContatoDAO;
import br.com.argus.dao.IContatoDAO;
import br.com.argus.exceptions.ValidacaoException;
import br.com.argus.model.Contato;

/**
 *
 * @author santo
 */
public class ContatoBusiness extends Business<Contato> implements IContatoBusiness{
    
    private IContatoDAO contatoDAO;

    public ContatoBusiness() {
    contatoDAO = new ContatoDAO();
        init(contatoDAO);
    }
    
    

    @Override
    public void isValid(Contato t) throws ValidacaoException {
        if(t.getEmail().isEmpty()){
        throw new ValidacaoException("O campo Email não pode está vazio");
        }
        if(t.getCelular().isEmpty()){
        throw new ValidacaoException("O campo Celular não pode está vazio");
        }
        if(t.getTelefone().isEmpty()){
        throw new ValidacaoException("O campo Telefone não pode está vazio");
        }
    }
    
}
