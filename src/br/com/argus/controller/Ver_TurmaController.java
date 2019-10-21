package br.com.argus.controller;

import br.com.argus.app.App;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

public class Ver_TurmaController {
    
    public static final String CADASTRO_TURMA = "/br/com/argus/view/Cadastrar_Turma.fxml" ;

    @FXML
    private TableColumn<?, ?> table_name;

    @FXML
    private TableColumn<?, ?> table_nota;

    @FXML
    private TableColumn<?, ?> table_alunos;

    @FXML
    private TableColumn<?, ?> table_disciplinas;

    @FXML
    private TableColumn<?, ?> table_status_aluno;

    @FXML
    private TextField pesquisa;

    @FXML
    private Button buscar;

    @FXML
    private Button add;

    @FXML
    private Button atualizar;

    @FXML
    void adcionar_Turma(ActionEvent event) throws IOException {
        App.genericaStage(CADASTRO_TURMA).show();
    }

    @FXML
    void atualizar_turma(ActionEvent event) {

    }

    @FXML
    void buscar_turma(ActionEvent event) {

    }

}
