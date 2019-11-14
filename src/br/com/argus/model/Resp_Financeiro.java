/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.argus.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author santo
 */
@Entity
@Table(name = "resp_financeiro")
@SequenceGenerator(name = Entidade.SEQUENCE_ENTIDADE, sequenceName = Resp_Financeiro.SEQUENCE_ENTIDADE, initialValue = 1, allocationSize = 1)
public class Resp_Financeiro extends Entidade{
    
    private static final long serialVersionUID = 1L;
    protected static final String SEQUENCE_ENTIDADE = "resp_fin_sequence";
    
    @Column(nullable = false, length = 50)
    private String nome;
    
    @Column(nullable = false, unique = true, length = 11)
    private String cpf;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return  "" + nome ;
    }
    

//    @Override
//    public String toString() {
//        return "Resp_Financeiro{" + "nome=" + nome + ", cpf=" + cpf + '}';
//    }
    
    
}
