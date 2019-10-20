/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.argus.model;

import br.com.argus.enuns.TipoSituacao;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

/**
 *
 * @author santo
 */

@Entity
@Table(name = "turma")
public class Turma extends Entidade{
    
    @JoinColumn
    private Aluno aluno;
    @JoinColumn
    private Disciplina disciplina;
    @Column
    private String nota;
    @Enumerated(EnumType.STRING)
    private TipoSituacao statusAluno;

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

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public TipoSituacao getStatusAluno() {
        return statusAluno;
    }

    public void setStatusAluno(TipoSituacao statusAluno) {
        this.statusAluno = statusAluno;
    }

    @Override
    public String toString() {
        return "Turma{" + "aluno=" + aluno + ", disciplina=" + disciplina + ", nota=" + nota + ", statusAluno=" + statusAluno + '}';
    }
    
    
}
