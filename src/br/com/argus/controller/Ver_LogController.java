/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.argus.controller;

import br.com.argus.exceptions.BussinesException;
import br.com.argus.facade.Facade;
import br.com.argus.model.Log;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Hakkinen
 */
public class Ver_LogController implements Initializable {
    
    
    @FXML
    private TableView<Log> table_log;

    @FXML
    private TableColumn<Log, String> table_autor;

    @FXML
    private TableColumn<Log, String> table_tipo_alteracao;

    @FXML
    private TableColumn<Log, String> table_alteracao;

    @FXML
    private TableColumn<Log, String> table_tabela;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        try {
//            carregarTabela(Facade.getInstance().buscarTudo());
//        } catch (BussinesException ex) {
//            ex.printStackTrace();
//        }
    }

     void carregarTabela(List<Log> logs){
         table_autor.setCellValueFactory(new PropertyValueFactory<>("autor"));
         table_alteracao.setCellValueFactory(new PropertyValueFactory<>("data"));
         table_tabela.setCellValueFactory(new PropertyValueFactory<>("tabela"));
         table_tipo_alteracao.setCellValueFactory(new PropertyValueFactory<>("alteracao"));
      
         table_log.getItems().setAll(logs);
     }
    
}
