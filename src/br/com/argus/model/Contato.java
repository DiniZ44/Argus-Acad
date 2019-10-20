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
@Table(name = "contato")
public class Contato extends Entidade{
    @Column(nullable = false, length = 14)
    private String telefone;
    @Column(nullable = false, length = 50)
    private String email;
    @Column(nullable = false, length = 14)
    private String celular;

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    @Override
    public String toString() {
        return "Contato{" + "telefone=" + telefone + ", email=" + email + ", celular=" + celular + '}';
    }
    
    
}
