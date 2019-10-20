/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.argus.model;

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
@Table(name = "secretaria")
@SequenceGenerator(name = Entidade.SEQUENCE_ENTIDADE, sequenceName = Secretario.SEQUENCE_ENTIDADE, initialValue = 1, allocationSize = 1)
public class Secretario extends Entidade{
    
    public static final long serialVersionUID = 1L;
    protected static final String SEQUENCE_ENTIDADE = "secretaria_sequence";
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private Usuario usuario;
    
    @Column(nullable = false, unique = true)
    private String Cpf;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getCpf() {
        return Cpf;
    }

    public void setCpf(String Cpf) {
        this.Cpf = Cpf;
    }

    @Override
    public String toString() {
        return "Secretario{" + "usuario=" + usuario + ", Cpf=" + Cpf + '}';
    }
    
    
}
