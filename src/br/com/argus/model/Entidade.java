/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.argus.model;
//

import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.MappedSuperclass;
import javax.persistence.Id;
import javax.persistence.Column;

/**
 *
 * @author santo
 */
@MappedSuperclass
public abstract class Entidade implements Serializable{
    
    public static final long serialVersionUID = 1L;
    protected static final String SEQUENCE_ENTIDADE = "ENTIDADE";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_ENTIDADE)
    private Integer id;
    
    @Column
    private boolean status = true;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public boolean isAtivade() {
        return status;
    }

    public void setAtivade(boolean ativade) {
        this.status = ativade;
    }

    
    
}
