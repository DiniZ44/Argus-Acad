package br.com.argus.controller;

import br.com.argus.app.App;
import static br.com.argus.controller.Ver_UsuariosController.CADASTRO_USUARIO1;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

public class Ver_ProfessoresController {
    public static final String CADASTRO_PROFESSOR = "/br/com/argus/view/Cadastrar_Professor.fxml" ;
    
    @FXML
    private TableColumn<?, ?> table_name;

    @FXML
    private TableColumn<?, ?> table_cpf;

    @FXML
    private TableColumn<?, ?> table_date;

    @FXML
    private TableColumn<?, ?> table_contato;

    @FXML
    private TableColumn<?, ?> table_naturalidade;

    @FXML
    private TableColumn<?, ?> table_turma;

    @FXML
    private TableColumn<?, ?> table_dsiciplinas;

    @FXML
    private TextField pesquisa;

    @FXML
    private Button buscar;

    @FXML
    private Button add;

    @FXML
    private Button atualizar;

     @FXML
    void adcionar_professor(ActionEvent event) throws IOException {
        App.genericaStage(CADASTRO_PROFESSOR).show();
    }

    @FXML
    void atualizar_professor(ActionEvent event) {

    }

    @FXML
    void buscar_professor(ActionEvent event) {

    }

}
