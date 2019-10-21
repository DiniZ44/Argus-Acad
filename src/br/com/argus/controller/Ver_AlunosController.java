package br.com.argus.controller;

import br.com.argus.app.App;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

public class Ver_AlunosController {
    
    public static final String CADASTRO_ALUNO ="/br/com/argus/view/Cadastrar_Aluno.fxml" ;

    @FXML
    private TableColumn<?, ?> table_name;

    @FXML
    private TableColumn<?, ?> table_cpf;

    @FXML
    private TableColumn<?, ?> table_mae;

    @FXML
    private TableColumn<?, ?> table_pai;

    @FXML
    private TableColumn<?, ?> table_date;

    @FXML
    private TableColumn<?, ?> table_contato;

    @FXML
    private TableColumn<?, ?> table_resp;

    @FXML
    private TextField pesquisa;

    @FXML
    private Button buscar;

    @FXML
    private Button add;

    @FXML
    private Button atualizar;

    @FXML
    void adcionar_aluno(ActionEvent event) throws IOException {
        App.genericaStage(CADASTRO_ALUNO).show();
    }

    @FXML
    void atualizar_aluno(ActionEvent event) {

    }

    @FXML
    void buscar_aluno(ActionEvent event) {

    }

}

