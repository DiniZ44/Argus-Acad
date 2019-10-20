/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.argus.app;
import br.com.argus.enuns.TipoCargo;
import br.com.argus.exceptions.BussinesException;
import br.com.argus.facade.Facade;
import br.com.argus.facade.IFacade;
import br.com.argus.model.SuperUsuario;
import br.com.argus.model.Usuario;
import java.io.IOException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.event.EventHandler;
import javafx.stage.WindowEvent;

/**
 *
 * @author santo
 */
public class App extends Application {
    
//    private static Scene sceneLogin, sceneHome;
//    private static Stage stage;
//    public final static String Tela_Login = "login";
//    public final static String Tela_Home = "home";
    
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
       
//        SuperUsuario superUsuario = new SuperUsuario();
//        
//        superUsuario.setLogin("admin");
//        superUsuario.setSenha("admin");
//        superUsuario.setNome("Adminstrador");
//        superUsuario.setCpf("00000000001");
//        superUsuario.setTipoCargo(TipoCargo.SUPER_USUARIO);
//        facade.inserirOuAtualizar(superUsuario);
       
        launch(args);
       
    }
    
       @Override
    public void start(Stage primaryStage) throws Exception {
        
      STAGE.initOwner(STAGE_PRINCIPAL);
      STAGE.initModality(Modality.WINDOW_MODAL);
      
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
    
    
    
    
    
    
    
    
    
    
    
    
    
//    @Override
//    public void start(Stage primayStage){
//        try {
//            
//           Pane telaLogin = FXMLLoader.load(getClass().getResource("/br/com/argus/view/Login.fxml"));
//           
//           sceneLogin = new Scene(telaLogin);
//        
//            primayStage.setScene(sceneLogin);
//            primayStage.centerOnScreen();
//            primayStage.show();
//            setStage(stage);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }    
//    }

 
    
//    public void startA(Stage primayStage){
//        try {
//            
//           Pane telaHome = FXMLLoader.load(getClass().getResource("/br/com/argus/view/Dashboard.fxml"));
//           
//           sceneHome = new Scene(telaHome);
//        
//            primayStage.setScene(sceneHome);
//            primayStage.centerOnScreen();
//            primayStage.show();
//            setStage(stage);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }    
//    }
    
//    public static void setStage(Stage Sstage){
//         stage = Sstage;
//    }
//    
//    public static Stage getStage (){
//        return stage;
//    }
//    
//    public static void MudarTela (String tela){
//        if(tela.equals("home")){
//            stage.setScene(sceneHome);
//            stage.setResizable(false);
//        }else{
//            stage.setScene(sceneLogin);
//            stage.setResizable(false);
//          
//        }
//    }
  
    /**
     * @param args the command line arguments
     */

    
}
