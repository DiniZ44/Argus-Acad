/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.argus.facade;

import br.com.argus.business.AlunoBusiness;
import br.com.argus.business.CarnePagamentoBusiness;
import br.com.argus.business.ContatoBusiness;
import br.com.argus.business.CoordenadorBusinees;
import br.com.argus.business.DiretorBusiness;
import br.com.argus.business.DisciplinaBusiness;
import br.com.argus.business.DisciplinaTurmaBussiness;
import br.com.argus.business.EnderecoBusiness;
import br.com.argus.business.FaltaBusiness;
import br.com.argus.business.IAlunoBusiness;
import br.com.argus.business.ICarnePagamentoBusiness;
import br.com.argus.business.IContatoBusiness;
import br.com.argus.business.ICoordenadorBusiness;
import br.com.argus.business.IDiretorBusiness;
import br.com.argus.business.IDisciplinaBusiness;
import br.com.argus.business.IDisciplinaTurmaBussiness;
import br.com.argus.business.IEnderecoBusiness;
import br.com.argus.business.IFaltaBusiness;
import br.com.argus.business.ILiquidaCarneBusiness;
import br.com.argus.business.ILogBusiness;
import br.com.argus.business.IObservacaoAlunoBusiness;
import br.com.argus.business.IProfessorBusiness;
import br.com.argus.business.IRes_FinBusiness;
import br.com.argus.business.ISecretarioBusiness;
import br.com.argus.business.ISuperUsuarioBusiness;
import br.com.argus.business.ITurmaBisiness;
import br.com.argus.business.IUsuarioBusiness;
import br.com.argus.business.IVinculoAlunoTurmaBusiness;
import br.com.argus.business.LiquidaCarneBusiness;
import br.com.argus.business.LogBusiness;
import br.com.argus.business.ObservacaoAlunoBusiness;
import br.com.argus.business.ProfessorBusiness;
import br.com.argus.business.Res_FinBusiness;
import br.com.argus.business.SecretarioBusiness;
import br.com.argus.business.SuperUsuarioBusiness;
import br.com.argus.business.TurmaBisiness;
import br.com.argus.business.UsuarioBusiness;
import br.com.argus.business.VinculoAlunoTurmaBusiness;
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
import br.com.argus.model.DisciplinaTurma;
import br.com.argus.model.Falta;
import br.com.argus.model.LiquidaCarne;
import br.com.argus.model.Log;
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
    private ICarnePagamentoBusiness carnePagamentoBusiness;
    private IFaltaBusiness faltaBusiness;
    private ILiquidaCarneBusiness liquidaCarneBusiness;
    private IObservacaoAlunoBusiness observacaoAlunoBusiness;
    private IVinculoAlunoTurmaBusiness vinculoAlunoTurmaBusiness;
    private IDisciplinaTurmaBussiness disciplinaTurmaBussiness;
    private ILogBusiness logBusiness;
    
    
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
        carnePagamentoBusiness = new CarnePagamentoBusiness();
        faltaBusiness = new FaltaBusiness();
        liquidaCarneBusiness = new LiquidaCarneBusiness();
        observacaoAlunoBusiness = new ObservacaoAlunoBusiness();
        vinculoAlunoTurmaBusiness = new VinculoAlunoTurmaBusiness();
        disciplinaTurmaBussiness = new DisciplinaTurmaBussiness();
        logBusiness = new LogBusiness();
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
    @Override
    public Usuario buscarTipo(String tipocargo) throws BussinesException {
        return usuarioBusiness.buscarTipo(tipocargo);
    }
    @Override
    public List<Usuario> buscarTodosUsers() throws BussinesException {
        return usuarioBusiness.buscarTodos();
    }
        @Override
    public Usuario buscarCPF(String cpf) throws BussinesException {
        return usuarioBusiness.buscarCPF(cpf);
    }
    
        @Override
    public Usuario buscaLogin(String login) throws BussinesException {
        return usuarioBusiness.buscarLogin(login);
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
    public List<Endereco> buscarTodosEnderecos() throws BussinesException {
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
    public List<Contato> buscarTodosContatos() throws BussinesException {
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
    public List<Aluno> buscarTodosAlunos() throws Exception {
        return alunoBusiness.buscarALL();
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
    public List<Coordenador> buscarTodosCoordenadores() throws BussinesException {
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
    public List<Diretor> buscarTodosDiretores() throws BussinesException {
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
    public List<Disciplina> buscarTodosDisciplinas() throws BussinesException {
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
    public List<Professor> buscarTodosProfessores() throws BussinesException {
        return professorBusiness.buscarTodos();
    }
        @Override
    public Professor buscarCPF_Professor(String cpf) throws BussinesException {
        return professorBusiness.buscarCPF(cpf);
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
    public List<Resp_Financeiro> buscarTodosResp_FinS() throws BussinesException {
        return res_FinBusiness.buscarTodos();
    }
    @Override
    public Resp_Financeiro buscarCPF_Responsavel(String cpf) throws DAOException {
        return res_FinBusiness.buscarCPF(cpf);
    }

    /**
     *
     * @param pesquisa
     * @return
     * @throws DAOException
     * @throws BussinesException
     */
    @Override
       public Resp_Financeiro buscarRep (String pesquisa) throws  BussinesException {
            return res_FinBusiness.buscarRep(pesquisa);
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
    public List<Secretario> buscarTodosSecretario() throws BussinesException {
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
    public List<SuperUsuario> buscarTodosSuperUsuarioS() throws BussinesException {
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
    public List<Turma> buscarTodosTurma() throws BussinesException {
        return turmaBisiness.buscarTodos();
    }
    
    //  Carne Pagamento
    @Override
    public void inserirOuAtualizarCarnePag(Carne_Pagamento carne_Pagamento) throws BussinesException {
        carnePagamentoBusiness.criarOuAtualizar(carne_Pagamento);
    }
    @Override
    public void desabilitarCarnePag(Carne_Pagamento carne_Pagamento) throws BussinesException {
         carnePagamentoBusiness.desabilitar(carne_Pagamento);
    }
    @Override
    public void deletarCarnePag(Carne_Pagamento carne_Pagamento) throws BussinesException {
        carnePagamentoBusiness.deletar(carne_Pagamento);
    }
    @Override
    public void buscarCarnePag(Carne_Pagamento carne_Pagamento) throws BussinesException {
         carnePagamentoBusiness.buscar(Carne_Pagamento.class, carne_Pagamento.getId());
    }
    @Override
    public List<Carne_Pagamento> buscarTodosCarnePag() throws BussinesException {
        return  carnePagamentoBusiness.buscarTodos();
    }
    
    
    //  Falta
    @Override
    public void inserirOuAtualizarFalta(Falta falta) throws BussinesException {
        faltaBusiness.criarOuAtualizar(falta);
    }
    @Override
    public void desabilitarFalta(Falta falta) throws BussinesException {
        faltaBusiness.desabilitar(falta);
    }
    @Override
    public void deletarFalta(Falta falta) throws BussinesException {
        faltaBusiness.deletar(falta);
    }
    @Override
    public void buscarFalta(Falta falta) throws BussinesException {
      faltaBusiness.buscar(Falta.class, falta.getId());
    }
    @Override
    public List<Falta> buscarTodosFalta() throws BussinesException {
       return faltaBusiness.buscarTodos();
    }

    
    //  Liquida Carne
    @Override
    public void inserirOuAtualizarLiquidaCarne(LiquidaCarne liquidaCarne) throws BussinesException {
        liquidaCarneBusiness.criarOuAtualizar(liquidaCarne);
    }
    @Override
    public void desabilitarLiquidaCarne(LiquidaCarne liquidaCarne) throws BussinesException {
        liquidaCarneBusiness.desabilitar(liquidaCarne);
    }
    @Override
    public void deletarLiquidaCarne(LiquidaCarne liquidaCarne) throws BussinesException {
       liquidaCarneBusiness.deletar(liquidaCarne);
    }
    @Override
    public void buscarLiquidaCarne(LiquidaCarne liquidaCarne) throws BussinesException {
        liquidaCarneBusiness.buscar(LiquidaCarne.class,liquidaCarne.getId());
    }
    @Override
    public List<LiquidaCarne> buscarTodosLiquidaCarne() throws BussinesException {
        return liquidaCarneBusiness.buscarTodos();
    }

    
    //  Observacao Aluno
    @Override
    public void inserirOuAtualizarObsAluno(ObservacaoAluno observacaoAluno) throws BussinesException {
       observacaoAlunoBusiness.criarOuAtualizar(observacaoAluno);
    }
    @Override
    public void desabilitarObsAluno(ObservacaoAluno observacaoAluno) throws BussinesException {
        observacaoAlunoBusiness.desabilitar(observacaoAluno);
    }
    @Override
    public void deletarObsAluno(ObservacaoAluno observacaoAluno) throws BussinesException {
       observacaoAlunoBusiness.deletar(observacaoAluno);
    }
    @Override
    public void buscarObsAluno(ObservacaoAluno observacaoAluno) throws BussinesException {
      observacaoAlunoBusiness.buscar(ObservacaoAluno.class, observacaoAluno.getId());
    }
    @Override
    public List<ObservacaoAluno> buscarTodosObsAluno() throws BussinesException {
      return observacaoAlunoBusiness.buscarTodos();
    }

    
    
    // Vinculo Aluno turma
    @Override
    public void inserirOuAtualizarVincAlunoTurma(VinculoAlunoTurma vinculoAlunoTurma) throws BussinesException {
        vinculoAlunoTurmaBusiness.criarOuAtualizar(vinculoAlunoTurma);
    }
    @Override
    public void desabilitarVincAlunoTurma(VinculoAlunoTurma vinculoAlunoTurma) throws BussinesException {
        vinculoAlunoTurmaBusiness.desabilitar(vinculoAlunoTurma);
    }
    @Override
    public void deletarVincAlunoTurma(VinculoAlunoTurma vinculoAlunoTurma) throws BussinesException {
        vinculoAlunoTurmaBusiness.deletar(vinculoAlunoTurma);
    }
    @Override
    public void buscarVincAlunoTurma(VinculoAlunoTurma vinculoAlunoTurma) throws BussinesException {
        vinculoAlunoTurmaBusiness.buscar(VinculoAlunoTurma.class, vinculoAlunoTurma.getId());
    }
    @Override
    public List<VinculoAlunoTurma> buscarTodosVincAlunoTurma() throws BussinesException {
        return vinculoAlunoTurmaBusiness.buscarTodos();
    }
    
    // Disciplina Turma Business
    @Override
    public void inserirOuAtualizarDisciplinaTurma(DisciplinaTurma disciplinaTurma) throws BussinesException {
        disciplinaTurmaBussiness.criarOuAtualizar(disciplinaTurma);
    }

    @Override
    public void desabilitarDisciplinaTurma(DisciplinaTurma disciplinaTurma) throws BussinesException {
       disciplinaTurmaBussiness.desabilitar(disciplinaTurma);
    }

    @Override
    public void deletarDisciplinaTurma(DisciplinaTurma disciplinaTurma) throws BussinesException {
        disciplinaTurmaBussiness.deletar(disciplinaTurma);
    }

    @Override
    public void buscarDisciplinaTurma(DisciplinaTurma disciplinaTurma) throws BussinesException {
        disciplinaTurmaBussiness.buscar(DisciplinaTurma.class, disciplinaTurma.getId());
    }

    @Override
    public List<DisciplinaTurma> buscarTodosDisciplinaTurma() throws BussinesException {
        return disciplinaTurmaBussiness.buscarTodos();
    }

    
    //Log
    
    
    @Override
    public List<Log> buscarTodosLogs() throws BussinesException {
        return logBusiness.buscarTodos();
    }









    

    
}
