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
@Table(name = "cord_pedagogo")
public class Coordenador extends Entidade{
    
    @Column(nullable = false)
    private Usuario usuario;
    @Column(nullable = false, unique = true)
    private String Cpf;

    public Usuario getUsuario() {
        return usuario;
    }


    public String getCpf() {
        return Cpf;
    }

    public void setCpf(String Cpf) {
        this.Cpf = Cpf;
    }

    @Override
    public String toString() {
        return "Coordenador{" + "usuario=" + usuario + ", Cpf=" + Cpf + '}';
    }
    
    
    
    
}
