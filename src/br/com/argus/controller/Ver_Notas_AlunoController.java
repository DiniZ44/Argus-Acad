/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.argus.controller;

import br.com.argus.app.App;
import br.com.argus.exceptions.BussinesException;
import br.com.argus.facade.Facade;
import br.com.argus.model.Aluno;
import br.com.argus.model.VinculoAlunoTurma;
import br.com.argus.view.Mensagem;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
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
public class Ver_Notas_AlunoController implements Initializable {
    
    private static VinculoAlunoTurma vinculoAlunoTurma, VAT;
    private final static String CADASTRAR_NOTA = "/br/com/argus/view/Cadastrar_Nota.fxml";
    private Ver_Notas_DisciplinasController ver_Notas_DisciplinasController;

    @FXML
    private TableView<VinculoAlunoTurma> table_aluno;

    @FXML
    private TableColumn<VinculoAlunoTurma, Double> table_nota;

    @FXML
    private TableColumn<VinculoAlunoTurma, Double> table_nota2;

    @FXML
    private TableColumn<VinculoAlunoTurma, Double> table_nota3;

    @FXML
    private TableColumn<VinculoAlunoTurma, Double>table_nota4;

    @FXML
    private TableColumn<VinculoAlunoTurma, Double> table_media;

    @FXML
    private TableColumn<VinculoAlunoTurma, Double> table_mediaFinal;

    @FXML
    private TableColumn<VinculoAlunoTurma, String>table_situacaoAluno;
    
    @FXML
    private TableColumn<VinculoAlunoTurma, String> aluno_table;

    @FXML
    private TextField pesquisa;

    @FXML
    private Button buscar;

    @FXML
    private Label disciplina_label;

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
        
        
          // --------------------------------------------------
            table_aluno.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                try {
                    if(event.getClickCount() == 2){
                        if(table_aluno.getSelectionModel().getSelectedItem() != null){
                            VAT = table_aluno.getSelectionModel().getSelectedItem();
                            App.genericaStage(CADASTRAR_NOTA).show();
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
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initVinculoAluno();
        try {
            carregarTabela(Facade.getInstance().buscarTodosVincAlunoTurma());
        } catch (BussinesException ex) {
            ex.printStackTrace();
        }
    }    
    
    void carregarTabela(List<VinculoAlunoTurma> alunos){
        for (VinculoAlunoTurma aluno : alunos) {
            if(aluno.getAluno().getId() == vinculoAlunoTurma.getAluno().getId()){
                disciplina_label.setText(vinculoAlunoTurma.getDisciplinaTurma().getDisciplina().getNome());
                
                table_nota.setCellValueFactory(data-> new SimpleObjectProperty<>(data.getValue().getNota1()));
                table_nota2.setCellValueFactory(data-> new SimpleObjectProperty<>(data.getValue().getNota2()));
                table_nota3.setCellValueFactory(data-> new SimpleObjectProperty<>(data.getValue().getNota3()));
                table_nota4.setCellValueFactory(data-> new SimpleObjectProperty<>(data.getValue().getNota4()));
              //  aluno_table.setCellValueFactory(data-> new SimpleObjectProperty<>(data.getValue().getNome()));
                table_media.setCellValueFactory(data-> new SimpleObjectProperty<>(data.getValue().getMedia()));
                table_mediaFinal.setCellValueFactory(data-> new SimpleObjectProperty<>(data.getValue().getMediaFinal()));
//                table_situacaoAluno.setCellValueFactory(data-> new SimpleObjectProperty<>(data.getValue().getSituacaoAluno().toString()));
               
           }
            
             table_aluno.getItems().setAll(aluno);
        }
        
        
    }
    
    void initVinculoAluno(){
        vinculoAlunoTurma = ver_Notas_DisciplinasController.getVat();
    
    }

    public static VinculoAlunoTurma getVAT() {
        return VAT;
    }

    public static void setVAT(VinculoAlunoTurma VAT) {
        Ver_Notas_AlunoController.VAT = VAT;
    }
    
    
    
}
