/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.argus.exceptions;

/**
 *
 * @author santo
 */
public class BussinesException extends DAOException{
    
    public BussinesException(String mensagem) {
        super(mensagem);
    }
    
    
}
