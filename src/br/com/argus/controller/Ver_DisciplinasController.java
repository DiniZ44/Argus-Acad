package br.com.argus.controller;

import br.com.argus.app.App;
import br.com.argus.exceptions.BussinesException;
import br.com.argus.facade.Facade;
import br.com.argus.model.Disciplina;
import br.com.argus.view.Mensagem;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class Ver_DisciplinasController implements Initializable{
    public static final String CADASTRO_DISCIPLINA = "/br/com/argus/view/Cadastrar_Disciplina.fxml" ;
    public static final String VER_DISCIPLINAS ="/br/com/argus/view/Ver_Disciplinas.fxml" ;
    public static final String ALTERAR_DISCIPLINA ="/br/com/argus/view/Alterar_Disciplina.fxml" ;
    private static Disciplina d;
   
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
    private Button add;

    @FXML
    void adcionar_disciplina(ActionEvent event) throws IOException {
        App.genericaStage(CADASTRO_DISCIPLINA).show();
    }

    @FXML
    void sicronizar(ActionEvent event) throws IOException {
             try {
            carregarTabela(Facade.getInstance().buscarTodosDisciplinas());
        } catch (BussinesException ex) {
            ex.printStackTrace();
        }
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
        
                disciplinas_table.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                try {
                    if(event.getClickCount() == 2){
                        if(disciplinas_table.getSelectionModel().getSelectedItem() != null){
                            d = disciplinas_table.getSelectionModel().getSelectedItem();
                            App.genericaStage(ALTERAR_DISCIPLINA).show();
                        }else{
                            Mensagem.getInstance().confirmar("Atenção", "Selecione o usuario", Alert.AlertType.WARNING);
                        }
                   
                }
                    
                    } catch (IOException ex) {
                        ex.printStackTrace();
                        }

            }
        
        
        });
    }

    void carregarTabela(List<Disciplina> disciplinas){
        
        table_carga_hora.setCellValueFactory(new PropertyValueFactory<>("carga_horaria"));
        table_codigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));;
        table_name.setCellValueFactory(new PropertyValueFactory<>("nome"));;
        table_professor.setCellValueFactory(new PropertyValueFactory<>("professor"));
        
        disciplinas_table.getItems().setAll(disciplinas);
    }

    public static Disciplina getD() {
        return d;
    }

    public static void setD(Disciplina d) {
        Ver_DisciplinasController.d = d;
    }

    public Button getAdd() {
        return add;
    }
    

}

