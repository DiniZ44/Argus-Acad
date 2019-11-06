/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.argus.facade;

import br.com.argus.exceptions.BussinesException;
import br.com.argus.exceptions.DAOException;
import br.com.argus.model.Aluno;
import br.com.argus.model.Carne_Pagamento;
import br.com.argus.model.Contato;
import br.com.argus.model.Endereco;
import br.com.argus.model.Usuario;
import br.com.argus.model.Coordenador;
import br.com.argus.model.Diretor;
import br.com.argus.model.Disciplina;
import br.com.argus.model.Falta;
import br.com.argus.model.LiquidaCarne;
import br.com.argus.model.ObservacaoAluno;
import br.com.argus.model.Professor;
import br.com.argus.model.Resp_Financeiro;
import br.com.argus.model.SuperUsuario;
import br.com.argus.model.Turma;
import br.com.argus.model.Secretario;
import br.com.argus.model.VinculoAlunoTurma;
import java.util.List;

/**
 *
 * @author santo
 */
public interface IFacade {
    

    
    //  Usuario
    public Usuario buscarLoginUsuario(String login, String senha) throws BussinesException;
    public List<Usuario> buscarTodosUsuarios(String string) throws BussinesException;
    public void inserirOuAtualizar(Usuario usuario) throws BussinesException;
    public void desabilitarUsuario(Usuario usuario) throws BussinesException;
    public void deletarUsuario (Usuario usuario) throws BussinesException;
    public void buscarUsuario (Usuario usuario) throws BussinesException;
    
    
    //  Endereco
    public void inserirOuAtualizarEndereco(Endereco endereco) throws BussinesException;
    public void desabilitarEndereco(Endereco endereco) throws BussinesException;
    public void deletarEndereco (Endereco endereco) throws BussinesException;
    public void buscarEndereco (Endereco endereco) throws BussinesException;
    public List<Endereco> buscarTodosEnderecos () throws BussinesException;
    
    
    //  Contato
    public void inserirOuAtualizarContato(Contato contato) throws BussinesException;
    public void desabilitarContato(Contato contato) throws BussinesException;
    public void deletarContato (Contato contato) throws BussinesException;
    public void buscarContato (Contato contato) throws BussinesException;
    public List<Contato> buscarTodosContatos () throws BussinesException;
    
    
    //  Aluno   
    public void inserirOuAtualizarAluno(Aluno aluno) throws BussinesException;
    public void desabilitarAluno(Aluno aluno) throws BussinesException;
    public void deletarAluno (Aluno aluno) throws BussinesException;
    public void buscarAluno (Aluno aluno) throws BussinesException;
    public List<Aluno> buscarTodosAlunos () throws BussinesException;
    
    
    //  Cooordenador
    public void inserirOuAtualizarCoordenador(Coordenador coordenador) throws BussinesException;
    public void desabilitarCoordenador(Coordenador coordenador) throws BussinesException;
    public void deletarCoordenador (Coordenador coordenador) throws BussinesException;
    public void buscarCoordenador(Coordenador coordenador) throws BussinesException;
    public List<Coordenador> buscarTodosCoordenadores () throws BussinesException;
    
    
    //  Diretor
    public void inserirOuAtualizarDiretor(Diretor diretor) throws BussinesException;
    public void desabilitarDiretor(Diretor diretor) throws BussinesException;
    public void deletarDiretor(Diretor diretor) throws BussinesException;
    public void buscarDiretor (Diretor diretor) throws BussinesException;
    public List<Diretor> buscarTodosDiretores () throws BussinesException;
    
    
    //  Disciplina
      public void inserirOuAtualizarDisciplina(Disciplina disciplina) throws BussinesException;
    public void desabilitarDisciplina(Disciplina disciplina) throws BussinesException;
    public void deletarDisciplina (Disciplina disciplina) throws BussinesException;
    public void buscarDisciplina(Disciplina disciplina) throws BussinesException;
    public List<Disciplina> buscarTodosDisciplinas () throws BussinesException;
    
    
    //  Professor
    public void inserirOuAtualizarProfessor(Professor professor) throws BussinesException;
    public void desabilitarProfessor(Professor professor) throws BussinesException;
    public void deletarProfessor(Professor professor) throws BussinesException;
    public void buscarProfessor(Professor professor) throws BussinesException;
    public List<Professor> buscarTodosProfessores () throws BussinesException;
    
    
    //  Responsalvel Financeiro
    public void inserirOuAtualizarResp_Fin(Resp_Financeiro resp_Financeiro) throws BussinesException;
    public void desabilitarResp_Fin(Resp_Financeiro resp_Financeiro) throws BussinesException;
    public void deletarResp_Fin(Resp_Financeiro resp_Financeiro) throws BussinesException;
    public void buscarResp_Fin(Resp_Financeiro resp_Financeiro) throws BussinesException;
    public List<Resp_Financeiro> buscarTodosResp_FinS() throws BussinesException;
    
    
    //  Secretario    
    public void inserirOuAtualizarSecretario(Secretario secretario) throws BussinesException;
    public void desabilitarSecretario (Secretario secretario) throws BussinesException;
    public void deletarSecretario(Secretario secretario) throws BussinesException;
    public void buscarSecretario(Secretario secretario) throws BussinesException;
    public List<Secretario> buscarTodosSecretario () throws BussinesException;
    

    //  SuperUsuario
    public void inserirOuAtualizarSuperUsuario(SuperUsuario superUsuario) throws BussinesException;
    public void desabilitarSuperUsuario(SuperUsuario superUsuario) throws BussinesException;
    public void deletarSuperUsuario(SuperUsuario superUsuario) throws BussinesException;
    public void buscarSuperUsuario(SuperUsuario superUsuario) throws BussinesException;
    public List<SuperUsuario> buscarTodosSuperUsuarioS () throws BussinesException;
    
    
    //  Turma
    public void inserirOuAtualizarTurma (Turma turma) throws BussinesException;
    public void desabilitarTurma (Turma turma) throws BussinesException;
    public void deletarCTurma (Turma turma) throws BussinesException;
    public void buscarTurma (Turma turma) throws BussinesException;
    public List<Turma> buscarTodosTurma () throws BussinesException;
    
    
    // Carne Pagamento
    
    public void inserirOuAtualizarCarnePag (Carne_Pagamento carne_Pagamento) throws BussinesException;
    public void desabilitarCarnePag  (Carne_Pagamento carne_Pagamento) throws BussinesException;
    public void deletarCarnePag  (Carne_Pagamento carne_Pagamento) throws BussinesException;
    public void buscarCarnePag  (Carne_Pagamento carne_Pagamento) throws BussinesException;
    public List<Carne_Pagamento> buscarTodosCarnePag  () throws BussinesException;
    
    // Falta
    
    public void inserirOuAtualizarFalta (Falta falta) throws BussinesException;
    public void desabilitarFalta (Falta falta) throws BussinesException;
    public void deletarFalta (Falta falta) throws BussinesException;
    public void buscarFalta (Falta falta) throws BussinesException;
    public List<Falta> buscarTodosFalta() throws BussinesException;    
    
    // Liquida Carne
    
    public void inserirOuAtualizarLiquidaCarne (LiquidaCarne liquidaCarne) throws BussinesException;
    public void desabilitarLiquidaCarne (LiquidaCarne liquidaCarne) throws BussinesException;
    public void deletarLiquidaCarne (LiquidaCarne liquidaCarne) throws BussinesException;
    public void buscarLiquidaCarne (LiquidaCarne liquidaCarne) throws BussinesException;
    public List<LiquidaCarne> buscarTodosLiquidaCarne () throws BussinesException;   
    
    // Observacao Aluno
   
    public void inserirOuAtualizarObsAluno (ObservacaoAluno observacaoAluno) throws BussinesException;
    public void desabilitarObsAluno (ObservacaoAluno observacaoAluno) throws BussinesException;
    public void deletarObsAluno(ObservacaoAluno observacaoAluno) throws BussinesException;
    public void buscarObsAluno (ObservacaoAluno observacaoAluno) throws BussinesException;
    public List<ObservacaoAluno> buscarTodosObsAluno () throws BussinesException;
    
    
    // Vinculo Aluno Turma
    
    public void inserirOuAtualizarVincAlunoTurma (VinculoAlunoTurma vinculoAlunoTurma) throws BussinesException;
    public void desabilitarVincAlunoTurma (VinculoAlunoTurma vinculoAlunoTurma) throws BussinesException;
    public void deletarVincAlunoTurma(VinculoAlunoTurma vinculoAlunoTurma) throws BussinesException;
    public void buscarVincAlunoTurma(VinculoAlunoTurma vinculoAlunoTurma) throws BussinesException;
    public List<VinculoAlunoTurma> buscarTodosVincAlunoTurma () throws BussinesException;
}
