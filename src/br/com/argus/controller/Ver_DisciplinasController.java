package br.com.argus.controller;

import br.com.argus.app.App;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

public class Ver_DisciplinasController {
    public static final String CADASTRO_DISCIPLINA = "/br/com/argus/view/Cadastrar_Disciplina.fxml" ;

    @FXML
    private TableColumn<?, ?> table_name;

    @FXML
    private TableColumn<?, ?> table_codigo;

    @FXML
    private TableColumn<?, ?> table_professor;

    @FXML
    private TableColumn<?, ?> table_carga_hora;

    @FXML
    private TextField pesquisa;

    @FXML
    private Button buscar;

    @FXML
    private Button add;

    @FXML
    private Button atualizar;

    @FXML
    void adcionar_disciplina(ActionEvent event) throws IOException {
        App.genericaStage(CADASTRO_DISCIPLINA).show();
    }

    @FXML
    void atualizar_disciplina(ActionEvent event) {

    }

    @FXML
    void buscar_disciplina(ActionEvent event) {

    }

}

