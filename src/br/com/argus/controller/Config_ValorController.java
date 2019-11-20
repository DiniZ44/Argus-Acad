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
public class Config_ValorController implements Initializable {
    
    @FXML
    private TextField valor_inicial_EF;

    @FXML
    private TextField valor_final_EF;

    @FXML
    private TextField valor_EM;

    @FXML
    void aplicar(ActionEvent event) {
        
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
    
    void converterInt(){

        String Newvalor_final_EF = valor_final_EF.getText();
        String Newvalor_inicial_EF = valor_EM.getText();
        String Newvalor_EM = valor_inicial_EF.getText();
        
        int EF_incial = Integer.parseInt(Newvalor_final_EF);
        int EF_final = Integer.parseInt(Newvalor_final_EF);
        int EM = Integer.parseInt(Newvalor_EM);
    }
    
}
