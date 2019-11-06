/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.argus.enuns;

/**
 *
 * @author santo
 */
public enum SituacaoAluno {
    
     AM ("Aprovado por média"), AP ("Aprovado"), 
    RP ("Reprovado");
    
    private final String descricao;
    
    	private SituacaoAluno(String descricao) {
	
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
    
