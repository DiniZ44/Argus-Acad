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
public enum TipoSituacao {
    
        AM ("Aprovado por media"), AP ("Aprovado"), 
	RP ("Reprovado");
	
	private String descricao;
	
	/**
	 * 
	 */
	private TipoSituacao(String descricao) {
	
		this.descricao = descricao;
	}
	
	public String getValor() {
		return this.descricao;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Enum#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getValor();
	}
    
}
