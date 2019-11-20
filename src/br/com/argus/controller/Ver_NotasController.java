/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.argus.controller;

import br.com.argus.model.DisciplinaTurma;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Hakkinen
 */
public class Ver_NotasController implements Initializable {
    
    
    @FXML
    private TableView<DisciplinaTurma> turma_table;

    @FXML
    private TableColumn<DisciplinaTurma, String> table_name;

    @FXML
    private TableColumn<DisciplinaTurma, String> table_anoLetivo;

    @FXML
    private TextField pesquisa;

    @FXML
    private Button buscar;

    @FXML
    private Button add;

    @FXML
    void adcionar_Turma(ActionEvent event) {

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
        // TODO
    }

    void atualizarTabela(){
        
    }
    
}
