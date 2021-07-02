/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.argus.model;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Hakkinen
 */
@Entity
@Table(name = "log")
@SequenceGenerator(name = Entidade.SEQUENCE_ENTIDADE, sequenceName = Log.SEQUENCE_ENTIDADE, initialValue = 1, allocationSize = 1)
public class Log extends Entidade{
    
        private static final long serialVersionUID = 1L;
        protected static final String SEQUENCE_ENTIDADE = "log_sequence";
//)
	@Column
	private String autor;
	
	@Column
	private String tabela;
	
	@Column
	private String alteracao;
	
	@Column
	private LocalDate data;

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTabela() {
        return tabela;
    }

    public void setTabela(String tabela) {
        this.tabela = tabela;
    }

    public String getAlteracao() {
        return alteracao;
    }

    public void setAlteracao(String alteracao) {
        this.alteracao = alteracao;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
        
        
    
}
