package br.com.argus.controller;

import br.com.argus.app.App;
import br.com.argus.enuns.TipoCargo;
import br.com.argus.facade.Facade;
import br.com.argus.model.Usuario;
import br.com.argus.util.SQLUtil;
import br.com.argus.util.Segurança;
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
import javafx.stage.StageStyle;

public class LoginController implements Initializable {

    public static String user_Login_Logado, user_Senha_Logado;;
    private  Usuario usuario;
    private static Usuario u;
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
        
        App.stagePrincipal().show();
        App.stagePrincipal().setResizable(false);
        App.stagePrincipal().setTitle("Tela Inicial");
//        App.stagePrincipal().initStyle(StageStyle.UNDECORATED);
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
            user_Senha_Logado = usuario.getSenha();
            
            if (usuario == null){
                Mensagem.getInstance().mostrarMensagem("LOGIN", "Senha ou Email incorretos, Por favor verifique novamente seus dados", Alert.AlertType.ERROR);
                return false;
            }
            
//            user_Login_Logado = login_field.getText();
//            user_Senha_Logado = senha_passField.getText();
            
            u = usuario;
            this.login_field.clear();
            this.senha_passField.clear();
            SQLUtil.TIPO =  usuario.getTipoCargo().toString();
            return true;
            
        } catch (Exception e) {
            e.printStackTrace();
             Mensagem.getInstance().mostrarMensagem("LOGIN", "Senha ou Email incorretos, Por favor verifique novamente seus dados", Alert.AlertType.ERROR);
            this.login_field.clear();
            this.senha_passField.clear();
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

    public static Usuario getU() {
        return u;
    }
    
    
    
}
