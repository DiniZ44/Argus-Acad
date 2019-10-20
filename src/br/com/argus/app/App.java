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
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;


/**
 *
 * @author santo
 */
public class App extends Application {
    
    private static Scene sceneLogin, sceneHome;
    private static Stage stage;
//    public final static String Tela_Login = "login";
//    public final static String Tela_Home = "home";
    
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
    public void start(Stage primayStage){
        try {
            
           Pane telaLogin = FXMLLoader.load(getClass().getResource("/br/com/argus/view/Login.fxml"));
           
           sceneLogin = new Scene(telaLogin);
        
            primayStage.setScene(sceneLogin);
            primayStage.centerOnScreen();
            primayStage.show();
            setStage(stage);
        } catch (Exception e) {
            e.printStackTrace();
        }    
    }
    
    public void startA(Stage primayStage){
        try {
            
           Pane telaHome = FXMLLoader.load(getClass().getResource("/br/com/argus/view/Dashboard.fxml"));
           
           sceneHome = new Scene(telaHome);
        
            primayStage.setScene(sceneHome);
            primayStage.centerOnScreen();
            primayStage.show();
            setStage(stage);
        } catch (Exception e) {
            e.printStackTrace();
        }    
    }
    
    public static void setStage(Stage Sstage){
         stage = Sstage;
    }
    
    public static Stage getStage (){
        return stage;
    }
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
