/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.argus.controller;

import br.com.argus.app.App;
import br.com.argus.exceptions.BussinesException;
import br.com.argus.facade.Facade;
import br.com.argus.model.ObservacaoAluno;
import br.com.argus.view.Mensagem;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Hakkinen
 */
public class Ver_ObservacaoController  implements Initializable {
    
    public static final String CADASTRAR_OBS = "/br/com/argus/view/Cadastrar_Observacao.fxml";
    public static final String ALTERAR_OBS ="/br/com/argus/view/Alterar_Observacao.fxml" ;
    
    private static ObservacaoAluno obs;
    
    @FXML
    private TableView<ObservacaoAluno> table_OBS;

    @FXML
    private TableColumn<ObservacaoAluno, String> table_aluno;

    @FXML
    private TableColumn<ObservacaoAluno, String>  table_matricula;

    @FXML
    private TableColumn<ObservacaoAluno, LocalDate>  table_data;

    @FXML
    private TableColumn<ObservacaoAluno, String> table_coord;

    @FXML
    private TextField pesquisa;

    @FXML
    private Button buscar;

    @FXML
    private Button add;

    @FXML
    void add_obs(ActionEvent event) throws IOException {
        App.genericaStage(CADASTRAR_OBS).show();
    }

    @FXML
    void buscar_aluno(ActionEvent event) {

    }

    @FXML
    void sicronizar(ActionEvent event) {
       try {
            carregarTabela(Facade.getInstance().buscarTodosObsAluno());
        } catch (BussinesException ex) {
            ex.printStackTrace();
        }
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        try {
            carregarTabela(Facade.getInstance().buscarTodosObsAluno());
        } catch (BussinesException ex) {
            ex.printStackTrace();
        }
        
        table_OBS.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                try {
                    if(event.getClickCount() == 2){
                        if(table_OBS.getSelectionModel().getSelectedItem() != null){
                            obs = table_OBS.getSelectionModel().getSelectedItem();
                            App.genericaStage(ALTERAR_OBS).show();
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
    
    void carregarTabela(List<ObservacaoAluno> obs){
        
        table_aluno.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getAluno().getNome()));
        table_coord.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getCoordenador().getNome()));
        table_data.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getData()));
        table_matricula.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getAluno().getMatricula()));
        
        table_OBS.getItems().setAll(obs);
    
    }

    public static ObservacaoAluno getObs() {
        return obs;
    }
    
    
    

    

    
}
