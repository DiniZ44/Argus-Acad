/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.argus.business;

import br.com.argus.dao.EnderecoDAO;
import br.com.argus.dao.IEnderecoDAO;
import br.com.argus.exceptions.ValidacaoException;
import br.com.argus.model.Endereco;

/**
 *
 * @author santo
 */
public class EnderecoBusiness extends Business<Endereco> implements IEnderecoBusiness{

    private IEnderecoDAO enderecoDAO;
    
    public EnderecoBusiness() {
        
        enderecoDAO = new EnderecoDAO();
        init(enderecoDAO);
    }
    
    @Override
    public void isValid(Endereco t) throws ValidacaoException {
        if(t.getBairro().isEmpty()) {
        throw new ValidacaoException("O campo Bairro não pode está vazio");
        }
        if(t.getCep().isEmpty()) {
        throw new ValidacaoException("O campo Cep não pode está vazio");
        }
        if(t.getCidade().isEmpty()) {
        throw new ValidacaoException("O campo Cidade não pode está vazio");
        }
        if(t.getLogradouro().isEmpty()) {
        throw new ValidacaoException("O campo Lougradouro não pode está vazio");
        }
        if(t.getNumero().isEmpty()) {
        throw new ValidacaoException("O campo Número não pode está vazio");
        }
        
    }
    
}
