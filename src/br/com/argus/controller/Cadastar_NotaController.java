/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.argus.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Hakkinen
 */
public class Cadastar_NotaController implements Initializable {
    
    @FXML
    private TextField nota1;

    @FXML
    private TextField nota3;

    @FXML
    private TextField nota2;

    @FXML
    private TextField nota4;

    @FXML
    void salvar(ActionEvent event) {

    }

    @FXML
    void voltar(ActionEvent event) {

    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
