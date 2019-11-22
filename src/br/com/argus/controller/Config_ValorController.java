/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.argus.controller;

import br.com.argus.util.MaskField;
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
    
    private  static double EM_valor = 800;
    private  static double EFF_valor = 600;
    private  static double EFI_valor = 400;
    
    
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
        MaskField.numericField(valor_EM);
        MaskField.numericField(valor_final_EF);
        MaskField.numericField(valor_inicial_EF);
    } 
    
    void converterInt(){

        String Newvalor_final_EF = valor_final_EF.getText();
        String Newvalor_inicial_EF = valor_EM.getText();
        String Newvalor_EM = valor_inicial_EF.getText();
        
        int EF_incial = Integer.parseInt(Newvalor_final_EF);
        int EF_final = Integer.parseInt(Newvalor_final_EF);
        int EM = Integer.parseInt(Newvalor_EM);
    }

    public static double getEM_valor() {
        return EM_valor;
    }

    public static void setEM_valor(double EM_valor) {
        Config_ValorController.EM_valor = EM_valor;
    }

    public static double getEFF_valor() {
        return EFF_valor;
    }

    public static void setEFF_valor(double EFF_valor) {
        Config_ValorController.EFF_valor = EFF_valor;
    }

    public static double getEFI_valor() {
        return EFI_valor;
    }

    public static void setEFI_valor(double EFI_valor) {
        Config_ValorController.EFI_valor = EFI_valor;
    }
    
    
}
