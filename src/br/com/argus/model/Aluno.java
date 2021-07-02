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
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
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
@Table(name = "aluno")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@SequenceGenerator(name = Entidade.SEQUENCE_ENTIDADE, sequenceName = Aluno.SEQUENCE_ENTIDADE, initialValue = 1, allocationSize = 1)
public class Aluno extends Entidade{
    
    public static final long serialVersionUID = 1L;
    protected static final String SEQUENCE_ENTIDADE = "aluno_sequence";
    
    @Column(nullable = false, length = 150)
    private String nome;
    
    @Column(length = 50)
    private String Matricula;
    
    @Column(nullable = false, length = 50)
    private String naturalidade;
    
    @ManyToOne
    private Resp_Financeiro responsavel_financeiro;
    
    @Column(nullable = false, length = 150)
    private String pai;
    
    @Column(nullable = false, length = 150)
    private String mae;
   
    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco;
    
    @Column
    private LocalDate data_nascimento;
    
    
    @OneToOne(cascade = CascadeType.ALL)
    private Contato contato;
    
    
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNaturalidade() {
        return naturalidade;
    }

    public void setNaturalidade(String naturalidade) {
        this.naturalidade = naturalidade;
    }

    public Resp_Financeiro getResponsavel_financeiro() {
        return responsavel_financeiro;
    }

    public void setResponsavel_financeiro(Resp_Financeiro responsavel_financeiro) {
        this.responsavel_financeiro = responsavel_financeiro;
    }

    public String getPai() {
        return pai;
    }

    public void setPai(String pai) {
        this.pai = pai;
    }

    public String getMae() {
        return mae;
    }

    public void setMae(String mae) {
        this.mae = mae;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public LocalDate getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(LocalDate data_nascimento) {
        this.data_nascimento = data_nascimento;
    }


    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

    public String getMatricula() {
        return Matricula;
    }

    public void setMatricula(String Matricula) {
        this.Matricula = Matricula;
    }

    @Override
    public String toString() {
        return "" + nome;
    }
    
    
    
    
    
}
