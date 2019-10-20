/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.argus.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author santo
 */
@Entity
@Table(name = "resp_financeiro")
public class Resp_Financeiro extends Entidade{
    
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false, unique = true)
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
        return "Resp_Financeiro{" + "nome=" + nome + ", cpf=" + cpf + '}';
    }
    
    
}
