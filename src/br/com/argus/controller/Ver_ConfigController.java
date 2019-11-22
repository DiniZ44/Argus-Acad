/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.argus.controller;

import br.com.argus.app.App;
import br.com.argus.util.Backup;
import br.com.argus.util.Restore;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
    @FXML
    void Backup(ActionEvent event) {
        try {
            Backup.realizaBackup();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
    
    
    @FXML
    void restore(ActionEvent event) {
        Restore.realizaRestore();
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
