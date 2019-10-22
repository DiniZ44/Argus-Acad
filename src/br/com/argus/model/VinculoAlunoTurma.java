/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.argus.model;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author santo
 */

@Entity
@Table(name = "vinculo_aluno")
@SequenceGenerator(name = Entidade.SEQUENCE_ENTIDADE, sequenceName = VinculoAlunoTurma.SEQUENCE_ENTIDADE, initialValue = 1, allocationSize = 1)
public class VinculoAlunoTurma extends Entidade{
    
    public static final long serialVersionUID = 1L;
    protected static final String SEQUENCE_ENTIDADE = "vinculo_aluno_sequence";
    
}
