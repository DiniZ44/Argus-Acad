/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.argus.controller;

import br.com.argus.app.App;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author Hakkinen
 */
public class Ver_ConfigController implements Initializable {
    
    public static final String CONFIG_BITRI = "/br/com/argus/view/Config_BiTri.fxml" ;
    public static final String CONFIG_VALOR = "/br/com/argus/view/Config_Valor.fxml" ;

    /**
     * Initializes the controller class.
     */
    
    @FXML
    void ConfigurarValorCarne(ActionEvent event) throws IOException {
        App.genericaStage(CONFIG_VALOR).show();
    }

    @FXML
    void configurarAnoLetivo(ActionEvent event) throws IOException {
        App.genericaStage(CONFIG_BITRI).show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
