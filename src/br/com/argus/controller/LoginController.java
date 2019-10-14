package br.com.argus.controller;

import br.com.argus.app.MainFX;
import br.com.argus.dao.DAO;
import br.com.argus.dao.LoginQuery;
import br.com.argus.model.Usuario;
import com.sun.istack.internal.logging.Logger;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

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
    
      private List<Usuario> listLogin = new ArrayList<>();
        private LoginQuery query = new LoginQuery();
    
      @Override
    public void initialize(URL location, ResourceBundle resources) {
        listLogin = query.listLogin();
    }

        @FXML
        public void logar (ActionEvent event) throws IOException{

            for(Usuario u: listLogin){
                if(this.getLogin_field().getText().equals(u.getLogin())){
                if(this.getSenha_passField().getText().equals(u.getSenha())){
                Parent parent = FXMLLoader.load(getClass().getResource(Tela_Principal));
                    Scene scene = new Scene(parent);
                    Stage stage = new Stage();
                    stage.setScene(scene);
                    stage.show();
                }
            }
            }



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