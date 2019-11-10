package br.com.argus.controller;

import br.com.argus.app.App;
import br.com.argus.exceptions.BussinesException;
import br.com.argus.facade.Facade;
import br.com.argus.model.Disciplina;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class Ver_DisciplinasController implements Initializable{
    public static final String CADASTRO_DISCIPLINA = "/br/com/argus/view/Cadastrar_Disciplina.fxml" ;
   
    @FXML
    private TableView<Disciplina> disciplinas_table;
   
    @FXML
    private TableColumn<Disciplina, String> table_name;

    @FXML
    private TableColumn <Disciplina, String> table_codigo;

    @FXML
    private TableColumn<Disciplina, String> table_professor;

    @FXML
    private TableColumn<Disciplina, String> table_carga_hora;

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            carregarTabela(Facade.getInstance().buscarTodosDisciplinas());
        } catch (BussinesException ex) {
            ex.printStackTrace();
        }
    }

    void carregarTabela(List<Disciplina> disciplinas){
        
        table_carga_hora.setCellValueFactory(new PropertyValueFactory<>("carga_horaria"));
        table_codigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));;
        table_name.setCellValueFactory(new PropertyValueFactory<>("nome"));;
        table_professor.setCellValueFactory(new PropertyValueFactory<>("professor"));
        
        disciplinas_table.getItems().setAll(disciplinas);
    }

}

