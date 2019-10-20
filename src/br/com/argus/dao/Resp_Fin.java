/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.argus.dao;

import br.com.argus.model.Resp_Financeiro;

/**
 *
 * @author santo
 */
public class Resp_Fin extends Dao<Resp_Financeiro> implements IResp_Fin{
    
    public Resp_Fin() {
        super(Resp_Financeiro.class);
    }
    
}
