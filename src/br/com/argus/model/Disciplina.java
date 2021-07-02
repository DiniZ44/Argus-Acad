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
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author santo
 */
@Entity
@Table(name = "disciplina")
@SequenceGenerator(name = Entidade.SEQUENCE_ENTIDADE, sequenceName = Disciplina.SEQUENCE_ENTIDADE, initialValue = 1, allocationSize = 1)
public class Disciplina extends Entidade{
    
    public static final long serialVersionUID = 1L;
    protected static final String SEQUENCE_ENTIDADE = "disciplina_sequence";
    
    @Column(nullable = false, unique = true)
    private String codigo;
    
    @Column(nullable = false, length = 150)
    private String nome;
    
    @ManyToOne
    private Professor professor;
    
    @Column(nullable = false, length = 10)
    private String carga_horaria;
    
    @Enumerated(EnumType.STRING)
    private TipoSituacao statusAluno;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public String getCarga_horaria() {
        return carga_horaria;
    }

    public void setCarga_horaria(String carga_horaria) {
        this.carga_horaria = carga_horaria;
    }

    public TipoSituacao getStatusAluno() {
        return statusAluno;
    }

    public void setStatusAluno(TipoSituacao statusAluno) {
        this.statusAluno = statusAluno;
    }

    @Override
    public String toString() {
        return "" + nome;
    }


    
    
    
}
