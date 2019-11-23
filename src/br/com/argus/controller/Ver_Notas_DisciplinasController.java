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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Hakkinen
 */
public class Ver_Notas_DisciplinasController implements Initializable {
    private static VinculoAlunoTurma vinculoAlunoTurma, Vat;
    private Ver_NotasController ver_NotasController;
    private final static String VER_NOTAS_ALUNO = "/br/com/argus/view/Ver_Notas_Aluno.fxml";
    @FXML
    private TableView<VinculoAlunoTurma> turma_table;

    @FXML
    private TableColumn<VinculoAlunoTurma, String> table_disciplina;

    @FXML
    private TableColumn<VinculoAlunoTurma, String> table_professor;

    @FXML
    private TextField pesquisa;

    @FXML
    private Button buscar;

    @FXML
    private Label label_turma;

    @FXML
    void buscar_turma(ActionEvent event) {

    }

    @FXML
    void sicronizar(ActionEvent event) {
        try {
            carregarTabela(Facade.getInstance().buscarTodosVincAlunoTurma());
        } catch (BussinesException ex) {
           ex.printStackTrace();
        }
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       intiDisciplina();
        try {
            carregarTabela(Facade.getInstance().buscarTodosVincAlunoTurma());
        } catch (BussinesException ex) {
           ex.printStackTrace();
        }
        
         // --------------------------------------------------
            turma_table.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                try {
                    if(event.getClickCount() == 2){
                        if(turma_table.getSelectionModel().getSelectedItem() != null){
                            Vat = turma_table.getSelectionModel().getSelectedItem();
                            App.genericaStage(VER_NOTAS_ALUNO).show();
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
    
    void intiDisciplina (){
        vinculoAlunoTurma = ver_NotasController.getvaT();
    }
    
    void carregarTabela(List<VinculoAlunoTurma> vinculos){
        
        for (VinculoAlunoTurma v : vinculos) {
            if(v.getDisciplinaTurma().getTurma().getId() == vinculoAlunoTurma.getDisciplinaTurma().getTurma().getId()){
                
                label_turma.setText(vinculoAlunoTurma.getDisciplinaTurma().getTurma().getNome());
                table_disciplina.setCellValueFactory(data ->  new SimpleObjectProperty<>(data.getValue().getDisciplinaTurma().getDisciplina().getNome()));
                table_professor.setCellValueFactory(data ->  new SimpleStringProperty(data.getValue().getDisciplinaTurma().getDisciplina().getProfessor().getNome()));
                
             turma_table.getItems().setAll(v);
            }
        }
        

    
    }

    public static VinculoAlunoTurma getVat() {
        return Vat;
    }

    public static void setVat(VinculoAlunoTurma Vat) {
        Ver_Notas_DisciplinasController.Vat = Vat;
    }
    
    
}
