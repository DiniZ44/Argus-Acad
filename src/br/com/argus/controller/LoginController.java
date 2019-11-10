package br.com.argus.controller;

import br.com.argus.app.App;
import br.com.argus.enuns.TipoCargo;
import br.com.argus.facade.Facade;
import br.com.argus.model.Usuario;
import br.com.argus.view.Mensagem;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;

import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController implements Initializable {

    public static String user_Login_Logado, user_Senha_Logado;;
    private static Usuario usuario;
    private DashboardController dashboardController;
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
    private Button sair_button;
    

    @FXML
    void entrar(ActionEvent event) throws IOException {
        
       if(efetuarLogin()){
        
        App.stagePrincipal().show();;
        App.stagePrincipal().setResizable(false);
        App.stagePrincipal().setTitle("Tela Inicial");
        App.stageLogin().close();
       }
       
//       dashboardController.isUsuario();
//        if(efetuarLogin()){
//        App a = new App();
//        try {
//            a.startA(new Stage());
//            App.getStage().close();
//        } catch (Exception e) {
//            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, e);
//        }
//    }
    
    }
    @FXML
    void sair(ActionEvent event) {
        System.exit(0);
    }
    
     @FXML
    void esqueceu_senha(ActionEvent event) throws IOException {
        
        App.genericaStage(App.RESET_SENHA);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public boolean efetuarLogin(){
        
        try {
            usuario = facade.buscarLoginUsuario(login_field.getText(),senha_passField.getText());
            
            
            if (usuario == null){
                Mensagem.getInstance().mostrarMensagem("LOGIN", "Usuario não encontrado", Alert.AlertType.ERROR);
                return false;
            }
            
            user_Login_Logado = login_field.getText();
            user_Senha_Logado = senha_passField.getText();
            this.login_field.clear();
            this.senha_passField.clear();

            return true;
            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        
    }
    
    boolean isCoordenacao(){
        try {
            usuario = facade.buscarTipo("COORDENAÇÃO_PEDAGOGA");
             if (usuario == null){
                Mensagem.getInstance().mostrarMensagem("TIPO USUARIO", "Usuario não encontrado", Alert.AlertType.ERROR);
                return false;
            } 
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    
    boolean isDiretoria(){
        try {
            usuario = facade.buscarTipo("DIRETORIA");
             if (usuario == null){
                Mensagem.getInstance().mostrarMensagem("TIPO USUARIO", "Usuario não encontrado", Alert.AlertType.ERROR);
                return false;
            } 
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        }
    
    
    boolean isSecretaria(){
        try {
            usuario = facade.buscarTipo("SECRETARIA");
             if (usuario == null){
                Mensagem.getInstance().mostrarMensagem("TIPO USUARIO", "Usuario não encontrado", Alert.AlertType.ERROR);
                return false;
            } 
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    boolean isADM(){
        try {
            usuario = facade.buscarTipo("SUPER_USUARIO");
             if (usuario == null){
                Mensagem.getInstance().mostrarMensagem("TIPO USUARIO", "Usuario não encontrado", Alert.AlertType.ERROR);
                return false;
            } 
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

    public Button getSair_button() {
        return sair_button;
    }

    /**
     *
     * @return
     */
    public Usuario getUsuario() {
        return usuario;
    }
    
    
}
