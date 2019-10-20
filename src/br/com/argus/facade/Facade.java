/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.argus.facade;

import br.com.argus.business.AlunoBusiness;
import br.com.argus.business.ContatoBusiness;
import br.com.argus.business.EnderecoBusiness;
import br.com.argus.business.IAlunoBusiness;
import br.com.argus.business.IContatoBusiness;
import br.com.argus.business.IEnderecoBusiness;
import br.com.argus.business.IUsuarioBusiness;
import br.com.argus.business.UsuarioBusiness;
import br.com.argus.exceptions.BussinesException;
import br.com.argus.exceptions.DAOException;
import br.com.argus.model.Aluno;
import br.com.argus.model.Contato;
import br.com.argus.model.Endereco;
import br.com.argus.model.Usuario;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author santo
 */
public class Facade implements IFacade{
   
    private static Facade instance;
    
    public static Facade getInstance(){
        
        if(instance == null){
            instance = new Facade();
        }return instance;
    }
    
    
    private IUsuarioBusiness usuarioBusiness;
    private IEnderecoBusiness enderecoBusiness;
    private IContatoBusiness contatoBusiness;
    private IAlunoBusiness alunoBusiness;
    
    private Facade(){
        usuarioBusiness = new UsuarioBusiness();
        enderecoBusiness = new EnderecoBusiness();
        contatoBusiness = new ContatoBusiness();
        alunoBusiness = new AlunoBusiness();
    }



    //Usuario
    @Override
    public Usuario buscarLoginUsuario(String login, String senha) throws BussinesException {
        return usuarioBusiness.buscarLoginUsuario(login, senha);
    }
    @Override
    public List<Usuario> buscarTodosUsuarios(String string) throws BussinesException {
        return usuarioBusiness.buscarTodos(string);
    }
    @Override
    public void inserirOuAtualizar(Usuario usuario) throws BussinesException {
        usuarioBusiness.criarOuAtualizar(usuario);
    }
    @Override
    public void desabilitarUsuario(Usuario usuario) throws BussinesException {
         usuarioBusiness.desabilitar(usuario);
    }
    @Override
    public void deletarUsuario(Usuario usuario) throws BussinesException {
         usuarioBusiness.deletar(usuario);
    }
    @Override
    public void buscarUsuario(Usuario usuario) throws BussinesException {
         usuarioBusiness.buscar(Usuario.class, usuario.getId());
    }
    
    
    // Endereco
    @Override
    public void inserirOuAtualizarEndereco(Endereco endereco) throws BussinesException {
        enderecoBusiness.criarOuAtualizar(endereco);
    }
    @Override
    public void desabilitarEndereco(Endereco endereco) throws BussinesException {
        enderecoBusiness.desabilitar(endereco);
    }
    @Override
    public void deletarEndereco(Endereco endereco) throws BussinesException {
        enderecoBusiness.deletar(endereco);
    }
    @Override
    public void buscarEndereco(Endereco endereco) throws BussinesException {
        enderecoBusiness.buscar(Endereco.class, endereco.getId());
    } 
    @Override
    public List<Endereco> buscarTodosEnderecos(Endereco endereco) throws BussinesException {
            return enderecoBusiness.buscarTodos();
    }
    
    
    // Contato
    @Override
    public void inserirOuAtualizarContato(Contato contato) throws BussinesException {
        contatoBusiness.criarOuAtualizar(contato);
    }
    @Override
    public void desabilitarContato(Contato contato) throws BussinesException {
        contatoBusiness.desabilitar(contato);
    }
    @Override
    public void deletarContato(Contato contato) throws BussinesException {
        contatoBusiness.deletar(contato);
    }
    @Override
    public void buscarContato(Contato contato) throws BussinesException {
        contatoBusiness.buscar(Contato.class, contato.getId());
    }
    @Override
    public List<Contato> buscarTodosContatos(Contato contato) throws BussinesException {
        return contatoBusiness.buscarTodos();
    }

    
    //Aluno
    @Override
    public void inserirOuAtualizarAluno(Aluno aluno) throws BussinesException {
        alunoBusiness.criarOuAtualizar(aluno);
    }
    @Override
    public void desabilitarAluno(Aluno aluno) throws BussinesException {
        alunoBusiness.desabilitar(aluno);
    }
    @Override
    public void deletarAluno(Aluno aluno) throws BussinesException {
        alunoBusiness.deletar(aluno);
    }
    @Override
    public void buscarAluno(Aluno aluno) throws BussinesException {
        alunoBusiness.buscar(Aluno.class, aluno.getId());
    }
    @Override
    public List<Aluno> buscarTodosAlunos(Aluno aluno) throws BussinesException {
        return alunoBusiness.buscarTodos();
    }
    
    
    
}
