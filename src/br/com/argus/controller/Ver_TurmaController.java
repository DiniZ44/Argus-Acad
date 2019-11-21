package br.com.argus.controller;

import br.com.argus.app.App;
import static br.com.argus.controller.Ver_UsuariosController.ALTERAR_USUARIO;
import br.com.argus.exceptions.BussinesException;
import br.com.argus.facade.Facade;
import br.com.argus.model.DisciplinaTurma;
import br.com.argus.model.Turma;
import br.com.argus.view.Mensagem;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class Ver_TurmaController implements Initializable{
    
    public static final String CADASTRO_TURMA = "/br/com/argus/view/Cadastrar_Turma.fxml" ;
    public static final String ALTERAR_TURMA ="/br/com/argus/view/Alterar_Turma.fxml" ;
    public static final String VER_TURMA = "/br/com/argus/view/Ver_Turma.fxml" ;
    private static Turma t;
    private static DisciplinaTurma dt;
    
    
    
    @FXML
    private TableView<DisciplinaTurma> turma_table;
    
    @FXML
    private TableColumn<DisciplinaTurma, String> table_name;

    @FXML
    private TableColumn<DisciplinaTurma, String> table_disciplinas;
    
    @FXML
    private TableColumn<DisciplinaTurma, String> table_anoLetivo;

    @FXML
    private TextField pesquisa;


    @FXML
    void adcionar_Turma(ActionEvent event) throws IOException {
        App.genericaStage(CADASTRO_TURMA).show();
    }

    @FXML
    void sicronizar(ActionEvent event) throws IOException {
           try {
            carregarTabela(Facade.getInstance().buscarTodosDisciplinaTurma());
        } catch (BussinesException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    void buscar_turma(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            carregarTabela(Facade.getInstance().buscarTodosDisciplinaTurma());
        } catch (BussinesException ex) {
            ex.printStackTrace();
        }
        
               turma_table.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                try {
                    if(event.getClickCount() == 2){
                        if(turma_table.getSelectionModel().getSelectedItem() != null){
                            dt = turma_table.getSelectionModel().getSelectedItem();
                            App.genericaStage(ALTERAR_TURMA).show();
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
    void carregarTabela(List<DisciplinaTurma> turmas){
    table_name.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getTurma().getNome()));
    table_disciplinas.setCellValueFactory(new PropertyValueFactory<>("disciplina")); 
    table_anoLetivo.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getTurma().getAnoLetivo())); 
        
     turma_table.getItems().setAll(turmas);
    }

    public static Turma getT() {
        return t;
    }

    public static void setT(Turma t) {
        Ver_TurmaController.t = t;
    }

    public static DisciplinaTurma getDt() {
        return dt;
    }

    public static void setDt(DisciplinaTurma dt) {
        Ver_TurmaController.dt = dt;
    }
    
    
    
}
