/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.argus.controller;

import br.com.argus.app.App;
import br.com.argus.exceptions.BussinesException;
import br.com.argus.facade.Facade;
import br.com.argus.model.LiquidaCarne;
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
 * @author santo
 */
public class Ver_FinanceiroController implements Initializable {
    public final static String CADASTRAR_CARNE = "/br/com/argus/view/Cadastrar_Carne.fxml" ;
    public final static String ALTERAR_CARNE = "/br/com/argus/view/Alterar_Carne.fxml" ;
    private static LiquidaCarne lc;
    
    @FXML
    private TableView<LiquidaCarne> carnes_table;

    @FXML
    private TableColumn<LiquidaCarne, String> table_aluno;

    @FXML
    private TableColumn<LiquidaCarne, String> table_resp;

    @FXML
    private TableColumn<LiquidaCarne, Double> table_valor;

    @FXML
    private TableColumn<LiquidaCarne, LocalDate> table_date;

    @FXML
    private TableColumn<LiquidaCarne, String> table_pago;

    @FXML
    private TextField pesquisa;
    
    @FXML
    private Button novo_carne;

    @FXML
    void adcionar_carne(ActionEvent event) throws IOException {
        App.genericaStage(CADASTRAR_CARNE).show();
        
    }

    @FXML
    void buscar_turma(ActionEvent event) {

    }

    @FXML
    void sicronizar(ActionEvent event) {
        try {
            atualizarTabela(Facade.getInstance().buscarTodosLiquidaCarne());
        } catch (BussinesException ex) {
            ex.printStackTrace();
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            atualizarTabela(Facade.getInstance().buscarTodosLiquidaCarne());
        } catch (BussinesException ex) {
            ex.printStackTrace();
        }
        
        // ----------------------------------------------------------------------
        carnes_table.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                try {
                    if(event.getClickCount() == 2){
                        if(carnes_table.getSelectionModel().getSelectedItem() != null){
                            lc = carnes_table.getSelectionModel().getSelectedItem();
                            App.genericaStage(ALTERAR_CARNE).show();
                        }else{
                            Mensagem.getInstance().confirmar("Atenção", "Selecione o usuario", Alert.AlertType.WARNING);
                        }
                   
                }
                    
                    } catch (IOException ex) {
                        ex.printStackTrace();
                        }

            }
        
        
        });
    // ----------------------------------------------------------------------
        
        
    }

    void atualizarTabela(List<LiquidaCarne> carnes){
        table_aluno.setCellValueFactory(data-> new SimpleStringProperty(data.getValue().getCarne_Pagamento().getAluno().getNome()));
        table_date.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getCarne_Pagamento().getData_vencimento()));
        table_pago.setCellValueFactory(data-> new SimpleObjectProperty<>(data.getValue().getSituacaoCarne().toString()));
        table_resp.setCellValueFactory(data-> new SimpleStringProperty(data.getValue().getCarne_Pagamento().getAluno().getResponsavel_financeiro().getNome()));        
        table_valor.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getCarne_Pagamento().getValor()));
        
        
        carnes_table.getItems().setAll(carnes);
    }

    public static LiquidaCarne getLc() {
        return lc;
    }

    public static void setLc(LiquidaCarne lc) {
        Ver_FinanceiroController.lc = lc;
    }

    public Button getNovo_carne() {
        return novo_carne;
    }
    
    
    
}
