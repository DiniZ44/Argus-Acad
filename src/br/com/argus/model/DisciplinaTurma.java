/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.argus.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Hakkinen
 */
@Entity
@Table(name = "disciplina_turma")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@SequenceGenerator(name = Entidade.SEQUENCE_ENTIDADE, sequenceName = Aluno.SEQUENCE_ENTIDADE, initialValue = 1, allocationSize = 1)
public class DisciplinaTurma extends Entidade{
    
    public static final long serialVersionUID = 1L;
    protected static final String SEQUENCE_ENTIDADE = "disciplina_turma_sequence";
    
    @ManyToOne(cascade = CascadeType.MERGE)
    private Disciplina disciplina;
    
    @ManyToOne(cascade = CascadeType.MERGE)
    private Turma turma;

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    @Override
    public String toString() {
        return "" + turma;
    }
    
    
            
         
    
}
