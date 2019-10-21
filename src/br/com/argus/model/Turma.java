/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.argus.model;

import br.com.argus.enuns.TipoSituacao;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author santo
 */

@Entity
@Table(name = "turma")
@SequenceGenerator(name = Entidade.SEQUENCE_ENTIDADE, sequenceName = Turma.SEQUENCE_ENTIDADE, initialValue = 1, allocationSize = 1)
public class Turma extends Entidade{
    
    public static final long serialVersionUID = 1L;
    protected static final String SEQUENCE_ENTIDADE = "turma_sequence";
    
    @Column(nullable = false, length = 20)
    private String nome;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private Aluno aluno;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private Disciplina disciplina;
    
//    @Column(nullable = false, length = 5)
//    private String nota;
//    
    @Enumerated(EnumType.STRING)
    private TipoSituacao statusAluno;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    
    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

//    public String getNota() {
//        return nota;
//    }
//
//    public void setNota(String nota) {
//        this.nota = nota;
//    }

    public TipoSituacao getStatusAluno() {
        return statusAluno;
    }

    public void setStatusAluno(TipoSituacao statusAluno) {
        this.statusAluno = statusAluno;
    }

    @Override
    public String toString() {
        return "Turma{" + "aluno=" + aluno + ", disciplina=" + disciplina +", statusAluno=" + statusAluno + '}';
    }
    
    
}
