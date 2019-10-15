package br.com.argus.controller;


import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


public class LoginController implements Initializable{
    
    public static final String Tela_Principal = "/br/com/argus/view/Dashboard.fxml";

    @FXML
    private TextField login_field;

    @FXML
    private PasswordField senha_passField;

    @FXML
    private Button entrar_button;

    @FXML
    private Button redefinir_button;
    
      @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


    public TextField getLogin_field() {
        return login_field;
    }

    public void setLogin_field(TextField login_field) {
        this.login_field = login_field;
    }

    public PasswordField getSenha_passField() {
        return senha_passField;
    }

    public void setSenha_passField(PasswordField senha_passField) {
        this.senha_passField = senha_passField;
    }

    public Button getEntrar_button() {
        return entrar_button;
    }


    public Button getRedefinir_button() {
        return redefinir_button;
    }

    
    

}