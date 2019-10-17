/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.argus.view;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 *
 * @author santo
 */
public class Mensagem {
    
    private static Mensagem instance;
    private Alert alert;
    
    
    private Mensagem(){
    alert = new Alert(Alert.AlertType.INFORMATION);
    }
    
    public void verMensagem(AlertType type, String titulo, String h, String mensagem){
        
        alert.setAlertType(type);
        alert.setTitle(titulo);
        alert.setHeaderText(h);
        alert.setContentText(mensagem);
    }
    
    public static Mensagem getInsMensagem(){
        if(instance == null){
        instance = new Mensagem();
        } return instance;
        
    }
}
