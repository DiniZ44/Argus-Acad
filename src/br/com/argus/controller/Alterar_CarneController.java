/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.argus.controller;

import br.com.argus.app.App;
import br.com.argus.enuns.SituacaoCarne;
import br.com.argus.exceptions.BussinesException;
import br.com.argus.facade.Facade;
import br.com.argus.model.Carne_Pagamento;
import br.com.argus.model.LiquidaCarne;
import br.com.argus.view.Mensagem;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;

/**
 * FXML Controller class
 *
 * @author Hakkinen
 */
public class Alterar_CarneController implements Initializable {
    
    public final static String ALTERAR_CARNE = "/br/com/argus/view/Alterar_Carne.fxml" ;
    private static LiquidaCarne liquidaCarne;
    private Carne_Pagamento carne_Pagamento;
    Ver_FinanceiroController ver_FinanceiroController;
    
    @FXML
    private ComboBox<SituacaoCarne> tipo_pagemnto_cbox;

    @FXML
    private DatePicker data_pag;

    @FXML
    void salvar(ActionEvent event) throws IOException {
        cadastrar();
    }

    @FXML
    void voltar(ActionEvent event) throws IOException {
        App.genericaStage(ALTERAR_CARNE).close();
    }
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        carregarCombo();
        // TODO
    }
    void carregarCombo(){
        tipo_pagemnto_cbox.getItems().setAll(SituacaoCarne.values());
    }
    
    void initCarne(){
        liquidaCarne = ver_FinanceiroController.getLc();
        
    }
    
        void cadastrar() throws IOException{
        liquidaCarne = ver_FinanceiroController.getLc();
        carne_Pagamento.setData_pago(data_pag.getValue());
        liquidaCarne.setSituacaoCarne(tipo_pagemnto_cbox.getValue());
        liquidaCarne.setCarne_Pagamento(carne_Pagamento);
        
        try {
            Facade.getInstance().inserirOuAtualizarLiquidaCarne(liquidaCarne);
            Mensagem.getInstance().mostrarMensagem("Carne", "Atualização feita com sucesso", Alert.AlertType.INFORMATION);
             App.genericaStage(ALTERAR_CARNE).close();
        } catch (BussinesException ex) {
            Logger.getLogger(Cadastrar_CarneController.class.getName()).log(Level.SEVERE, null, ex);
            Mensagem.getInstance().mostrarMensagem("Carne", "Erro ao atualizar carne ", Alert.AlertType.ERROR);
        }
    
    }
    
}
