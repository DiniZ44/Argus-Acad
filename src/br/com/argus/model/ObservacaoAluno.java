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
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author santo
 */
@Entity
@Table(name = "observacao_aluno")
@SequenceGenerator(name = Entidade.SEQUENCE_ENTIDADE, sequenceName = ObservacaoAluno.SEQUENCE_ENTIDADE, initialValue = 1, allocationSize = 1)
public class ObservacaoAluno extends Entidade{
    
    public static final long serialVersionUID = 1L;
    protected static final String SEQUENCE_ENTIDADE = "obs_aluno_sequence";
    
    @Column
    private LocalDate data;
   
    @Column(length = Integer.MAX_VALUE)
    private String descricao;
    
    @ManyToOne
    private VinculoAlunoTurma vinculoAlunoTurma;
    
    @ManyToOne
    private Coordenador coordenador;

    
    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public VinculoAlunoTurma getVinculoAlunoTurma() {
        return vinculoAlunoTurma;
    }

    public void setVinculoAlunoTurma(VinculoAlunoTurma vinculoAlunoTurma) {
        this.vinculoAlunoTurma = vinculoAlunoTurma;
    }
    
}
