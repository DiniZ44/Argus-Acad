/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.argus.business;

import br.com.argus.exceptions.BussinesException;
import br.com.argus.model.Log;
import java.util.List;

/**
 *
 * @author Hakkinen
 */
public interface ILogBusiness extends IBusiness<Log>{
    
    public List<Log> buscarTudo () throws BussinesException;
    
}
