/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.argus.controller;

import br.com.argus.exceptions.BussinesException;
import br.com.argus.facade.Facade;
import br.com.argus.model.VinculoAlunoTurma;
import br.com.argus.view.Mensagem;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Hakkinen
 */
public class Cadastar_NotaController implements Initializable {
    private static VinculoAlunoTurma vinculoAlunoTurma, carregadoVinculoAluno;
    private Ver_Notas_AlunoController alunoController;
    double nm ;
    double nmf;
    
    @FXML
    private TextField nota1;

    @FXML
    private TextField nota3;

    @FXML
    private TextField nota2;

    @FXML
    private TextField nota4;

    @FXML
    void salvar(ActionEvent event) {
        cadastrar();
    }

    @FXML
    void voltar(ActionEvent event) {

    }
    
    @FXML
    void imprimir(ActionEvent event) {
        
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initVinculo();
    }   
    
    void cadastrar(){
        
        vinculoAlunoTurma = alunoController.getVAT();
        calculoMedia();
//        vinculoAlunoTurma.setNota1(0);
//        vinculoAlunoTurma.setNota2(0);
//        vinculoAlunoTurma.setNota3(0);
//        vinculoAlunoTurma.setNota4(0);
        
        
        try {
            Facade.getInstance().inserirOuAtualizarVincAlunoTurma(vinculoAlunoTurma);
            Mensagem.getInstance().mostrarMensagem("Cadastro Notas", "Cadastro realizado com sucesso", Alert.AlertType.INFORMATION);
        } catch (BussinesException ex) {
           ex.printStackTrace();
           Mensagem.getInstance().mostrarMensagem("Cadastro Notas", "Erro ao realizar cadastro", Alert.AlertType.ERROR);
        }
        
    }
    
    void initVinculo(){
    
           carregadoVinculoAluno = alunoController.getVAT();
    }
    
    void calculoMedia(){
        double nn = 7;
        double nn1 = Double.parseDouble(nota1.getText());
        double nn2 = Double.parseDouble(nota2.getText());
        double nn3 = Double.parseDouble(nota3.getText());
        double nn4 = Double.parseDouble(nota4.getText());
        double media = (nn1+nn2+nn3+nn4)/4;
        if(media >= 7){
             nm = media;
             nmf = 0;
        }else{
             nm = media;
             nmf = media;
        }

        vinculoAlunoTurma.setNota1(nn1);
        vinculoAlunoTurma.setNota2(nn2);
        vinculoAlunoTurma.setNota3(nn3);
        vinculoAlunoTurma.setNota4(nn4);
        vinculoAlunoTurma.setMedia(nm);
        vinculoAlunoTurma.setMediaFinal(nmf);
        
    }
    
    void gerarPdf(){
    
        
    }
        
    
}
