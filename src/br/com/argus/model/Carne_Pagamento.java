/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.argus.model;

import java.time.LocalDate;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author santo
 */
@Entity
@Table(name = "carne_pagamento")
@SequenceGenerator(name = Entidade.SEQUENCE_ENTIDADE, sequenceName = Carne_Pagamento.SEQUENCE_ENTIDADE, initialValue = 1, allocationSize = 1)
public class Carne_Pagamento extends Entidade{
    
    public static final long serialVersionUID = 1L;
    protected static final String SEQUENCE_ENTIDADE = "carne_pagamento_sequence";
    
    @Column
    private double valor;
    
    @Column(nullable = false, length = 9)
    private LocalDate data;
    
    @OneToOne(cascade = CascadeType.ALL)
    private Resp_Financeiro resp_Financeiro;

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Resp_Financeiro getResp_Financeiro() {
        return resp_Financeiro;
    }

    public void setResp_Financeiro(Resp_Financeiro resp_Financeiro) {
        this.resp_Financeiro = resp_Financeiro;
    }
    
    
    
}
