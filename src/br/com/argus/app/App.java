/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.argus.app;
import br.com.argus.enuns.ResetSenha;
import br.com.argus.enuns.TipoCargo;
import br.com.argus.enuns.TipoEstadoUF;
import br.com.argus.exceptions.BussinesException;
import br.com.argus.facade.Facade;
import br.com.argus.facade.IFacade;
import br.com.argus.model.Aluno;
import br.com.argus.model.Contato;
import br.com.argus.model.Coordenador;
import br.com.argus.model.Diretor;
import br.com.argus.model.Endereco;
import br.com.argus.model.Resp_Financeiro;
import br.com.argus.model.Secretario;
import br.com.argus.model.SuperUsuario;
import br.com.argus.model.Usuario;
import br.com.argus.util.Backup;
import java.io.IOException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.event.EventHandler;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

/**
 *
 * @author santo
 */
public class App extends Application {
    
    public static final String LOGIN = "/br/com/argus/view/Login.fxml";
    public static final String HOME = "/br/com/argus/view/Dashboard.fxml";
    public static final String RESET_SENHA = "/br/com/argus/view/Resetar_Senha.fxml" ;
    public static final String ALTERA_SENHA = "/br/com/argus/view/Alterar_senha.fxml" ;
    public static final String CADASTRO_ALUNO ="/br/com/argus/view/Cadastrar_Aluno.fxml" ;
    public static final String CADASTRO_DISCIPLINA = "/br/com/argus/view/Cadastrar_Disciplina.fxml" ;
    public static final String CADASTRO_PROFESSOR = "/br/com/argus/view/Cadastrar_Professor.fxml" ;
    public static final String CADASTRO_TURMA = "/br/com/argus/view/Cadastrar_Turma.fxml" ;
    public static final String CADASTRO_USUARIO = "/br/com/argus/view/Cadastrar_Usuario.fxml" ;
    public static final String VER_ALUNOS = "/br/com/argus/view/Ver_Alunos.fxml" ;
    public static final String VER_DISCIPLINAS ="/br/com/argus/view/Ver_Disciplinas.fxml" ;
    public static final String VER_PROFESSORES = "/br/com/argus/view/Ver_Professores.fxml" ;
    public static final String VER_TURMA = "/br/com/argus/view/Ver_Turma.fxml" ;
    public static final String VER_USUARIO = "/br/com/argus/view/Ver_Usuarios.fxml" ;
    
    public static  Stage STAGE = new Stage();
    public static  Stage STAGE_PRINCIPAL = new Stage();
    
    public static void main(String[] args) throws BussinesException{
        
       IFacade facade = Facade.getInstance();
      
//        Aluno aluno = new Aluno();
//        Contato contato = new Contato();
//        Endereco endereco = new Endereco();
//        Resp_Financeiro financeiro = new Resp_Financeiro();
//        contato.setEmail("eamail");
//        contato.setTelefone("09");
//        contato.setCelular("89");
//        
//        endereco.setBairro("bairoo");
//        endereco.setCep("00");
//        endereco.setCidade("Cidade");
//        endereco.setComplemento("Casa");
//        endereco.setLogradouro("logra");
//        endereco.setNumero("12");
//        endereco.setTipoEstadoUF(TipoEstadoUF.PERNAMBUCO);
//        
//        financeiro.setCpf("0008");
//        financeiro.setNome("Bergao");
//        
//        aluno.setContato(contato);
//        aluno.setEndereco(endereco);
//        aluno.setResponsavel_financeiro(financeiro);
//        aluno.setNaturalidade("Daqui");
//        aluno.setPai("BergPai");
//        aluno.setMae("BergMae");
//        aluno.setNome("Berg");
//
//        
//        facade.inserirOuAtualizarAluno(aluno);
//       
//        Secretario secretario = new Secretario();
//        secretario.setLogin("secretario");
//        secretario.setSenha("secretario");
//        secretario.setNome("Secretaria");
//        secretario.setCpf("000012321");
//        secretario.setTipoCargo(TipoCargo.SECRETARIA);
//        secretario.setSolicitar_reset(ResetSenha.NAO);
//        facade.inserirOuAtualizar(secretario);
//        
//        SuperUsuario sperU = new SuperUsuario();
//        sperU.setLogin("entidade");
//        sperU.setSenha("entidade");
//        sperU.setNome("ENTIDADE");
//        sperU.setCpf("147823");
//        sperU.setSolicitar_reset(ResetSenha.NAO);
//        sperU.setTipoCargo(TipoCargo.SUPER_USUARIO);
//        facade.inserirOuAtualizarEntidade(sperU);
//        
//        Diretor diretor = new Diretor();
//        diretor.setLogin("diretor");
//        diretor.setSenha("diretor");
//        diretor.setNome("Diretoria");
//        diretor.setCpf("0000121");
//        diretor.setSolicitar_reset(ResetSenha.NAO);
//        diretor.setTipoCargo(TipoCargo.DIRETORIA);
//        facade.inserirOuAtualizar(diretor);
//       
//        Coordenador superUsuario = new  Coordenador();
//        superUsuario.setLogin("coordenador");
//        superUsuario.setSenha("coordenador");
//        superUsuario.setNome("Coordenador");
//        superUsuario.setCpf("0002351");
//        superUsuario.setSolicitar_reset(ResetSenha.NAO);
//        superUsuario.setTipoCargo(TipoCargo.COORDENAÇÃO_PEDAGOGA);
//        facade.inserirOuAtualizar(superUsuario);
       
        launch(args);
       
    }
    
       @Override
    public void start(Stage primaryStage) throws Exception {
        
      STAGE.initOwner(STAGE_PRINCIPAL);
      STAGE.initModality(Modality.WINDOW_MODAL);
      
      stageLogin().setResizable(false);
      stageLogin().setTitle("Login Argus Acadêmico");
//      stageLogin().initStyle(StageStyle.UNDECORATED);
      stageLogin().show();
      
    }
    
    
	public static Stage stagePrincipal() throws IOException {
		STAGE_PRINCIPAL.setScene(new Scene(
				FXMLLoader.load(App.class.getResource (HOME))));
		STAGE.setOnCloseRequest(new EventHandler<WindowEvent>() {
			public void handle(WindowEvent event) {
			    System.exit(0);}});
		return  STAGE_PRINCIPAL;
	}


    public static  Stage stageLogin() throws IOException {
        STAGE.setScene(new Scene(
                FXMLLoader.load(App.class.getResource(LOGIN))));
        STAGE.setOnCloseRequest(new EventHandler<WindowEvent>() {
            public void handle(WindowEvent event) { STAGE.close(); }});
        return STAGE;
    }


	public static Stage genericaStage(String caminho) throws IOException {
		STAGE.setScene(new Scene(
				FXMLLoader.load(App.class.getResource (caminho))));
		STAGE.setOnCloseRequest(new EventHandler<WindowEvent>() {
			public void handle(WindowEvent event) { STAGE.close(); }});
		return STAGE;
	}
        
        public static Stage genericaStage01(String caminho) throws IOException {
		STAGE.setScene(new Scene(
				FXMLLoader.load(App.class.getResource (caminho))));
		STAGE.setOnCloseRequest(new EventHandler<WindowEvent>() {
			public void handle(WindowEvent event) { STAGE.close(); }});
		return STAGE;
	}
        
    
    public void stop() throws Exception{
//        super.stop();
//        
//        Backup.bakcup(System.getProperty("user.home")+"/Backup Projeto_PBD");
//        System.exit(0);
        
    }
  
    /**
     * @param args the command line arguments
     */

    
}
