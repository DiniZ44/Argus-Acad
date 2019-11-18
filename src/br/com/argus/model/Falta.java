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
@Table
@SequenceGenerator(name = Entidade.SEQUENCE_ENTIDADE, sequenceName = Falta.SEQUENCE_ENTIDADE, initialValue = 1, allocationSize = 1)
public class Falta extends Entidade{
    
    public static final long serialVersionUID = 1L;
    protected static final String SEQUENCE_ENTIDADE = "falta_sequence";
    
    @Column
    private LocalDate data;
    
    @Column
    private boolean preseca;
    
    @Column
    private String justificativa;
   
    @OneToOne
    private VinculoAlunoTurma vinculoAlunoTurma;

    
    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public boolean isPreseca() {
        return preseca;
    }

    public void setPreseca(boolean preseca) {
        this.preseca = preseca;
    }

    public String getJustificativa() {
        return justificativa;
    }

    public void setJustificativa(String justificativa) {
        this.justificativa = justificativa;
    }

    public VinculoAlunoTurma getVinculoAlunoTurma() {
        return vinculoAlunoTurma;
    }

    public void setVinculoAlunoTurma(VinculoAlunoTurma vinculoAlunoTurma) {
        this.vinculoAlunoTurma = vinculoAlunoTurma;
    }
    
    
}
