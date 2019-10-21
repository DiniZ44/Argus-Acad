package br.com.argus.controller;


import br.com.argus.app.App;
import br.com.argus.view.Mensagem;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;

import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class Ver_UsuariosController implements Initializable{
    
    public static final String CADASTRO_USUARIO1 = "/br/com/argus/view/Cadastrar_Usuario.fxml" ;
//    private Pane cadastrar_usuario;
//    
//    DashboardController dashboardController;
    
    @FXML
    private TableColumn<?, ?> table_name;

    @FXML
    private TableColumn<?, ?> table_login;

    @FXML
    private TableColumn<?, ?> table_senha;

    @FXML
    private TableColumn<?, ?> table_cpf;

    @FXML
    private TableColumn<?, ?> table_cargo;

    @FXML
    private TableColumn<?, ?> table_acesso;

    @FXML
    private TextField pesquisa;

    @FXML
    private Button buscar;

    @FXML
    private Button add;

    @FXML
    private Button atualizar;

    @FXML
    void adcionar_user(ActionEvent event) throws IOException {
//        dashboardController.getAnchor_pane().getChildren().setAll(cadastrar_usuario);
        App.genericaStage(CADASTRO_USUARIO1).show();
    }

    @FXML
    void atualizar_user(ActionEvent event) {

    }

    @FXML
    void buscar_user(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        try {
//            cadastrar_usuario = FXMLLoader.load(getClass().getResource(CADASTRO_USUARIO1));
//        } catch (IOException ex) {
//            Mensagem.getInstance().mostrarMensagem("Erro Carregar Tela", "Erro ao carregar os componentes gráficos "+ex.getMessage(), Alert.AlertType.ERROR);
//            Logger.getLogger(Ver_UsuariosController.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

}
