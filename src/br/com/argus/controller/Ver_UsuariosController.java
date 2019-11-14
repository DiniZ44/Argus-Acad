package br.com.argus.controller;


import br.com.argus.app.App;
import br.com.argus.exceptions.BussinesException;
import br.com.argus.facade.Facade;
import br.com.argus.model.Entidade;
import br.com.argus.model.Usuario;
import br.com.argus.view.Mensagem;
import java.io.IOException;
import java.net.URL;
import java.util.List;
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
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class Ver_UsuariosController implements Initializable{
    
    public static final String CADASTRO_USUARIO1 = "/br/com/argus/view/Cadastrar_Usuario.fxml" ;
        public static final String VER_USUARIO = "/br/com/argus/view/Ver_Usuarios.fxml" ;
//    private Pane cadastrar_usuario;
//    
//    DashboardController dashboardController;
    
    @FXML
    private TableView<Usuario> table_usuario;
        
    @FXML
    private TableColumn<Usuario, String> table_name;

    @FXML
    private TableColumn<Usuario, String> table_login;

    @FXML
    private TableColumn<Usuario, String>table_senha;

    @FXML
    private TableColumn<Usuario, String>table_cpf;

    @FXML
    private TableColumn<Usuario, String> table_cargo;

    @FXML
    private TableColumn<Entidade, String> table_reset;

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
    void sicronizar(ActionEvent event) throws IOException {
        App.genericaStage(VER_USUARIO);
    }

    @FXML
    void buscar_user(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            carregarTabela(Facade.getInstance().buscarTodosUsers());
        } catch (BussinesException ex) {
            Mensagem.getInstance().mostrarMensagem("Erro Carregar Tela", "Erro ao carregar os componentes gráficos "+ex.getMessage(), Alert.AlertType.ERROR);
            ex.printStackTrace();
        }
    }
    
    void carregarTabela(List<Usuario> usuarios ) {
        
        table_reset.setCellValueFactory(new PropertyValueFactory<>("status"));
        table_cargo.setCellValueFactory(new PropertyValueFactory<>("tipoCargo"));
        table_cpf.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        table_login.setCellValueFactory(new PropertyValueFactory<>("login"));
        table_name.setCellValueFactory(new PropertyValueFactory<>("nome"));
        table_senha.setCellValueFactory(new PropertyValueFactory<>("senha"));
        
        table_usuario.getItems().setAll(usuarios);
    }
}
