/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.argus.model;
//
import java.util.logging.Logger;
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
public abstract class Entidade {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private boolean ativade = true;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isAtivade() {
        return ativade;
    }

    public void setAtivade(boolean ativade) {
        this.ativade = ativade;
    }
    private static final Logger LOG = Logger.getLogger(Entidade.class.getName());
    
    
    
    
}
