package br.com.argus.controller;

import br.com.argus.app.App;
import br.com.argus.enuns.ResetSenha;
import br.com.argus.exceptions.BussinesException;

import br.com.argus.facade.Facade;
import br.com.argus.model.Usuario;
import br.com.argus.util.SQLUtil;
import br.com.argus.view.Mensagem;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class Reset_SenhController {
    
    private static Usuario usuario, userAtual;
    

    @FXML
    private TextField login_field;

    @FXML
    private RadioButton resetar_senha;

    @FXML
    void cb_resetar(ActionEvent event) {
        resetar_senha.isSelected();
        System.out.println(resetar_senha);
    }

    @FXML
    void voltar(ActionEvent event) throws IOException {
        App.stageLogin().show();
    }

    @FXML
    void solcitar_reset(ActionEvent event) throws BussinesException, IOException {
        if(efetuarLogin()){
            userAtual.setSolicitar_reset(ResetSenha.SIM);
            Facade.getInstance().inserirOuAtualizar(usuario);
            Mensagem.getInstance().mostrarMensagem("RESET SENHA", "O reset senha foi solicitado ao Administrador, em breve sua senha será resetada para a padrão!", Alert.AlertType.INFORMATION);
            App.stageLogin().show();
        }
    }
    
    
    public boolean efetuarLogin(){
        
        try {
            usuario = Facade.getInstance().buscaLogin(login_field.getText());
            
            
            if (usuario == null){
                Mensagem.getInstance().mostrarMensagem("LOGIN", "Senha ou Email incorretos, Por favor verifique novamente seus dados", Alert.AlertType.ERROR);
                return false;
            }
            
            login_field.getText();
            this.login_field.clear();
            userAtual = usuario;
            return true;
            
        } catch (Exception e) {
            e.printStackTrace();
             Mensagem.getInstance().mostrarMensagem("LOGIN", "Senha ou Email incorretos, Por favor verifique novamente seus dados", Alert.AlertType.ERROR);
            this.login_field.clear();
            return false;
        }

        
    }
}

