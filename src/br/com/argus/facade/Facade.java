/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.argus.facade;

import br.com.argus.business.AlunoBusiness;
import br.com.argus.business.ContatoBusiness;
import br.com.argus.business.CoordenadorBusinees;
import br.com.argus.business.DiretorBusiness;
import br.com.argus.business.DisciplinaBusiness;
import br.com.argus.business.EnderecoBusiness;
import br.com.argus.business.IAlunoBusiness;
import br.com.argus.business.IContatoBusiness;
import br.com.argus.business.ICoordenadorBusiness;
import br.com.argus.business.IDiretorBusiness;
import br.com.argus.business.IDisciplinaBusiness;
import br.com.argus.business.IEnderecoBusiness;
import br.com.argus.business.IProfessorBusiness;
import br.com.argus.business.IRes_FinBusiness;
import br.com.argus.business.ISecretarioBusiness;
import br.com.argus.business.ISuperUsuarioBusiness;
import br.com.argus.business.ITurmaBisiness;
import br.com.argus.business.IUsuarioBusiness;
import br.com.argus.business.ProfessorBusiness;
import br.com.argus.business.Res_FinBusiness;
import br.com.argus.business.SecretarioBusiness;
import br.com.argus.business.SuperUsuarioBusiness;
import br.com.argus.business.TurmaBisiness;
import br.com.argus.business.UsuarioBusiness;
import br.com.argus.exceptions.BussinesException;
import br.com.argus.model.Aluno;
import br.com.argus.model.Contato;
import br.com.argus.model.Endereco;
import br.com.argus.model.Usuario;
import br.com.argus.model.Coordenador;
import br.com.argus.model.Diretor;
import br.com.argus.model.Disciplina;
import br.com.argus.model.Professor;
import br.com.argus.model.Resp_Financeiro;
import br.com.argus.model.SuperUsuario;
import br.com.argus.model.Turma;
import br.com.argus.model.Secretario;
import java.util.List;

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
    private ICoordenadorBusiness coordenadorBusiness;
    private IDiretorBusiness diretorBusiness;
    private IDisciplinaBusiness disciplinaBusiness;
    private IProfessorBusiness professorBusiness;
    private IRes_FinBusiness res_FinBusiness;
    private ISuperUsuarioBusiness superUsuarioBusiness;
    private ITurmaBisiness turmaBisiness;
    private ISecretarioBusiness secretarioBusiness;
    
    private Facade(){
        usuarioBusiness = new UsuarioBusiness();
        enderecoBusiness = new EnderecoBusiness();
        contatoBusiness = new ContatoBusiness();
        alunoBusiness = new AlunoBusiness();
        coordenadorBusiness = new CoordenadorBusinees();
        diretorBusiness = new DiretorBusiness();
        disciplinaBusiness = new DisciplinaBusiness();
        professorBusiness = new ProfessorBusiness();
        res_FinBusiness = new Res_FinBusiness();
        superUsuarioBusiness = new SuperUsuarioBusiness();
        turmaBisiness = new TurmaBisiness();
        secretarioBusiness = new SecretarioBusiness();
    }



    //  Usuario
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
    
    
    //  Endereco
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
    
    
    //  Contato
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

    
    //  Aluno
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
    
    
    //  Coordenador
    @Override
    public void inserirOuAtualizarCoordenador(Coordenador coordenador) throws BussinesException {
        coordenadorBusiness.criarOuAtualizar(coordenador);
    }
    @Override
    public void desabilitarCoordenador(Coordenador coordenador) throws BussinesException {
        coordenadorBusiness.desabilitar(coordenador);
    }
    @Override
    public void deletarCoordenador(Coordenador coordenador) throws BussinesException {
       coordenadorBusiness.deletar(coordenador);
    }
    @Override
    public void buscarCoordenador(Coordenador coordenador) throws BussinesException {
        coordenadorBusiness.buscar(Coordenador.class, coordenador.getId());
    }
    @Override
    public List<Coordenador> buscarTodosCoordenadores(Coordenador coordenador) throws BussinesException {
       return coordenadorBusiness.buscarTodos();
    }

    
    //  Diretor
    @Override
    public void inserirOuAtualizarDiretor(Diretor diretor) throws BussinesException {
        diretorBusiness.criarOuAtualizar(diretor);
    }
    @Override
    public void desabilitarDiretor(Diretor diretor) throws BussinesException {
        diretorBusiness.desabilitar(diretor);
    }
    @Override
    public void deletarDiretor(Diretor diretor) throws BussinesException {
        diretorBusiness.deletar(diretor);
    }
    @Override
    public void buscarDiretor(Diretor diretor) throws BussinesException {
        diretorBusiness.buscar(Diretor.class, diretor.getId());
    }
    @Override
    public List<Diretor> buscarTodosDiretores(Diretor diretor) throws BussinesException {
        return diretorBusiness.buscarTodos();
    }

    
    //  Disciplina
    @Override
    public void inserirOuAtualizarDisciplina(Disciplina disciplina) throws BussinesException {
        disciplinaBusiness.criarOuAtualizar(disciplina);
    }
    @Override
    public void desabilitarDisciplina(Disciplina disciplina) throws BussinesException {
        disciplinaBusiness.desabilitar(disciplina);
    }
    @Override
    public void deletarDisciplina(Disciplina disciplina) throws BussinesException {
        disciplinaBusiness.deletar(disciplina);
    }
    @Override
    public void buscarDisciplina(Disciplina disciplina) throws BussinesException {
        disciplinaBusiness.buscar(Disciplina.class, disciplina.getId());
    }
    @Override
    public List<Disciplina> buscarTodosDisciplinas(Disciplina disciplina) throws BussinesException {
        return disciplinaBusiness.buscarTodos();
    }

    
    //  Professor
    @Override
    public void inserirOuAtualizarProfessor(Professor professor) throws BussinesException {
        professorBusiness.criarOuAtualizar(professor);
    }
    @Override
    public void desabilitarProfessor(Professor professor) throws BussinesException {
        professorBusiness.desabilitar(professor);
    }
    @Override
    public void deletarProfessor(Professor professor) throws BussinesException {
        professorBusiness.deletar(professor);
    }
    @Override
    public void buscarProfessor(Professor professor) throws BussinesException {
        professorBusiness.buscar(Professor.class, professor.getId());
    }
    @Override
    public List<Professor> buscarTodosProfessores(Professor professor) throws BussinesException {
        return professorBusiness.buscarTodos();
    }
    
    
    //  Responsavel Financeiro
    @Override
    public void inserirOuAtualizarResp_Fin(Resp_Financeiro resp_Financeiro) throws BussinesException {
       res_FinBusiness.criarOuAtualizar(resp_Financeiro);
    }
    @Override
    public void desabilitarResp_Fin(Resp_Financeiro resp_Financeiro) throws BussinesException {
        res_FinBusiness.desabilitar(resp_Financeiro);
    }
    @Override
    public void deletarResp_Fin(Resp_Financeiro resp_Financeiro) throws BussinesException {
        res_FinBusiness.deletar(resp_Financeiro);
    }
    @Override
    public void buscarResp_Fin(Resp_Financeiro resp_Financeiro) throws BussinesException {
        res_FinBusiness.buscar(Resp_Financeiro.class, resp_Financeiro.getId());
    }
    @Override
    public List<Resp_Financeiro> buscarTodosResp_FinS(Resp_Financeiro resp_Financeiro) throws BussinesException {
        return res_FinBusiness.buscarTodos();
    }

    
    //  Secretario
    @Override
    public void inserirOuAtualizarSecretario(Secretario secretario) throws BussinesException {
        secretarioBusiness.criarOuAtualizar(secretario);
    }
    @Override
    public void desabilitarSecretario(Secretario secretario) throws BussinesException {
        secretarioBusiness.desabilitar(secretario);
    }
    @Override
    public void deletarSecretario(Secretario secretario) throws BussinesException {
            secretarioBusiness.deletar(secretario);
    }
    @Override
    public void buscarSecretario(Secretario secretario) throws BussinesException {
        secretarioBusiness.buscar(Secretario.class, secretario.getId());
    }
    @Override
    public List<Secretario> buscarTodosSecretario(Secretario secretario) throws BussinesException {
        return secretarioBusiness.buscarTodos();
    }

    
    //  SuperUsuario
    @Override
    public void inserirOuAtualizarSuperUsuario(SuperUsuario superUsuario) throws BussinesException {
        superUsuarioBusiness.criarOuAtualizar(superUsuario);
    }
    @Override
    public void desabilitarSuperUsuario(SuperUsuario superUsuario) throws BussinesException {
        superUsuarioBusiness.desabilitar(superUsuario);
    }
    @Override
    public void deletarSuperUsuario(SuperUsuario superUsuario) throws BussinesException {
      superUsuarioBusiness.deletar(superUsuario);
    }
    @Override
    public void buscarSuperUsuario(SuperUsuario superUsuario) throws BussinesException {
        superUsuarioBusiness.buscar(SuperUsuario.class, superUsuario.getId());
    }

    @Override
    public List<SuperUsuario> buscarTodosSuperUsuarioS(SuperUsuario superUsuario) throws BussinesException {
        return superUsuarioBusiness.buscarTodos();
    }

    
    //  Turma
    @Override
    public void inserirOuAtualizarTurma(Turma turma) throws BussinesException {
        turmaBisiness.criarOuAtualizar(turma);
    }
    @Override
    public void desabilitarTurma(Turma turma) throws BussinesException {
        turmaBisiness.desabilitar(turma);
    }
    @Override
    public void deletarCTurma(Turma turma) throws BussinesException {
        turmaBisiness.deletar(turma);
    }
    @Override
    public void buscarTurma(Turma turma) throws BussinesException {
        turmaBisiness.buscar(Turma.class, turma.getId());
    }

    @Override
    public List<Turma> buscarTodosTurma(Turma turma) throws BussinesException {
        return turmaBisiness.buscarTodos();
    }
    
    

    
    
    
}
