/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.argus.facade;

import br.com.argus.exceptions.BussinesException;
import br.com.argus.exceptions.DAOException;
import br.com.argus.model.Aluno;
import br.com.argus.model.Contato;
import br.com.argus.model.Endereco;
import br.com.argus.model.Usuario;
import java.util.List;

/**
 *
 * @author santo
 */
public interface IFacade {
    
    // Usuario
    public Usuario buscarLoginUsuario(String login, String senha) throws BussinesException;
    public List<Usuario> buscarTodosUsuarios(String string) throws BussinesException;
    public void inserirOuAtualizar(Usuario usuario) throws BussinesException;
    public void desabilitarUsuario(Usuario usuario) throws BussinesException;
    public void deletarUsuario (Usuario usuario) throws BussinesException;
    public void buscarUsuario (Usuario usuario) throws BussinesException;
    
    //Endereco
    public void inserirOuAtualizarEndereco(Endereco endereco) throws BussinesException;
    public void desabilitarEndereco(Endereco endereco) throws BussinesException;
    public void deletarEndereco (Endereco endereco) throws BussinesException;
    public void buscarEndereco (Endereco endereco) throws BussinesException;
    public List<Endereco> buscarTodosEnderecos (Endereco endereco) throws BussinesException;
    
    //Contato
    public void inserirOuAtualizarContato(Contato contato) throws BussinesException;
    public void desabilitarContato(Contato contato) throws BussinesException;
    public void deletarContato (Contato contato) throws BussinesException;
    public void buscarContato (Contato contato) throws BussinesException;
    public List<Contato> buscarTodosContatos (Contato contato) throws BussinesException;
    
    //Aluno
    public void inserirOuAtualizarAluno(Aluno aluno) throws BussinesException;
    public void desabilitarAluno(Aluno aluno) throws BussinesException;
    public void deletarAluno (Aluno aluno) throws BussinesException;
    public void buscarAluno (Aluno aluno) throws BussinesException;
    public List<Aluno> buscarTodosAlunos (Aluno aluno) throws BussinesException;
}
