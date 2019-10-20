/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.argus.model;

import br.com.argus.enuns.TipoEstadoUF;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author santo
 */
@Entity
@Table(name = "endereco")
@SequenceGenerator(name = Entidade.SEQUENCE_ENTIDADE, sequenceName = Endereco.SEQUENCE_ENTIDADE, initialValue = 1, allocationSize = 1)
public class Endereco extends Entidade{
    
    private static final long serialVersionUID = 1L;
    protected static final String SEQUENCE_ENTIDADE = "endereco_sequence";
    
    @Column(nullable = false, length = 120)
    private String logradouro;
    
    @Column(nullable = false, length = 10)
    private String numero;
    
    @Column(nullable = false, length = 40)
    private String bairro;
    
    @Column(nullable = false, length = 50)
    private String cidade;
    
    @Column(nullable = false, length = 9)
    private String cep;
    
    @Enumerated(EnumType.STRING)
    private TipoEstadoUF tipoEstadoUF;

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public TipoEstadoUF getTipoEstadoUF() {
        return tipoEstadoUF;
    }

    public void setTipoEstadoUF(TipoEstadoUF tipoEstadoUF) {
        this.tipoEstadoUF = tipoEstadoUF;
    }

    @Override
    public String toString() {
        return "Endereco{" + "logradouro=" + logradouro + ", numero=" + numero + ", bairro=" + bairro + ", cidade=" + cidade + ", cep=" + cep + ", tipoEstadoUF=" + tipoEstadoUF + '}';
    }
    
    
    
}
