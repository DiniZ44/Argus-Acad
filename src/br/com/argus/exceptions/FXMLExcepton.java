/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.argus.exceptions;
import java.io.IOException;
/**
 *
 * @author santo
 */
public class FXMLExcepton extends IOException{
    
    public FXMLExcepton(String mensagem) {
        super(mensagem);
    }
    
}
