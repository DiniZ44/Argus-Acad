/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.argus.controller;

import br.com.argus.model.VinculoAlunoTurma;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Hakkinen
 */
public class Ver_Notas_AlunoController implements Initializable {
    
    

    @FXML
    private TableView<VinculoAlunoTurma> turma_table;

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
    private TableColumn<VinculoAlunoTurma, Double>table_situacaoAluno;

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

    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    void carregarTabela(){
    
    }
    
}
