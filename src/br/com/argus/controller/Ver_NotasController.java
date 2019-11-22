
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.argus.controller;

import br.com.argus.app.App;
import br.com.argus.exceptions.BussinesException;
import br.com.argus.facade.Facade;
import br.com.argus.model.VinculoAlunoTurma;
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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Hakkinen
 */
public class Ver_NotasController implements Initializable {
    
    private final static String CADASTRAR_MATRICULA = "/br/com/argus/view/Cadastrar_Aluno_Vinculo.fxml";
    private final static String VER_NOTAS_DISCIPLINA = "/br/com/argus/view/Ver_Notas_Disciplinas.fxml";
    private static VinculoAlunoTurma vaT;
    
    @FXML
    private TableView<VinculoAlunoTurma> table_aluno;

    @FXML
    private TableColumn<VinculoAlunoTurma, String> table_name;

    @FXML
    private TableColumn<VinculoAlunoTurma, String> table_anoLetivo;

    @FXML
    private TextField pesquisa;

    @FXML
    private Button buscar;

    @FXML
    private Button add;
    
    @FXML
    void cadastrar_matricula(ActionEvent event) throws IOException {
        App.genericaStage(CADASTRAR_MATRICULA).show();
    }


    @FXML
    void buscar_turma(ActionEvent event) {

    }

    @FXML
    void sicronizar(ActionEvent event) {

    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            atualizarTabela(Facade.getInstance().buscarTodosVincAlunoTurma());
        } catch (BussinesException ex) {
            ex.printStackTrace();
        }
        
        
        // --------------------------------------------------
            table_aluno.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                try {
                    if(event.getClickCount() == 2){
                        if(table_aluno.getSelectionModel().getSelectedItem() != null){
                            vaT = table_aluno.getSelectionModel().getSelectedItem();
                            App.genericaStage(VER_NOTAS_DISCIPLINA).show();
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

    void atualizarTabela(List<VinculoAlunoTurma> alunosTurma){
        
        table_name.setCellValueFactory(data ->  new SimpleStringProperty(data.getValue().getDisciplinaTurma().getTurma().getNome()));
        table_anoLetivo.setCellValueFactory(data ->  new SimpleStringProperty(data.getValue().getDisciplinaTurma().getTurma().getAnoLetivo()));
        
        table_aluno.getItems().setAll(alunosTurma);

    }

    public static VinculoAlunoTurma getvaT() {
        return vaT;
    }

    public static void setvaT(VinculoAlunoTurma vinculoAlunoTurma) {
        Ver_NotasController.vaT = vinculoAlunoTurma;
    }
    
    
    
}
