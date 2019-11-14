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
@Table(name = "professor")
@SequenceGenerator(name = Entidade.SEQUENCE_ENTIDADE, sequenceName = Professor.SEQUENCE_ENTIDADE, initialValue = 1, allocationSize = 1)
public class Professor extends Entidade{
   
    public static final long serialVersionUID = 1L;
    protected static final String SEQUENCE_ENTIDADE = "professor_sequence";
    
    @Column(nullable = false)
    private String nome;
    
    @Column(nullable = false)
    private String naturalidade;
    
    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco;
    
    @Column(nullable = false)
    private LocalDate data_nascimento;
    
    @Column(nullable = false, unique = true, length = 11)
    private String cpf;
    
    @OneToOne(cascade = CascadeType.ALL)
    private Contato contato;

    @Override
    public String toString() {
        return "Professor{" + "nome=" + nome + ", naturalidade=" + naturalidade + ", endereco=" + endereco + ", data_nascimento=" + data_nascimento + ", cpf=" + cpf + ", contato=" + contato + '}';
    }

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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }
    
}


