/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.argus.app;

import br.com.argus.exceptions.FXMLExcepton;
import br.com.argus.facade.Facade;
import br.com.argus.facade.IFacade;
import br.com.argus.model.Usuario;
import java.io.IOException;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
import javafx.stage.Modality;
import javafx.stage.WindowEvent;

/**
 *
 * @author santo
 */
public class App extends Application {
    
    public static final String Tela_Login = "/br/com/argus/view/Login.fxml";
    public static final String Tela_Principal = "/br/com/argus/view/Dashboard.fxml";
    public static final String Tela_Cadastro_Usuario = "/br/com/argus/view/Cadastrar_Usuario.fxml";
    public static final String Tela_Senha = "/br/com/argus/view/Reset_Senha.fxml";
    
    
    public static Stage STAGE = new Stage();
    public static Stage STAGE_DASHBOARD = new Stage();
    
    @Override
    public void start(Stage primayStage) throws FXMLExcepton, IOException{
        STAGE.initOwner(STAGE_DASHBOARD);
        STAGE.initModality(Modality.WINDOW_MODAL);
        
        stageLogin().show();

    }
    
    public static Stage stageLogin() throws IOException{
        STAGE.setScene(new Scene(FXMLLoader.load(App.class.getResource(Tela_Login))));
        STAGE.setResizable(false);
        STAGE.setOnCloseRequest(new EventHandler<WindowEvent>() {
            public void handle(WindowEvent event) { STAGE.close();
                
            }
        });
        return STAGE;
    }
    
    public static Stage stageDashboard() throws IOException{
        STAGE_DASHBOARD.setScene(new Scene(FXMLLoader.load(App.class.getResource(Tela_Principal))));
        STAGE.setOnCloseRequest(new EventHandler<WindowEvent>() {
            public void handle(WindowEvent event) { System.exit(0);
                
            }
        });
        return STAGE_DASHBOARD;
    }
    
       public static Stage stageGenerica(String caminho) throws IOException{
        STAGE.setScene(new Scene(FXMLLoader.load(App.class.getResource(caminho))));
        STAGE.setOnCloseRequest(new EventHandler<WindowEvent>() {
            public void handle(WindowEvent event) { STAGE.close();
                
            }
        });
        return STAGE;
    }
    
    
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        IFacade facade = Facade.getInstance();
        
//        Usuario usuario = new Usuario();
//        
//        usuario.setLogin("admin");
//        usuario.setNome("Administrador");
//        usuario.setSenha("admin");
//        
//        try {
//            facade.inserirOuAtualizar(usuario);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        
        launch(args);
       
    }
    
}
