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
public enum TipoEnsino {
            
        EM ("Ensino Médio"), EF ("Ensino Fundamental"), 
	EMF ("Ensino Médio Anos Finais");
	
	private String descricao;
	
	/**
	 * 
	 */
	private TipoEnsino(String descricao) {
	
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
		return descricao;
	}
	
    
}
