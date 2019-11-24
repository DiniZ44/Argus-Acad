/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.argus.enuns;

/**
 *
 * @author Hakkinen
 */
public enum ResetSenha {
    
    
     SIM ("Solicitou RESET SENHA"), NAO ("-");

    
    private final String descricao;
    
    	private ResetSenha(String descricao) {
	
		this.descricao = descricao;
	}
	
	public String getValor() {
		return this.descricao;
	}
	

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return descricao;
	}
}
