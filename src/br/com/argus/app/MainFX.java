/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.argus.app;

import br.com.argus.exceptions.FXMLExcepton;
import br.com.argus.model.Usuario;
import java.io.IOException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;

/**
 *
 * @author santo
 */
public class MainFX extends Application {
    
//    public final String Tela_Login = "/br/com/argus/view/Login.fxml";
    
    @Override
    public void start(Stage stage) throws FXMLExcepton, IOException{
        
      Parent root = FXMLLoader.load(getClass().getResource("/br/com/argus/view/Login.fxml"));
       
       Scene scene = new Scene(root);
       
        stage.setScene(scene);
       stage.setResizable(false);
        stage.show();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
       
    }
    
}
