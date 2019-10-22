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
public class Mensagem extends Alert{
   
	private static Mensagem instance;
	
	public Mensagem() {
		super(AlertType.INFORMATION);
	}
	
	public static Mensagem getInstance() {
		if(instance == null)
			instance = new Mensagem();
		return instance;
	}
	
	public void mostrarMensagem(String titulo, String msg, AlertType tipo) {
		instance.setAlertType(tipo);
		instance.setTitle(titulo);
		instance.setContentText(msg);
		instance.show();
	}
        
        public void confirmar(String t, String m, AlertType tipo){
                instance.setAlertType(tipo);
		instance.setTitle(t);
		instance.setContentText(m);
		instance.show();
            
        }
}
