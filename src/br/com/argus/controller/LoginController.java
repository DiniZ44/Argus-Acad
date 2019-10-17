package br.com.argus.controller;


import br.com.argus.app.App;
import br.com.argus.facade.Facade;
import br.com.argus.model.Usuario;
import br.com.argus.view.Mensagem;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;

import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


public class LoginController implements Initializable{
    
    public static final String Tela_Principal = "/br/com/argus/view/Dashboard.fxml";
    
    private static Usuario usuario;
    private Facade facade = Facade.getInstance();

    @FXML
    private TextField login_field;

    @FXML
    private PasswordField senha_passField;

    @FXML
    private Button entrar_button;

    @FXML
    private Button redefinir_button;
    
    @FXML
    void action (ActionEvent event) throws IOException{
        if(event.getSource() == entrar_button){
            App.stageDashboard().show();
            App.stageLogin().close();
        }
        if(event.getSource() == redefinir_button){
            
        }
    
    }
    
      @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    
    public boolean efetuarLogin(){
        
        try {
            usuario = facade.buscarLoginUsuario(login_field.getText(),senha_passField.getText());
            
            if (usuario == null){
                Mensagem.getInsMensagem().verMensagem(Alert.AlertType.ERROR, "Erro ao Logar", "Usuário não Existe", "Usuário Invalído");
                return false;
            }
            App.stageDashboard().show();
            App.stageLogin().close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        
        
    }


    public TextField getLogin_field() {
        return login_field;
    }

    public PasswordField getSenha_passField() {
        return senha_passField;
    }


    public Button getEntrar_button() {
        return entrar_button;
    }


    public Button getRedefinir_button() {
        return redefinir_button;
    }

    
    

}