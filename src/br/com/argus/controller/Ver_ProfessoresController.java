package br.com.argus.controller;

import br.com.argus.app.App;
import static br.com.argus.controller.Ver_UsuariosController.CADASTRO_USUARIO1;
import br.com.argus.exceptions.BussinesException;
import br.com.argus.facade.Facade;
import br.com.argus.model.Contato;
import br.com.argus.model.Professor;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
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

public class Ver_ProfessoresController implements Initializable{
    public static final String CADASTRO_PROFESSOR = "/br/com/argus/view/Cadastrar_Professor.fxml" ;
    public static final String VER_PROFESSORES = "/br/com/argus/view/Ver_Professores.fxml" ;
    
    @FXML
    private TableView<Professor> professor_table;   
    @FXML
    private TableColumn<Professor, String> table_name;

    @FXML
    private TableColumn<Professor, String> table_cpf;

    @FXML
    private TableColumn<Professor, LocalDate> table_date;

    @FXML
    private TableColumn<Professor, Contato> table_contato;

    @FXML
    private TextField pesquisa;


     @FXML
    void adcionar_professor(ActionEvent event) throws IOException {
        App.genericaStage(CADASTRO_PROFESSOR).show();
    }

    @FXML
    void sicronizar(ActionEvent event) throws IOException {
        App.genericaStage(VER_PROFESSORES);
    }

    @FXML
    void buscar_professor(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            carregarTabela(Facade.getInstance().buscarTodosProfessores());
        } catch (BussinesException ex) {
            ex.printStackTrace();
        }
    }
    void carregarTabela(List<Professor> professores){
    table_name.setCellValueFactory(new PropertyValueFactory<>("nome"));
    table_cpf.setCellValueFactory(new PropertyValueFactory<>("cpf"));
    table_date.setCellValueFactory(new PropertyValueFactory<>("data_nascimento"));
    table_contato.setCellValueFactory(new PropertyValueFactory<>("contato"));
    
    professor_table.getItems().setAll(professores);
    }
}
