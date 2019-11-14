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
    
    @ManyToOne(cascade = CascadeType.ALL)
    private VinculoAlunoTurma vinculoAlunoTurma;
    
    @ManyToOne
    private Disciplina disciplina;
    
    @ManyToOne
    private Turma turma;
            
         
    
}
