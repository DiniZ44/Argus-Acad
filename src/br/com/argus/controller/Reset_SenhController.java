package br.com.argus.controller;

import br.com.argus.app.App;
import br.com.argus.model.Usuario;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class Reset_SenhController {
    
    private static String SENHA = "";

    @FXML
    private TextField login_field;

    @FXML
    private Button solicitar;

    @FXML
    private Button sair_button;

    @FXML
    private RadioButton resetar_senha;

    @FXML
    void cb_resetar(ActionEvent event) {

    }

    @FXML
    void voltar(ActionEvent event) throws IOException {
        App.stageLogin().show();
    }

    @FXML
    void solcitar_reset(ActionEvent event) {

    }
    
    public String senhaPadrao(Usuario usuario){
        return SENHA = usuario.getCpf();
    }

}

