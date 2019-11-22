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
import javax.persistence.ManyToOne;
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
    private LocalDate data_vencimento;
    
    @Column(length = 9)
    private LocalDate data_pago;
    
    @ManyToOne(cascade = CascadeType.MERGE)
    private Aluno aluno;

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public LocalDate getData_vencimento() {
        return data_vencimento;
    }

    public void setData_vencimento(LocalDate data_vencimento) {
        this.data_vencimento = data_vencimento;
    }

    public LocalDate getData_pago() {
        return data_pago;
    }

    public void setData_pago(LocalDate data_pago) {
        this.data_pago = data_pago;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
    
    
        
}
