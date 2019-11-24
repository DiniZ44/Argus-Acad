/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.argus.dao;

import br.com.argus.model.Log;

/**
 *
 * @author Hakkinen
 */
public class LodDAO extends Dao<Log>implements ILogDAO{
    
    public LodDAO() {
        super(Log.class);
    }
    
}
